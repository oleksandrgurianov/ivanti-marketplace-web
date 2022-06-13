package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.exception.InvalidReviewException;
import s3_gps_ivanti.business.review.GetReviewByCustomerAndApp;
import s3_gps_ivanti.business.validation.ApplicationNameValidation;
import s3_gps_ivanti.business.validation.CustomerUsernameValidation;
import s3_gps_ivanti.dto.review.UpdateReviewDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

@Service
@Primary
@RequiredArgsConstructor
public class GetReviewByCustomerAndAppImpl implements GetReviewByCustomerAndApp {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ApplicationNameValidation appValidation;
    private final CustomerUsernameValidation userValidation;

    @Override
    public UpdateReviewDTO getReviewByCustomerAndApp(String customer, String application) {
        userValidation.customerIsValid(customer
        );
        User user = userRepository.findUserByUsername(customer);
        appValidation.applicationIdIsValid(application);

        if(reviewRepository.existsByCustomerAndAndApplicationName(user, application)){
            Review review = reviewRepository.findByCustomerAndAndApplicationName(user, application);
            return ReviewDTOConverter.convertToDTOForUpdate(review);
        }
        throw new InvalidReviewException("REVIEW_DOES_NOT_EXIST");
    }
}
