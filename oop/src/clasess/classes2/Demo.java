package clasess.classes2;

import clasess.classes1.Cart;
import clasess.classes1.Cart.Discount;
import clasess.classes1.Cart.Tax;

public class Demo {

	public static void main(String[] args) {
		User user = new User();

		Tax tax = new Cart.Tax("someTaxType", 0);
		System.out.println(tax);

		Discount discount = new Cart().new Discount("firstClientDiscount", 0);
		System.out.println(discount);

		MasterProduct masterProduct = new MasterProduct();
		VariantProduct variantProduct = new VariantProduct();

		masterProduct.setId(1);
		masterProduct.setName("Master product 1");
		variantProduct.setDeliveryAvailable(true);

		Product product = new Product() {

			@Override
			public boolean isAvailableInStock() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
