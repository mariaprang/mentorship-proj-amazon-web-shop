package webshop_app_spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.services.ProductService;

@Controller
public class CartController {

    @Autowired
    ProductService productService;


}
