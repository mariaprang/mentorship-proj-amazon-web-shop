package webshop_app_spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop_app_spring.demo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findProductByProductCategory(String category);
}
