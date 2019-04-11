package org.fasttrackit.onlineshopapi;

import org.fasttrackit.onlineshopapi.domain.Product;
import org.fasttrackit.onlineshopapi.domain.Review;
import org.fasttrackit.onlineshopapi.service.ReviewService;
import org.fasttrackit.onlineshopapi.steps.ProductSteps;
import org.fasttrackit.onlineshopapi.transfer.review.CreateReviewRequest;
import org.fasttrackit.onlineshopapi.transfer.ProductIdentifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceIntegrationTests {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductSteps productSteps;

    @Test
    public void createReview_whenValidRequest_thenReturnCreatedReviewWithId() {
        Product product = productSteps.createProduct();

        CreateReviewRequest reviewRequest = new CreateReviewRequest();
        reviewRequest.setAuthor("FLaviu");
        reviewRequest.setContent("forte fain");
        reviewRequest.setCreationDate(LocalDateTime.now());
        reviewRequest.setProduct(new ProductIdentifier(product.getId()));

        Review review = reviewService.createReview(reviewRequest);

        assertThat(review, notNullValue());
        assertThat(review.getId(), greaterThan(0L));

        Page<Review> reviews = reviewService.getReviews(product.getId(), PageRequest.of(0, 20));

        System.out.println("lazy id " + reviews.getContent().get(0).getProduct().getId());

        assertThat(review, notNullValue());

    }
}
