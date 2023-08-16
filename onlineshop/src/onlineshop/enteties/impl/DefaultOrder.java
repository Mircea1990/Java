package onlineshop.enteties.impl;

import java.util.Arrays;

import onlineshop.enteties.Order;
import onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private String creditCardNmber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER
				&& !creditCardNumber.contains(" ") && Long.parseLong(creditCardNmber) > 0;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null)
			return;
		this.creditCardNmber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public void setCostumerId(int costumerId) {
		this.customerId = costumerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "Order [credidCardNmber=" + creditCardNmber + ", products=" + Arrays.toString(products) + ", customerId="
				+ customerId + "]";
	}

}
