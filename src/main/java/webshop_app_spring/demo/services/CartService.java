package webshop_app_spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop_app_spring.demo.models.Cart;
import webshop_app_spring.demo.models.Product;
import webshop_app_spring.demo.models.User;
import webshop_app_spring.demo.repositories.CartRepository;
import webshop_app_spring.demo.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public void createCartForUser(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        user.setUserCart(cart);
        cartRepository.save(cart);
        userRepository.save(user);
    }

    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    public void emptyCartForUser(User user) {
        Cart cart = user.getUserCart();
        for(Product product : cart.getProducts()){
                cart.deleteProduct(product);
        }
        saveCart(cart);
    }

    public void deleteProductFromCart(Product productToDelete,
                                      Cart cartToDeleteFrom){
        cartToDeleteFrom.deleteProduct(productToDelete);
        saveCart(cartToDeleteFrom);
    }

    public Cart findCartById(Long id){
        return cartRepository.findById(id).get();
    }

    public List<Product> getProductsForCart(Cart cart){
        return cart.getProducts();
    }
}
