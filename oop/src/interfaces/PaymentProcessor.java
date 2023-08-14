package interfaces;

public interface PaymentProcessor {

	int RETRY_ATTEMPTS = 5;

	void processPayment(PaymentData paymentData);

	default void someDefaultMethod() {
		System.out.println("This is the default method");
	}

	static void someStaticMethod() {
		System.out.println("This is the static method");
	}
}
