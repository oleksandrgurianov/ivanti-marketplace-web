package S3_GPS_Ivanti.controller;

<<<<<<< HEAD:GroupProjectApi/src/main/java/S3_GPS_Ivanti/controller/ReviewController.java
import S3_GPS_Ivanti.business.ReviewService;
import S3_GPS_Ivanti.business.UserService;
import S3_GPS_Ivanti.model.Review;
import S3_GPS_Ivanti.model.User;
=======
import com.example.S3_GPS_Ivanti.business.ReviewService;

import com.example.S3_GPS_Ivanti.model.*;
>>>>>>> 75208ff8c276fbe9838fb7b8e36d120aec7926ff:GroupProjectApi/src/main/java/com/example/S3_GPS_Ivanti/controller/ReviewController.java
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewController {

    private final ReviewService reviewService;

    //all
    @GetMapping("{appName}")
    public ResponseEntity<ArrayList<Review>> createReview(String appName) {

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
    public ResponseEntity createReview(@RequestBody Review review) {

        if (reviewService.createReview(review)) {
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity("Error", HttpStatus.CONFLICT);
        }
    }

    @PutMapping()
    public ResponseEntity updateReview(@RequestBody Review review) {
        if (reviewService.updateReview(review)) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping({"reviewID"})
    public ResponseEntity deleteReview(@PathVariable("reviewID")int reviewID) {

        boolean result = reviewService.deleteReview(reviewID);
        if (result == true) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}