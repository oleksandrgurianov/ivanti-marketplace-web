package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.business.exception.CustomerNotFoundException;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.business.validitycheck.ApplicationIDValidCheck;
import s3_gps_ivanti.business.validitycheck.CustomerUsernameValidCheck;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.CreateReviewResponseDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
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
    private final ApplicationIDValidCheck applicationIsValid;
    private final CustomerUsernameValidCheck customerIsValidCheck;

    @Override
    public CreateReviewResponseDTO createReview(CreateReviewRequestDTO request) {
        applicationIsValid.applicationIdIsValid(request.getApplicationID());
        customerIsValidCheck.customerIsValid(request.getCustomer());

        User user = userRepository.findUserByUsername(request.getCustomer());

        Review review = ReviewDTOConverter.convertToEntityCreate(request);
        review.setCustomer(user);

        Review savedReview = reviewRepository.save(review);

        return CreateReviewResponseDTO.builder()
                .id(savedReview.getId())
                .build();
    }
}
