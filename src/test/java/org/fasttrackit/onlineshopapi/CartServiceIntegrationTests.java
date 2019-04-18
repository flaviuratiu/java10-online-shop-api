package org.fasttrackit.onlineshopapi;

import org.fasttrackit.onlineshopapi.domain.Cart;
import org.fasttrackit.onlineshopapi.domain.Customer;
import org.fasttrackit.onlineshopapi.domain.Product;
import org.fasttrackit.onlineshopapi.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshopapi.persistence.CustomerRepository;
import org.fasttrackit.onlineshopapi.service.CartService;
import org.fasttrackit.onlineshopapi.steps.ProductSteps;
import org.fasttrackit.onlineshopapi.transfer.CreateCartRequest;
import org.fasttrackit.onlineshopapi.transfer.ProductIdentifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegrationTests {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductSteps productSteps;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void createCart_whenValidRequest_thenReturnCreatedCartWithId() throws ResourceNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test");

        // todo: use service here
        customer = customerRepository.save(customer);

        Product product = productSteps.createProduct();

        CreateCartRequest cartRequest = new CreateCartRequest();
        cartRequest.setProducts(Collections.singleton(new ProductIdentifier(product.getId())));
        cartRequest.setCustomerId(customer.getId());

        Cart cart = cartService.createCart(cartRequest);

        assertThat(cart, notNullValue());
        assertThat(cart.getId(), greaterThan(0L));
        assertThat(cart.getProducts(), hasSize(1));
    }
}
