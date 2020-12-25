package webshop_app_spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.services.CustomerDetails;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerDetails customerDetails;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    public String getRegistrationPage() {
        return "register";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@RequestParam("first-name") String firstName,
                               @RequestParam("last-name") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("password-repeat") String passRepeat) {

        if (!password.equals(passRepeat)) {
            return "redirect:/login?error";
        } else {
            User user = new User(email, passwordEncoder.encode(password), firstName, lastName);
            customerDetails.registerUser(user);
            return "redirect:/login";
        }
    }

}
