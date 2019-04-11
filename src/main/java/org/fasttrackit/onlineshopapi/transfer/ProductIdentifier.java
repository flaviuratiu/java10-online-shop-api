package org.fasttrackit.onlineshopapi.transfer;

public class ProductIdentifier {

    private long id;

    public ProductIdentifier() {
        // used for unmarshalling
    }

    public ProductIdentifier(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductIdentifier{" +
                "id=" + id +
                '}';
    }
}
