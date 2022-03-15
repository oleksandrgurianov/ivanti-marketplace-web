package com.example.Individual_Project.controller;

import com.example.Individual_Project.business.ResponseService;
import com.example.Individual_Project.business.ReviewService;
import com.example.Individual_Project.business.UserService;
import com.example.Individual_Project.model.Application;
import com.example.Individual_Project.model.Review;
import com.example.Individual_Project.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewControle {

    private final ReviewService reviewService;
    private final UserService userService;

    @GetMapping("sort/{rating}/{date}")
    public ResponseEntity<ArrayList<Review>> getReviewsSorted(@PathVariable("rating") boolean rating, @PathVariable("date") boolean date, @RequestBody String username, @RequestBody String password) {
        User user = userService.getUser(username, password);
        if(user != null) {
            ArrayList<Review> reviews = reviewService.getReviewsSorted(rating, date);

            if(reviews != null) {
                return ResponseEntity.ok().body(reviews);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("filter/{rating}/{date}")
    public ResponseEntity<ArrayList<Review>> getReviews(@PathVariable("rating") boolean rating, @PathVariable("date") boolean date, @RequestBody String username, @RequestBody String password) {
        User user = userService.getUser(username, password);
        if(user != null) {
            ArrayList<Review> reviews = reviewService.getReviews(rating, date);

            if(reviews != null) {
                return ResponseEntity.ok().body(reviews);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @PostMapping()
    public ResponseEntity createReview(@RequestBody String username, @RequestBody String password, @RequestBody Review review) {
        User user = userService.getUser(username, password);
        if(user != null) {
            if(reviewService.createReview(review)) {
                return ResponseEntity.ok().build();
            }
            else {
                return new ResponseEntity("Error", HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @PutMapping()
    public ResponseEntity updateReview(@RequestBody String username, @RequestBody String password, @RequestBody Review review) {
        User user = userService.getUser(username, password);
        if(user != null) {
            if (reviewService.updateReview(review, user)) {
                return ResponseEntity.noContent().build();
            }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping({"reviewID"})
    public ResponseEntity deleteReview(@PathVariable("reviewID")int reviewID, String username, String password) {
        User user = userService.getUser(username, password);
        if(user != null) {
            boolean result = reviewService.deleteReview(reviewID, user);

            if (result == true) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }
}
