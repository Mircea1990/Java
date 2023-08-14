package interfaces;

public class ChasePaymentProcessor implements PaymentProcessor, PaymentValidator {

	@Override
	public void processPayment(PaymentData paymentData) {
		/*
		 * String secureToken = ChaseApi.requestSecureTokenForApp();
		 * initPaymentPage(secureToken, payment.getPaymentAmount); ...
		 */

	}

	@Override
	public boolean validatePayment(PaymentData paymentData) {
		// code to validate payment goes here
		return false;
	}

}
