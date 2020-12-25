package webshop_app_spring.demo.models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    private enum Role{
        USER, ADMIN
    }

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Cart userCart;

    @Transient // <-- means "don't add the fields with transient to database table"
    private boolean accounNonExpried;
    @Transient
    private boolean isAccountNonLocked;
    @Transient
    private boolean isCredentialsNonExpired;
    @Transient
    private boolean isEnabled;

    private Role role;

    public User(){
        this.accounNonExpried = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.role = Role.USER;
    }

    public User(String email,String password, String firstname, String lastname) {
        this.username = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.accounNonExpried = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.role = Role.USER;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(Role.USER.toString()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accounNonExpried;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, lastname);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", accounNonExpried=" + accounNonExpried +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", role=" + role +
                '}';
    }
}
