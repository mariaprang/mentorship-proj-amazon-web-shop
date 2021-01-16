package webshop_app_spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.services.ProductService;
import webshop_app_spring.demo.services.RatingService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RatingService ratingService;

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
        Product product = productService.findProductById(productId);
        model.addAttribute("product", product);
        return "product-rating";
    }



}
