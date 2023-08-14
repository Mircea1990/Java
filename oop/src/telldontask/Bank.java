package telldontask;

import java.math.BigDecimal;

public class Bank {

	public void withdraw(BigDecimal amount, UserAccount userAccount) {
		if (userAccount.getBalance().compareTo(amount) > 0) {
			userAccount.setBalance(userAccount.getBalance().subtract(amount));
		}
	}
}
