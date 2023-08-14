package solid.open_closed.problem;

public class OpenClosedPrincipleDemo {

	public static void main(String[] args) {
		LoanHandler handler = new LoanHandler(new PersonalLoanValidator(), new MortgageLoanValidator());
		User user = new User();

		handler.approveMortgage(user);
		handler.approvePersonalLoan(user);

	}

}
