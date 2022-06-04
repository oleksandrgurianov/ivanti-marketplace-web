package s3_gps_ivanti.business.dtoconvertor;

import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.ReviewDTO;
import s3_gps_ivanti.dto.review.UpdateReviewDTO;
import s3_gps_ivanti.repository.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDTOConverter {
    private ReviewDTOConverter(){}

    public static List<ReviewDTO> convertToListOfDTO(List<Review> reviews) {
        List<ReviewDTO> result = new ArrayList<>();

        for (Review r:reviews) {
            result.add(ReviewDTOConverter.convertToDTOForView(r));
        }

        return result;
    }

    private static ReviewDTO convertToDTOForView(Review r) {
        return ReviewDTO.builder()
                .customerName(r.getCustomer().getUsername())
                .rating(r.getRating())
                .title(r.getTitle())
                .description(r.getDescription())
                .reply(ReplyDTOConverter.convertToDTO(r.getReply()))
                .build();
    }

    public static UpdateReviewDTO convertToDTOForUpdate(Review r) {
        return UpdateReviewDTO.builder()
                .id(r.getId())
                .applicationName(r.getApplicationName())
                .customerName(r.getCustomer().getUsername())
                .rating(r.getRating())
                .title(r.getTitle())
                .description(r.getDescription())
                .build();
    }

    public static Review convertToEntityCreate(CreateReviewRequestDTO review) {
        return Review.builder()
                .applicationName(review.getApplicationName())
                .rating(review.getRating())
                .title(review.getTitle())
                .description(review.getDescription())
                .reply(null)
                .build();
    }
}
