package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.review.UpdateReviewUseCase;
import s3_gps_ivanti.dto.review.UpdateReviewRequestDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.ReviewRepository;

@Service
@Primary
@RequiredArgsConstructor
public class UpdateReviewUseCaseImpl implements UpdateReviewUseCase {

    private final ReviewRepository reviewRepository;

    @Override
    public void updateReview(UpdateReviewRequestDTO review) {
        reviewRepository.save(ReviewDTOConverter.convertToEntityUpdate(review));
    }
}
