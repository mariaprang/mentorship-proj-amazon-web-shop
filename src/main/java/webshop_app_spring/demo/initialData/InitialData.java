package webshop_app_spring.demo.initialData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.models.ProductCategory;
import webshop_app_spring.demo.models.Rating;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.repositories.RatingRepository;
import webshop_app_spring.demo.services.CustomerDetails;
import webshop_app_spring.demo.services.ProductService;
import webshop_app_spring.demo.services.RatingService;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerDetails customerDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RatingService ratingService;

    @PostConstruct
    public void createDummyData() {

        User user = new User("test@gmail.com", passwordEncoder.encode("test"), "Maria", "Prang");

        Rating rating = new Rating("Was good, recommend", 4, "Nice experience");
        Rating rating2 = new Rating("Was not good, don't recommend", 2, "Nice experience");
        Rating rating3 = new Rating("Excellent!", 5, "Nice experience");
        Rating rating4 = new Rating("A 'okay' ", 3, "Nice experience");
        Rating rating5 = new Rating("Very bad", 1, "Nice experience");
        Rating rating6 = new Rating("Awesome!", 5, "Nice experience");


        Product product1 = new Product("Original shoes", 80.55,
                "Lorem ipsum dolor sit amet", "image/shoe.png", ProductCategory.SHOES, false, true, false);

        product1.getProductReviews().add(rating);
        Product product2 = new Product("Are you my mother?", 8, "KIDS BOOK", "image/mother.jpg", ProductCategory.BOOKS, true, true, false);
        product2.getProductReviews().add(rating2);
        Product product3 = new Product("Go DOG", 8, "KIDS BOOK", "image/Go Dog.jpg", ProductCategory.BOOKS, true, true, false);
        product3.getProductReviews().add(rating3);
        Product product4 = new Product("Nike shoe", 80.55, "Nike shoes", "image/nike.jpg", ProductCategory.SHOES, false, true, true);
        product4.getProductReviews().add(rating4);
        Product product5 = new Product("Head phone", 26, "Head phone", "image/headphone.jpg", ProductCategory.ELECTRONICS, false, true, true);
        product5.getProductReviews().add(rating5);


        product1.setDetailedDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        product2.setDetailedDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        product3.setDetailedDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        product4.setDetailedDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        product5.setDetailedDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);
        productService.saveProduct(product4);
        productService.saveProduct(product5);


        rating.setRatedProduct(product1);
        rating2.setRatedProduct(product2);
        rating6.setRatedProduct(product2);
        rating3.setRatedProduct(product3);
        rating4.setRatedProduct(product4);
        rating5.setRatedProduct(product5);


        ratingService.saveRating(rating);
        ratingService.saveRating(rating2);
        ratingService.saveRating(rating3);
        ratingService.saveRating(rating4);
        ratingService.saveRating(rating5);
        ratingService.saveRating(rating6);


        customerDetailsService.registerUser(user);
    }
}
