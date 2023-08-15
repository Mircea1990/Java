package onlineshop.enteties;

public interface Order {

	boolean isCreditCardNumberValid();

	void setCreditCardNumber();

	void setProducts(Product[] products);

	void setCostumerId(int costumerId);

	int getCustomerId();
}
