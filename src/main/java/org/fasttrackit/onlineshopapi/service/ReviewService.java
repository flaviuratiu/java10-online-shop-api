package org.fasttrackit.onlineshopapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineshopapi.domain.Review;
import org.fasttrackit.onlineshopapi.persistence.ReviewRepository;
import org.fasttrackit.onlineshopapi.transfer.review.CreateReviewRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);

    private final ReviewRepository reviewRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ObjectMapper objectMapper) {
        this.reviewRepository = reviewRepository;
        this.objectMapper = objectMapper;
    }

    public Review createReview(CreateReviewRequest request) {
        Review review = objectMapper.convertValue(request, Review.class);

        return reviewRepository.save(review);
    }

    public Page<Review> getReviews(long productId, Pageable pageable) {
        return reviewRepository.findByProductId(productId, pageable);
    }
}
