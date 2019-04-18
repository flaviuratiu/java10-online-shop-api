package org.fasttrackit.onlineshopapi.transfer;

import java.util.Set;

public class CreateCartRequest {

    private Set<ProductIdentifier> products;
    private long customerId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Set<ProductIdentifier> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductIdentifier> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CreateCartRequest{" +
                "products=" + products +
                '}';
    }
}
