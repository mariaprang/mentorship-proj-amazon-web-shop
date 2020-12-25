package webshop_app_spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop_app_spring.demo.models.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {


}
