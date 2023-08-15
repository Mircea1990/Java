package exceptions;

public class NotEnoughMoneyException extends RuntimeException {

	public NotEnoughMoneyException() {
		System.out.println("Not enough money !");
	}
}
