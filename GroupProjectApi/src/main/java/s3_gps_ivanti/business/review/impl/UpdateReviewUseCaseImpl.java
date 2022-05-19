package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.review.UpdateReviewUseCase;
import s3_gps_ivanti.dto.review.UpdateReviewRequestDTO;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@Primary
@RequiredArgsConstructor
public class UpdateReviewUseCaseImpl implements UpdateReviewUseCase {

    private final ApplicationRepository applicationRepository;

    @Override
    public void updateReview(UpdateReviewRequestDTO review) {

    }
}
