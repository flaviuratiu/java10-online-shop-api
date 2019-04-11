package org.fasttrackit.onlineshopapi.persistence;

import org.fasttrackit.onlineshopapi.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

// Long is wrapper for primitive long
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(
            String partialName, int minimumQuantity, Pageable pageable);

    Page<Product> findByPriceBetweenAndQuantityGreaterThanEqual(
            double minimumPrice, double maximumPrice,
            int minimumQuantity, Pageable pageable);

    Page<Product> findByNameContainingAndPriceBetweenAndQuantityGreaterThanEqual(
            String partialName, double minimumPrice, double maximumPrice,
            int minimumQuantity, Pageable pageable);

    Page<Product> findByNameContaining(String partialName, Pageable pageable);

    // same result as the method above (except the returned columns)
//    @Query("SELECT id, name FROM product WHERE name LIKE %?1")
//    Page<Product> findByPartialName(String partialName, Pageable pageable);

}
