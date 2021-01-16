package webshop_app_spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop_app_spring.demo.models.Rating;
import webshop_app_spring.demo.repositories.RatingRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public void removeRating(Rating rating) {
        ratingRepository.delete(rating);
    }

    public List<Rating> findAllRatings() {
        return (List) ratingRepository.findAll();
    }

    public Rating findRatingById(Long id) {
        return ratingRepository.findById(id).get();
    }

    public List<Rating> findReviewsByProductId(Long id){
        return ratingRepository.findByRatedProductId(id);
    }


}
