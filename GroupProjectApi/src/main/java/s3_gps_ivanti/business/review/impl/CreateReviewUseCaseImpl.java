package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoConvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Review;

@Service
@Primary
@RequiredArgsConstructor
public class CreateReviewUseCaseImpl implements CreateReviewUseCase {

    private final ApplicationRepository applicationRepository;

    @Override
    public void createReview(CreateReviewRequestDTO review) {
       Application application = applicationRepository.findById(review.getApplicationID()).orElse(null);

       if(application == null) {
           throw new ApplicationNotFoundException();
       }

       application.getReviews().add(ReviewDTOConverter.ConvertToEntityCreate(review));

       applicationRepository.save(application);
    }
}
