package interfaces;

public class PayPalPaymentProcessor implements PaymentProcessor {

	@Override
	public void processPayment(PaymentData paymentData) {
		System.out.println("Procces payment in paypal");

	}

}
