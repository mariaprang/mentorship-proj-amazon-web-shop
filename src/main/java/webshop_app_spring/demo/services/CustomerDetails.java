package webshop_app_spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetails{

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public User removeUser(User user) {
        User userToBeRemoved = getUserById(user.getId());
        removeUser(user);
        return userToBeRemoved;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> listAllUsers() {
        return (ArrayList) userRepository.findAll();
    }

}
