package org.fasttrackit.onlineshopapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineshopapi.domain.Cart;
import org.fasttrackit.onlineshopapi.domain.Customer;
import org.fasttrackit.onlineshopapi.domain.Product;
import org.fasttrackit.onlineshopapi.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshopapi.persistence.CartRepository;
import org.fasttrackit.onlineshopapi.transfer.CreateCartRequest;
import org.fasttrackit.onlineshopapi.transfer.ProductIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerService customerService, ObjectMapper objectMapper) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Cart createCart(CreateCartRequest request) throws ResourceNotFoundException {
        Cart cart = new Cart();

        Customer customer = customerService.getCustomer(request.getCustomerId());

        cart.setCustomer(customer);

        for (ProductIdentifier productIdentifier : request.getProducts()) {
            Product product = objectMapper.convertValue(productIdentifier, Product.class);
            cart.addProduct(product);
        }

        return cartRepository.save(cart);
    }
}
