import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private final List<Widget> widgets;
	private final List<ShoppingCart> shoppingCarts;
	private User user;
	private boolean isOpen;

	public ShoppingCart chooseSC = null;

	public App() {
		this.widgets = new ArrayList<>();
		this.shoppingCarts = new ArrayList<>();
		this.isOpen = true;
	}

	public void showShoppingCarts() {
		System.out.println("Work with ShoppingCarts:");
		System.out.println("\t0 - cancel");
		System.out.println("\tShopCartID - to choose");

		int index = 1;
		for (ShoppingCart shoppingCart : shoppingCarts) {
			System.out.println(index + ": " + shoppingCart.getName());
			index++;
		}
	}


	public int chooseShoppingCart() {
		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();

		if (inputLine.equals("0")) {
			System.out.println("Action canceled");
			return -1;
		} else {
			int shopCartId = Integer.parseInt(inputLine);
			if (shopCartId >= 1 && shopCartId <= shoppingCarts.size()) {
				ShoppingCart chosenShoppingCart = shoppingCarts.get(shopCartId - 1);
				System.out.println("Shopping Cart \"" + chosenShoppingCart.getName() + "\" is chosen");
				return shopCartId;
			} else {
				System.out.println("Invalid Shopping Cart ID");
				return -1;
			}
		}
	}

	public void editProducts() {
		// Implementation of editProducts method goes here
	}

	public void showWidgets() {
		System.out.println("Work with Widgets:");
		System.out.println("\t0 - cancel");
		System.out.println("\tWidgetID - to choose");

	}


	public int chooseWidget() {

		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();

		if (inputLine.equals("0")) {
			System.out.println("Action canceled");
			return -1;
		} else {
			int widgetId = Integer.parseInt(inputLine);
			if (widgetId >= 1 && widgetId <= widgets.size()) {
				Widget chosenWidget = widgets.get(widgetId - 1);
				System.out.println("Widget \"" + chosenWidget.getName() + "\" is chosen");
				return widgetId;

			} else {
				System.out.println("Invalid Widget ID");
				return -1;
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
		String shoppingCartName = scanner.nextLine();
		ShoppingCart newShoppingCart = new ShoppingCart(shoppingCartName);
		System.out.println("New Shopping Cart was created...");
		System.out.println("Shopping Cart called: " + shoppingCartName);
		shoppingCarts.add(newShoppingCart);
	}

	public void addProduct() {
		System.out.println("Enter info in format: \"Product:Quantity\"");
		Scanner scanner = new Scanner(System.in);
		String[] inputParts = scanner.nextLine().split(":");
		Product newProduct = new Product(inputParts[0], Integer.parseInt(inputParts[1]));
		String WidgetOrShoppingCart = "Add product to:\n";
		int lenCheck = WidgetOrShoppingCart.length();
		if (widgets.size() > 0) WidgetOrShoppingCart += "\tWidget - w\n";
		if (shoppingCarts.size() > 0) WidgetOrShoppingCart += "\tShoppingCart - s\n";
		if (WidgetOrShoppingCart.length() != lenCheck) {
			System.out.println(WidgetOrShoppingCart);
			scanner = new Scanner(System.in);
			String inputLine = scanner.nextLine();
			if (inputLine.equals("w")) {
				showWidgets();
				int variant = chooseWidget();
				if (variant > 0) {
					List<Product> newProducts = widgets.get(variant - 1).getProducts();
					newProducts.add(newProduct);
					widgets.get(variant - 1).updateProducts(newProducts);
					System.out.println("Product \"" + newProduct.getName() + "\" added to Widget + \"" + widgets.get(variant - 1).getName() + "\"");
				}
			} else if (inputLine.equals("s")) {
				showShoppingCarts();
				int choice = chooseShoppingCart();
				if (choice < 1 || choice > shoppingCarts.size()) {
					return;
				}
				List<Product> newProducts = shoppingCarts.get(choice - 1).getProducts();
				newProducts.add(newProduct);
				shoppingCarts.get(choice - 1).updateProducts(newProducts);
				System.out.println("Product \"" + newProduct.getName() + "\" added to ShoppingCart + \"" +
						shoppingCarts.get(choice - 1).getName() + "\"");

			} else {
				System.out.println("Action canceled");
			}
		}
	}

	public void editShoppingCart() {
		// Implementation of editShoppingCart method goes here
	}

	public void deleteShoppingCart() {
		// Implementation of deleteShoppingCart method goes here
	}

	private boolean isOpen() {
		return isOpen;
	}

	private void inputCheck(String inputString) {
		if (inputString.length() == 0) {
			return;
		}
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
			}
			case '6' -> this.isOpen = false;
			default -> {
			}
		}
	}

	public void showMenu() {
		System.out.println("Current user: " + this.user.getName() + ", login: " + this.user.getLogin());
		System.out.println("Menu:");
		System.out.println("1: Create Widget");
		System.out.println("2: Show Widgets");
		if (shoppingCarts.size() > 0 || widgets.size() > 0) System.out.println("7: Add Product");
		System.out.println("3: Create Shopping Cart");
		System.out.println("4: Show Shopping Cart");
		System.out.println("6: Close App");
	}

	public void run() throws IOException, InterruptedException {
		System.out.println("Shopping Cart Application Start...");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your Login: ");
		String login = scanner.nextLine();
		this.cls();
		this.user = new User(login, name);
		while (this.isOpen()) {
			this.showMenu();
			String inputString = scanner.nextLine();
			System.out.println(inputString);
			this.inputCheck(inputString);
			this.cls();
		}

		System.out.println("---------------------------------");
		System.out.println("Goodbye:)");
	}

	private void cls() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}
