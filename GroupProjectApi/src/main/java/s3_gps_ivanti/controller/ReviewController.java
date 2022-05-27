package s3_gps_ivanti.controller;


import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3_gps_ivanti.business.review.CreateReviewUseCase;
import s3_gps_ivanti.business.review.DeleteReviewUseCase;
import s3_gps_ivanti.business.review.UpdateReviewUseCase;
import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;
import s3_gps_ivanti.dto.review.UpdateReviewRequestDTO;

import java.util.ArrayList;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ReviewController {

   private final CreateReviewUseCase createReviewService;
   private final DeleteReviewUseCase deleteReviewService;
   private final UpdateReviewUseCase updateReviewService;

    @PostMapping()
    public ResponseEntity<Object>  createReview(@RequestBody CreateReviewRequestDTO review) {
        createReviewService.createReview(review);
        return ResponseEntity.ok().build();
    }
    @PutMapping()
    public ResponseEntity<Object>  updateReview(@RequestBody UpdateReviewRequestDTO review) {
        updateReviewService.updateReview(review);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{reviewID}")
    public ResponseEntity<Object>  deleteReview(@PathVariable("reviewID") String reviewID) {
        deleteReviewService.deleteReview(reviewID);
        return ResponseEntity.noContent().build();
    }
}
