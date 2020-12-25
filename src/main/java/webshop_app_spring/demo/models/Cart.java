package webshop_app_spring.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="carts")
public class Cart extends BaseEntity {

   @OneToOne(mappedBy = "userCart")
    private User user;

    @OneToMany(mappedBy="cart")
    private List<Product> productArrayList;


    public Cart() {
        this.productArrayList = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return productArrayList;
    }

    public void setProducts(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public void addProduct(Product product) {
        if (!productArrayList.contains(product)) {
            this.productArrayList.add(product);
        }
    }

    public Product deleteProduct(Product product){
        if(productArrayList.contains(product)){
            productArrayList.remove(product);
        }
        return product;
    }
}
