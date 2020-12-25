package webshop_app_spring.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login", "/logout-success"})
    public String getLoginPage(@RequestParam Optional<String> error, Model model) {
        return "login";
    }
}
