package webshop_app_spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).get();
    }

}
