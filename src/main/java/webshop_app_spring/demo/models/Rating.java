package webshop_app_spring.demo.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Rating extends BaseEntity {

    private float stars;
    private String comment;
    private String headline;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product ratedProduct;

    public Rating() {
    }
    public Rating(String headline, int stars, String comment){
        this.headline = headline;
        this.stars = stars;
        this.comment = comment;
    }



    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public Product getRatedProduct() {
        return ratedProduct;
    }

    public void setRatedProduct(Product ratedProduct) {
        this.ratedProduct = ratedProduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "stars=" + stars +
                ", comment='" + comment + '\'' +
                ", headline='" + headline + '\'' +
                ", ratedProduct=" + ratedProduct +
                '}';
    }
}