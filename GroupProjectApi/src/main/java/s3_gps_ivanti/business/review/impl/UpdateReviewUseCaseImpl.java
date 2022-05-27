package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.review.UpdateReviewUseCase;
import s3_gps_ivanti.business.validitycheck.CustomerUsernameValidCheck;
import s3_gps_ivanti.business.validitycheck.ReviewIDValidCheck;
import s3_gps_ivanti.dto.review.UpdateReviewRequestDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

@Service
@Primary
@RequiredArgsConstructor
public class UpdateReviewUseCaseImpl implements UpdateReviewUseCase {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewIDValidCheck idValidCheck;

    @Override
    public void updateReview(UpdateReviewRequestDTO request) {
        idValidCheck.reviewInvalid(request.getId());

        User user = userRepository.findUserByUsername(request.getCustomer());

        Review review = ReviewDTOConverter.convertToEntityUpdate(request);
        review.setCustomer(user);

        reviewRepository.save(review);
    }
}
