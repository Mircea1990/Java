package exceptions;

public class NullPointerExceptionDemo {

	public static void main(String[] args) {

		User user = null;
		double orderPrice = 196.477;
		chargeUser(user, orderPrice);
	}

	private static void chargeUser(User user, double orderPrice) {
		user.setAmountOfMoney(user.getAmountOfMoney() - orderPrice);

	}

	class User {
		private double amountOfMoney;

		public double getAmountOfMoney() {
			return amountOfMoney;
		}

		public void setAmountOfMoney(double amountOfMoney) {
			this.amountOfMoney = amountOfMoney;
		}

	}
}
