package s3_gps_ivanti.business.review.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import s3_gps_ivanti.business.dtoconvertor.ReviewDTOConverter;
import s3_gps_ivanti.business.validation.ApplicationIDValidation;
import s3_gps_ivanti.business.validation.CustomerUsernameValidation;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.CreateReviewResponseDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateReviewUseCaseImplTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ApplicationIDValidation applicationIsValid;
    @Mock
    private CustomerUsernameValidation customerIsValidCheck;
    @InjectMocks
    private CreateReviewUseCaseImpl createReviewUseCase;

    @Test
    void createReview() {

        CreateReviewRequestDTO requestDTO = CreateReviewRequestDTO.builder()
                .customer("customer")
                .applicationID("applicationID")
                .rating(5)
                .title("title")
                .description("description")
                .build();


        User user = User.builder()
                .id("id")
                .username("creatorName")
                .email("email")
                .password("password")
                .roles(List.of("role"))
                .permission("permission")
                .build();

        Review review = ReviewDTOConverter.convertToEntityCreate(requestDTO);
        review.setCustomer(user);

        when(userRepository.findUserByUsername("customer"))
                .thenReturn(user);
        when(reviewRepository.save(review))
                .thenReturn(review);

        CreateReviewResponseDTO actualResult = createReviewUseCase.createReview(requestDTO);
        CreateReviewResponseDTO expectedResult = CreateReviewResponseDTO.builder()
                .id(null)
                .build();

        assertEquals(expectedResult,actualResult);

        verify(applicationIsValid).applicationIdIsValid("applicationID");
        verify(customerIsValidCheck).customerIsValid("customer");
    }
}