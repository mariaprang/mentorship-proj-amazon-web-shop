package webshop_app_spring.demo.models;

public enum ProductCategory {

    BOOKS("Books"),
    FOOD("Food"),
    HEALTH_CARE("Health care"),
    CLOTHING("Clothing"),
    SHOES("Shoes"),
    SPORTS("Sports"),
    ELECTRONICS("Electronics");

    private String type;

    ProductCategory(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
