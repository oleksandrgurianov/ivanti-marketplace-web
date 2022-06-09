package s3_gps_ivanti.business.review.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import s3_gps_ivanti.business.validation.ReviewIDValidation;
import s3_gps_ivanti.repository.ReviewRepository;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteReviewUseCaseImplTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private ReviewIDValidation idValidCheck;
    @InjectMocks
    private DeleteReviewUseCaseImpl deleteReviewUseCase;

    @Test
    void deleteReview() {
        deleteReviewUseCase.deleteReview("reviewID");

        verify(idValidCheck).reviewInvalid("reviewID");
        verify(reviewRepository).deleteById("reviewID");
    }
}