package webshop_app_spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.repositories.UserRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user.toString());
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User with the username '" + username + "' not found.");
        }
    }

}
