package webshop_app_spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop_app_spring.demo.models.Rating;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    List<Rating> findByRatedProductId(Long id);

}
