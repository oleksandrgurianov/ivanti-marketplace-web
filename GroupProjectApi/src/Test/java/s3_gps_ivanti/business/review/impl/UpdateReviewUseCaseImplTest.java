package s3_gps_ivanti.business.review.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import s3_gps_ivanti.business.dtoconvertor.ReplyDTOConverter;
import s3_gps_ivanti.business.validation.ReviewIDValidation;
import s3_gps_ivanti.dto.response.ReplyDTO;
import s3_gps_ivanti.dto.review.CreateUpdateDeleteReplyDTO;
import s3_gps_ivanti.dto.review.UpdateReviewRequestDTO;
import s3_gps_ivanti.repository.ReviewRepository;
import s3_gps_ivanti.repository.entity.Review;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateReviewUseCaseImplTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private ReviewIDValidation idValidCheck;
    @InjectMocks
    private UpdateReviewUseCaseImpl updateReviewUseCase;

    @Test
    void updateReview() {
        UpdateReviewRequestDTO request = UpdateReviewRequestDTO.builder()
                .id("id")
                .rating(5)
                .title("title")
                .description("description")
                .build();
        Review oldReview = Review.builder()
                .id("id")
                .rating(1)
                .description("oldDescription")
                .title("oldTile")
                .build();
        Review newReview = Review.builder()
                .id("id")
                .rating(5)
                .description("description")
                .title("title")
                .build();

        when(reviewRepository.findById("id"))
                .thenReturn(Optional.ofNullable(oldReview));
        when(reviewRepository.save(newReview))
                .thenReturn(newReview);

        updateReviewUseCase.updateReview(request);

        verify(idValidCheck).reviewInvalid("id");
        verify(reviewRepository).findById("id");
        verify(reviewRepository).save(newReview);
    }

    @Test
    void replyAction() {

        ReplyDTO replyDTO = ReplyDTO.builder()
                .title("title")
                .description("description")
                .build();
        CreateUpdateDeleteReplyDTO request = CreateUpdateDeleteReplyDTO.builder()
                .id("id")
                .reply(replyDTO)
                .build();
        Review oldReview = Review.builder()
                .id("id")
                .rating(1)
                .description("oldDescription")
                .title("oldTile")
                .build();
        Review newReview = Review.builder()
                .id("id")
                .rating(1)
                .description("oldDescription")
                .title("oldTile")
                .reply(ReplyDTOConverter.convertToEntity(replyDTO))
                .build();

        when(reviewRepository.findById("id"))
                .thenReturn(Optional.ofNullable(oldReview));
        when(reviewRepository.save(newReview))
                .thenReturn(newReview);

        updateReviewUseCase.replyAction(request);

        verify(idValidCheck).reviewInvalid("id");
        verify(reviewRepository).findById("id");
        verify(reviewRepository).save(newReview);
    }
}