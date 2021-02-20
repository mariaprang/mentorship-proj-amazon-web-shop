package webshop_app_spring.demo.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "reviews")
public class Rating extends BaseEntity {

    private float stars;
    private String comment;
    private String headline;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product ratedProduct;

//    @OneToMany(mappedBy="cart")
//    private Set<User> users;

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

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
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