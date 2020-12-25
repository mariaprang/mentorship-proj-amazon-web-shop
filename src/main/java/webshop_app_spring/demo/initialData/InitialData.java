package webshop_app_spring.demo.initialData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.models.ProductCategory;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.services.CustomerDetails;
import webshop_app_spring.demo.services.ProductService;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerDetails customerDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createDummyData() {

        User user = new User("test@gmail.com", passwordEncoder.encode("test"),  "Maria", "Prang");

        Product product1 = new Product("Original shoes", 80.55,
                "Lorem ipsum dolor sit amet", "image/shoe.png", ProductCategory.CLOTHING, false, true, false);
        Product product2 = new Product("Are you my mother?", 8, "KIDS BOOK", "image/mother.jpg", ProductCategory.BOOKS, true, true, false);
        Product product3 = new Product("Go DOG", 8, "KIDS BOOK", "image/Go Dog.jpg", ProductCategory.BOOKS, true, true, false);
        Product product4 = new Product("Nike shoe", 80.55, "Nike shoes", "image/nike.jpg", ProductCategory.BOOKS, false, true, true);
        Product product5 = new Product("Head phone", 26, "Head phone", "image/headphone.jpg", ProductCategory.ELECTRONICS, false, true, true);


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

        customerDetailsService.registerUser(user);
    }
}
