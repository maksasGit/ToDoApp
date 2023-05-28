public class Product {
	private String name;
	private int quantity;
	private boolean marked;

	public Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.marked = false;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void mark() {
		if (!this.marked) {
			this.marked = true;
		}else {
			System.out.println("This product is already marked!");
		}

	}
}
