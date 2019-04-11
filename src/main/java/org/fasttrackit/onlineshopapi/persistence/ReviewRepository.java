package org.fasttrackit.onlineshopapi.persistence;

import org.fasttrackit.onlineshopapi.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    Page<Review> findByProductId(long productId, Pageable pageable);
}
