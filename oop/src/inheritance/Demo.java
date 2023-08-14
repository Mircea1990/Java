package inheritance;

public class Demo {

	public static void main(String[] args) {
		Product product = new Phone();
		product.setName("Samsung 224");
		System.out.println("Product name " + product.getName());
		System.out.println("Ramaining amount in stock " + product.calculateRamainingAmount());

		System.out.println();
		Phone phone = new Phone();
		phone.ring();

		if (product instanceof Phone) {
			Phone phone2 = (Phone) product;
			phone2.ring();
		}

		System.out.println(phone.calculateAmountOfVariants());
	}
}
