package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.exception.ReviewByCustomerAlreadyExistException;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.business.validation.ApplicationNameValidation;
import s3_gps_ivanti.business.validation.CustomerUsernameValidation;
import s3_gps_ivanti.dto.login.AccessTokenDTO;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.CreateReviewResponseDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

import javax.transaction.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class CreateReviewUseCaseImpl implements CreateReviewUseCase {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final UpdateRating updateRating;
    private final ApplicationNameValidation applicationIsValid;
    private final CustomerUsernameValidation customerIsValid;

    @Override
    public CreateReviewResponseDTO createReview(CreateReviewRequestDTO request) {
        applicationIsValid.applicationIdIsValid(request.getApplicationName());
        customerIsValid.customerIsValid(request.getCustomerName());

        User user = userRepository.findUserByUsername(request.getCustomerName());

        if(reviewRepository.existsByCustomerAndAndApplicationName(user, request.getApplicationName())){
            throw new ReviewByCustomerAlreadyExistException();
        }

        Review savedReview = saveReview(request);

        updateRating.addAppRating(request.getApplicationName(), request.getRating());

        return CreateReviewResponseDTO.builder()
                .id(savedReview.getId())
                .build();
    }
    private Review saveReview(CreateReviewRequestDTO request){
        User user = userRepository.findUserByUsername(request.getCustomerName());

        Review review = ReviewDTOConverter.convertToEntityCreate(request);
        review.setCustomer(user);

        return reviewRepository.save(review);
    }
}
