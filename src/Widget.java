import java.util.ArrayList;
import java.util.List;

public class Widget {
    private final String name;
    private final String description;
    private List<Product> products;

    public Widget(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }

    public void addProduct() {
        // Implementation of addProduct method goes here
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void updateProducts(List<Product> updatedProducts) {
        this.products = updatedProducts;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void deleteProduct() {
        // Implementation of deleteProduct method goes here
    }
}
