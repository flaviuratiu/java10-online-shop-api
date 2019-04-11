package org.fasttrackit.onlineshopapi.persistence;

import org.fasttrackit.onlineshopapi.domain.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
