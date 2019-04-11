package org.fasttrackit.onlineshopapi.transfer.review;

import org.fasttrackit.onlineshopapi.transfer.ProductIdentifier;

import java.time.LocalDateTime;

public class CreateReviewRequest {

    private String content;
    private String author;
    private LocalDateTime creationDate;
    private ProductIdentifier product;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ProductIdentifier getProduct() {
        return product;
    }

    public void setProduct(ProductIdentifier product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CreateReviewRequest{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", product=" + product +
                '}';
    }
}
