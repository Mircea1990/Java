package exceptions;

import java.io.FileNotFoundException;

public class ThrowDemo {

	public static void main(String[] args) {
		ThrowDemo demo = new ThrowDemo();
		demo.transferMoney(null, null, 0);
		demo.transferMoney2(null, null, 0);
	}

	private void transferMoney(Account from, Account to, double moneytoTransfer) {
		if (from == null || to == null || from.getMoney() < moneytoTransfer)
			// throw new IllegalArgumentException();
			// throw new IllegalArgumentException("Invalid argument");
			throw new RuntimeException(new FileNotFoundException());
	}

	private void transferMoney2(Account from, Account to, double moneytoTransfer) {
		if (from == null || to == null)
			throw new IllegalArgumentException();
		if (from.getMoney() < moneytoTransfer)
			throw new NotEnoughMoneyException();
	}

	class Account {
		private double money;

		public double getMoney() {
			return money;
		}

	}
}
