package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.business.ReviewService;
import s3_gps_ivanti.business.impl.dtoconverter.ReviewDTOConverter;
import s3_gps_ivanti.dto.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.UpdateReviewRequestDTO;
import s3_gps_ivanti.model.Review;
import s3_gps_ivanti.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public boolean createReview(CreateReviewRequestDTO review){
        return reviewRepository.createReview(ReviewDTOConverter.convertToModelForCreate(review));
    }
    @Override
    public boolean updateReview(UpdateReviewRequestDTO review){
        return reviewRepository.updateReview(ReviewDTOConverter.convertToModelForUpdate(review));
    }
    @Override
    public boolean deleteReview(int reviewID){
        return reviewRepository.deleteReview(reviewID);
    }
}
