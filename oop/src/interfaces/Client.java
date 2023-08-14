package interfaces;

public class Client {

	private PaymentProcessor paymentProcessor;

	{
		paymentProcessor = new PayPalPaymentProcessor();
	}

	public void checkout(PaymentData paymentData) {
		System.out.println("Checkout client");
		paymentProcessor.processPayment(paymentData);
		PaymentProcessor.someStaticMethod();
	}

	public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}
}
