package exercises.exe1;

import java.util.Arrays;
import java.util.Objects;

public class Account {

	private int id;
	private Transaction[] transactions;
	private int lastTransactionIndex;

	private static final int DEFAULT_TRANSACTIONS_AMOUNT = 10;

	{
		transactions = new Transaction[DEFAULT_TRANSACTIONS_AMOUNT];
	}

	public Account(int id) {
		this.id = id;
	}

	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
		if (accountTo == null)
			return;
		if (moneyAmount <= 0)
			return;
		Transaction transaction = new Transaction(this, accountTo, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_SEND);
		addTransaction(transaction);
		accountTo.receiveMoney(this, moneyAmount);
	}

	private void receiveMoney(Account accountFrom, double moneyAmount) {
		if (accountFrom == null)
			return;
		if (moneyAmount <= 0)
			return;
		Transaction transaction = new Transaction(accountFrom, this, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
		addTransaction(transaction);
	}

	private void addTransaction(Transaction transaction) {
		if (transaction == null)
			return;
		if (transactions.length <= lastTransactionIndex)
			transactions = Arrays.copyOf(transactions, transactions.length << 1);
		transactions[lastTransactionIndex++] = transaction;
	}

	public void withdrawMoney(double moneyAmount) {
		Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
		addTransaction(transaction);
	}

	public Transaction[] getTransactions() {
		return Arrays.stream(transactions).filter(Objects::nonNull).toArray(Transaction[]::new);
	}

	public static class Transaction {

		private Account accountFrom;
		private Account accountTo;
		private double moneyAmount;
		private StandardAccountOperations accountOperations;

		public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
				StandardAccountOperations accountOperations) {
			this.accountFrom = accountFrom;
			this.accountTo = accountTo;
			this.moneyAmount = moneyAmount;
			this.accountOperations = accountOperations;
		}

		public Account getAccountFrom() {
			return accountFrom;
		}

		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}

		public Account getAccountTo() {
			return accountTo;
		}

		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}

		public double getMoneyAmount() {
			return moneyAmount;
		}

		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}

		public StandardAccountOperations getAccountOperations() {
			return accountOperations;
		}

		public void setAccountOperations(StandardAccountOperations accountOperations) {
			this.accountOperations = accountOperations;
		}

		@Override
		public String toString() {
			return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", moneyAmount="
					+ moneyAmount + ", accountOperations=" + accountOperations + "]";
		}
	}
}