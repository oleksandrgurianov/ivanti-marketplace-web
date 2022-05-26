package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.CreateReviewResponseDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Review;

import javax.transaction.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class CreateReviewUseCaseImpl implements CreateReviewUseCase {

    private final ReviewRepository reviewRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public CreateReviewResponseDTO createReview(CreateReviewRequestDTO request) {
        applicationIdIsValid(request.getApplicationID().toString());

        Review review = reviewRepository.save(ReviewDTOConverter.convertToEntityCreate(request));

        return CreateReviewResponseDTO.builder()
                .id(review.getId())
                .build();
    }

    private void applicationIdIsValid(String id){
        if(!applicationRepository.existsById(id)){
            throw new ApplicationNotFoundException();
        }
    }
}
