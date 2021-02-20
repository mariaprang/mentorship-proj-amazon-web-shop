package webshop_app_spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.models.Rating;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.repositories.UserRepository;
import webshop_app_spring.demo.services.ProductService;
import webshop_app_spring.demo.services.RatingService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/", "/index", "/home"})
    public String getHomePage(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("allProducts", productList);
        return "amazon";
    }

    @RequestMapping("/viewDetailedProductInfo")
    public String viewDetailedProductInfo(@RequestParam("product-id") Long productId,
                                          Model model) {
        Product product = productService.findProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("ratingSize", ratingService.findReviewsByProductId(productId).size());
        return "product-details";
    }


    @RequestMapping("/addProductToCart")
    public String addPrdocutToCart(@RequestParam("product-id") Long productId, Model model) {
        Product product = productService.findProductById(productId);
        model.addAttribute("product", product);
        return "product-details";
    }


    @RequestMapping("/showRatingsFor/{productId}")
    public String showRatingForProduct(@PathVariable("productId") long productId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username);

        Product product = productService.findProductById(productId);
        List<Rating> ratingsForProduct = ratingService.findReviewsByProductId(productId);
        model.addAttribute("product", product);
        model.addAttribute("ratings", ratingsForProduct);
        List<Product> productsPurchased = user.getPurchasedProducts();
        if (productsPurchased.contains(product)) {
            model.addAttribute("purchased", true);
        } else {
            model.addAttribute("purchased", false);
        }
        model.addAttribute("product", product);

        return "product-rating";
    }

    @RequestMapping("/rateProduct/{productId}")
    public String addRatingForProducT(@PathVariable("productId") long productId,
                                      @RequestParam("headline") String headline,
                                      @RequestParam("comment") String comment,
                                      @RequestParam("star") int star) {
        Product product = productService.findProductById(productId);

        Rating rating = new Rating(headline, star, comment);
        product.getProductReviews().add(rating);
        rating.setRatedProduct(product);
        ratingService.saveRating(rating);
        productService.saveProduct(product);
        return "redirect:/showRatingsFor/"+productId;
    }


}
