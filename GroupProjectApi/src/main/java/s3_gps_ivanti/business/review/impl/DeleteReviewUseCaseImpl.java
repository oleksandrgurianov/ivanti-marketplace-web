package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.application.DeleteApplicationUseCase;
import s3_gps_ivanti.business.review.DeleteReviewUseCase;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@Primary
@RequiredArgsConstructor
public class DeleteReviewUseCaseImpl implements DeleteReviewUseCase {

    private final ApplicationRepository applicationRepository;


    @Override
    public void deleteReview(String application, int customerID) {

    }
}
