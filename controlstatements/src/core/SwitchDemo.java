package core;

public class SwitchDemo {

	public static void main(String[] args) {
		String custumoerStatus = "premium_customer";
		switch (custumoerStatus) {
		case "guest":
			System.out.println("Thank you for your order!");
			break;
		case "regular_customer":
			System.out.println("Thank you for your order! You have 10% discount");
			break;
		case "premium_customer":
			System.out.println("Thank you for your order! You have 15% discount");
			break;
		default:
			System.out.println("Customer doesn' t have status set.");
		}

		System.out.println("============ No break demo");
		int i = 1;
		switch (i) {
		case 1:
			System.out.println("one");
		case 2:
			System.out.println("two");
			break;
		default:
			System.out.println("This is the default block");
		}

		System.out.println("============ Default block demo");
		i = 10;
		switch (i) {
		case 1:
			System.out.println("one");
		case 2:
			System.out.println("two");
			break;
		default:
			System.out.println("This is the default block");
		}
	}
}
