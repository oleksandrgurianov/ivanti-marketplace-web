package s3_gps_ivanti.business.dtoConvertor;

import lombok.RequiredArgsConstructor;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.ReviewDTO;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.RatingAnalytics;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewDTOConverter {

    public static List<ReviewDTO> convertToListOfDTO(List<Review> reviews) {

        List<ReviewDTO> result = new ArrayList<>();

        for (Review r:reviews) {
            result.add(ReviewDTOConverter.convertToDTO(r));
        }

        return result;
    }

    private static ReviewDTO convertToDTO(Review r) {

        return ReviewDTO.builder()

                .build();
    }

    public static Review convertToEntityCreate(CreateReviewRequestDTO review) {
        return Review.builder()
                .customer(new User(review.getCustomerID()))
                .rating(review.getRating())
                .title(review.getTitle())
                .description(review.getDescription())
                .response(null)
                .build();
    }
}
