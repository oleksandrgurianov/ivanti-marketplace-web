package s3_gps_ivanti.controller;

import s3_gps_ivanti.business.ReviewService;
import s3_gps_ivanti.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ReviewController {

    private final ReviewService reviewService;

    //all
    @GetMapping("{appName}")
    public ResponseEntity<ArrayList<Review>> getReview(String appName) {

        ArrayList<Review> reviews = reviewService.getReviews(appName);

        if(reviews.size() > 0) {
            return ResponseEntity.ok().body(reviews);
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    //Customer
    @PostMapping()
    public ResponseEntity<Object>  createReview(@RequestBody Review review) {

        if (reviewService.createReview(review)) {
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.status( HttpStatus.CONFLICT).build();
        }
    }
    @PutMapping()
    public ResponseEntity<Object>  updateReview(@RequestBody Review review) {
        if (reviewService.updateReview(review)) {
            return ResponseEntity.noContent().build();

        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @DeleteMapping({"reviewID"})
    public ResponseEntity<Object>  deleteReview(@PathVariable("reviewID")int reviewID) {

        boolean result = reviewService.deleteReview(reviewID);
        if (result == true) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
