package org.fasttrackit.onlineshopapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineshopapi.domain.Cart;
import org.fasttrackit.onlineshopapi.domain.Product;
import org.fasttrackit.onlineshopapi.persistence.CartRepository;
import org.fasttrackit.onlineshopapi.transfer.CreateCartRequest;
import org.fasttrackit.onlineshopapi.transfer.ProductIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ObjectMapper objectMapper) {
        this.cartRepository = cartRepository;
        this.objectMapper = objectMapper;
    }

    public Cart createCart(CreateCartRequest request) {
        Cart cart = new Cart();

        for (ProductIdentifier productIdentifier : request.getProducts()) {
            Product product = objectMapper.convertValue(productIdentifier, Product.class);
            cart.addProduct(product);
        }

        return cartRepository.save(cart);
    }
}
