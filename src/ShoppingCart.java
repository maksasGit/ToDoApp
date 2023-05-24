import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String name;
    private List<Widget> widgets;
    private List<Product> products;

    public ShoppingCart(String name) {
        this.name = name;
        this.widgets = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Widget> getWidgets() {
        return this.widgets;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void updateWidgets(List<Widget> updatedWidgets) {
        this.widgets = updatedWidgets;
    }

    public void updateProducts(List<Product> updatedProducts) {
        this.products = updatedProducts;
    }

    public void markProduct() {
        // Implementation of markProduct method goes here
    }
}
