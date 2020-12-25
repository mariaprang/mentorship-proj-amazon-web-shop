package webshop_app_spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.services.CustomerDetailsService;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    public User findByUsername(String email);

}
