package dev.kavya.movies.service;

import dev.kavya.movies.entity.Movie;
import dev.kavya.movies.entity.Review;
import dev.kavya.movies.repository.MovieRepository;
import dev.kavya.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Review createReview(String body, String imdbId)
    {
        Review review = reviewRepository.insert(new Review(body));

        // same to b done in movie as well
        Optional<Movie> movie = movieRepository.findByImdbId(imdbId);
        if(movie.isPresent())
        {
            movie.get().getReviewIds().add(review);
            movieRepository.save(movie.get());
        }

        return review;
    }
}
