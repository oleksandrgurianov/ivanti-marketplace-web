package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.review.GetReviewByCustomerAndApp;
import s3_gps_ivanti.dto.review.UpdateReviewDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.entity.Review;

@Service
@Primary
@RequiredArgsConstructor
public class GetReviewByCustomerAndAppImpl implements GetReviewByCustomerAndApp {
    private final ReviewRepository reviewRepository;

    @Override
    public UpdateReviewDTO getReviewByCustomerAndApp(String customer, String application) {
        Review review = reviewRepository.findByCustomerAndAndApplicationName(customer, application);
        return ReviewDTOConverter.convertToDTOForUpdate(review);
    }
}
