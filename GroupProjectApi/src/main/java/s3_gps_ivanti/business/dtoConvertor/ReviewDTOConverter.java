package s3_gps_ivanti.business.dtoConvertor;

import lombok.RequiredArgsConstructor;
import s3_gps_ivanti.dto.review.ReviewDTO;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDTOConverter {

    public static List<ReviewDTO> convertToListOfDTO(List<Review> reviews) {

        List<ReviewDTO> result = new ArrayList<>();

        for (Review r:reviews) {
            result.add(ReviewDTOConverter.ConvertToDTO(r));
        }

        return result;
    }

    private static ReviewDTO ConvertToDTO(Review r) {

        return ReviewDTO.builder()

                .build();
    }
}
