package onlineshop.enteties;

public interface Order {

	boolean isCreditCardNumberValid(String creditCardNumber);

	void setCreditCardNumber(String creditCardNumber);

	void setProducts(Product[] products);

	void setCostumerId(int costumerId);

	int getCustomerId();
}
