package s3_gps_ivanti.business.impl.dtoconverter;

import s3_gps_ivanti.DTO.*;
import s3_gps_ivanti.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDTOConverter {
    private ReviewDTOConverter(){

    }
    public static Review convertToModelForCreate(CreateReviewRequestDTO dto){
        return Review.builder()
                .customer(CustomerDTOConverter.convertToModel(dto.getCustomer()))
                .rating(dto.getRating())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
    public static Review convertToModelForUpdate(UpdateReviewRequestDTO dto){
        return Review.builder()
                .id(dto.getId())
                .customer(CustomerDTOConverter.convertToModel(dto.getCustomer()))
                .rating(dto.getRating())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
    public static ViewReviewDTO convertToDTO(Review review){
        return ViewReviewDTO.builder()
                .id(review.getId())
                .customer(review.getCustomer().getFirstName()+" "+review.getCustomer().getLastName())
                .rating(review.getRating())
                .description(review.getDescription())
                .title(review.getTitle())
                .build();
    }
    public static List<ViewReviewDTO> convertToDTOList(List<Review> reviews){
        List<ViewReviewDTO> dtoList = new ArrayList<>();

        for (Review r : reviews){
            dtoList.add(convertToDTO(r));
        }
        return dtoList;
    }
}
