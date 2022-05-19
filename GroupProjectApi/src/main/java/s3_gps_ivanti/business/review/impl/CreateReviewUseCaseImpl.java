package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@Primary
@RequiredArgsConstructor
public class CreateReviewUseCaseImpl implements CreateReviewUseCase {

    private final ApplicationRepository applicationRepository;

    @Override
    public void createReview(CreateReviewRequestDTO review) {

    }
}
