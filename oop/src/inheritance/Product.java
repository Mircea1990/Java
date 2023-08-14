package inheritance;

public class Product {

	private int id;
	private String name;

	public Product(String name) {
		this.name = name;
	}

	public int calculateRamainingAmount() {
		return 100;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product[] listVaiants() {
		return new Product[3];
	}
}
