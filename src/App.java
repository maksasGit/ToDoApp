import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Widget> widgets;
    private List<ShoppingCart> shoppingCarts;
    private boolean isOpen;

    public App() {
        this.widgets = new ArrayList<>();
        this.shoppingCarts = new ArrayList<>();
        this.isOpen = true;
    }

    public void showShoppingCarts() {
        System.out.println("Work with ShoppingCarts:");
        System.out.println("    0 - to skip");
        System.out.println("    ShopCartID - to choose");

        int index = 1;
        for (ShoppingCart shoppingCart : shoppingCarts) {
            System.out.println(index + ": " + shoppingCart.getName());
            index++;
        }

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        if (inputLine.equals("0")) {
            System.out.println("Skipped...");
        } else {
            int shopCartId = Integer.parseInt(inputLine);
            if (shopCartId >= 1 && shopCartId <= shoppingCarts.size()) {
                ShoppingCart chosenShoppingCart = shoppingCarts.get(shopCartId - 1);
                System.out.println("Shopping Cart \"" + chosenShoppingCart.getName() + "\" is chosen");

                // Start separate manager for the chosen shopping cart
            } else {
                System.out.println("Invalid Shopping Cart ID");
            }
        }
    }

    public void editProducts() {
        // Implementation of editProducts method goes here
    }

    public void showWidgets() {
        System.out.println("Work with Widgets:");
        System.out.println("    0 - to skip");
        System.out.println("    WidgetID - to choose");

        int index = 1;
        for (Widget widget : widgets) {
            System.out.println(index + ": " + widget.getName());
            index++;
        }

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        if (inputLine.equals("0")) {
            System.out.println("Skipped...");
        } else {
            int widgetId = Integer.parseInt(inputLine);
            if (widgetId >= 1 && widgetId <= widgets.size()) {
                Widget chosenWidget = widgets.get(widgetId - 1);
                System.out.println("Widget \"" + chosenWidget.getName() + "\" is chosen");

                // Start separate manager for the chosen widget
            } else {
                System.out.println("Invalid Widget ID");
            }
        }
    }

    public void addWidget() {
        System.out.println("Enter info in format: \"WidgetName:WidgetDescription\"");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] widgetInfo = inputLine.split(":");
        if (widgetInfo.length == 2) {
            String widgetName = widgetInfo[0];
            String widgetDescription = widgetInfo[1];
            Widget newWidget = new Widget(widgetName, widgetDescription);
            System.out.println("New Widget was created...");
            System.out.println("Widget Name: " + widgetName);
            System.out.println("Widget Description: " + widgetDescription);
            widgets.add(newWidget);
        } else {
            System.out.println("Invalid input line");
        }
    }

    public void editWidget() {
        // Implementation of editWidget method goes here
    }

    public void deleteWidget() {
        // Implementation of deleteWidget method goes here
    }

    public void addShoppingCart() {
        System.out.println("Enter info in format: \"ShoppingCartName\"");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String shoppingCartName = inputLine;
        ShoppingCart newShoppingCart = new ShoppingCart(shoppingCartName);
        System.out.println("New Shopping Cart was created...");
        System.out.println("Shopping Cart called: " + shoppingCartName);
        shoppingCarts.add(newShoppingCart);
    }

    public void addProduct() {
        System.out.println("Enter info in format: \"Product:Quantity\"");
        Scanner scanner = new Scanner(System.in);
        String inputParts[] = scanner.nextLine().split(":");
        Product newProduct = new Product(inputParts[0] , Integer.parseInt(inputParts[1]));

    }

    public void editShoppingCart() {
        // Implementation of editShoppingCart method goes here
    }

    public void deleteShoppingCart() {
        // Implementation of deleteShoppingCart method goes here
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void inputCheck(String inputString) {
        char inputNum = inputString.charAt(0);
        switch (inputNum) {
            case '1' -> this.addWidget();
            case '2' -> this.showWidgets();
            case '3' -> this.addShoppingCart();
            case '4' -> this.showShoppingCarts();
            case '7' -> this.addProduct();
            case '/' -> {
                if (inputString.equals("/show")) {
                    showMenu();
                } else if (inputString.equals("/help")) {
                    System.out.println("---------------------------------");
                    System.out.println("Some helpful info:");
                    System.out.println("/help --- help info");
                    System.out.println("/show --- show menu");
                    System.out.println("---------------------------------");
                }
                break;
            }
            case '6' -> this.isOpen = false;
        }
    }

    public void showMenu() {
        System.out.println("1: Create Widget");
        System.out.println("2: Show Widgets");
        System.out.println("7: Create Product");
        System.out.println("3: Create Shopping Cart");
        System.out.println("4: Show Shopping Cart");
        System.out.println("6: Close App");
    }
}
