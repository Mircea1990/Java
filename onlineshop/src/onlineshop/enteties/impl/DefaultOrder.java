package onlineshop.enteties.impl;

import java.util.Arrays;

import onlineshop.enteties.Order;
import onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private String credidCardNmber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCreditCardNumber() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProducts(Product[] products) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCostumerId(int costumerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "DefaultOrder [credidCardNmber=" + credidCardNmber + ", products=" + Arrays.toString(products)
				+ ", customerId=" + customerId + "]";
	}

}
