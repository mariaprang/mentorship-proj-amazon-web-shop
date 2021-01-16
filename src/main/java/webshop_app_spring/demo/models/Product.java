package webshop_app_spring.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String productTitle;
    private double productPrice;
    private String description;
    private String detailedDescription;
    private String imagePath;
    private ProductCategory productCategory;
    private boolean forKids;
    private boolean forMen;
    private boolean forWomen;
    private double rating;
    @OneToMany(mappedBy="ratedProduct")
    private List<Rating> productReviews;

    private int ratings;

    private ArrayList<User> usersPurchasedTheProduct;

    @ManyToOne
    private Cart cart;

    public Product() {
        this.usersPurchasedTheProduct = new ArrayList<>();
        this.productReviews = new ArrayList<>();
    }

    public Product(String productTitle, double productPrice, String description, String imagePath,
                   ProductCategory productCategory, boolean kids, boolean women, boolean men) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.description = description;
        this.imagePath = imagePath;
        this.productCategory = productCategory;
        this.rating = 0;
        this.ratings = 0;
        this.usersPurchasedTheProduct = new ArrayList<>();
        this.productReviews = new ArrayList<>();
    }

    public List<Rating> getProductReviews() {
        return productReviews;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getProductPrice(), getProductPrice()) == 0 &&
                Objects.equals(getProductTitle(), product.getProductTitle()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getImagePath(), product.getImagePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductTitle(), getProductPrice(), getDescription(), getImagePath());
    }

}
