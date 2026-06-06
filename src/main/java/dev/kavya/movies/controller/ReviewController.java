package dev.kavya.movies.controller;

import dev.kavya.movies.entity.Review;
import dev.kavya.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping( "review/api" )
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createNewReview(@RequestBody Map<String, String> playLoad)
    {
        return new ResponseEntity<>(reviewService.createReview(playLoad.get("reviewBody"),playLoad.get("imdbId")), HttpStatus.CREATED);
    }
}
