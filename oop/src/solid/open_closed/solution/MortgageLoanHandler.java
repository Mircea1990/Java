package solid.open_closed.solution;

public class MortgageLoanHandler implements LoanHandler {

	private Validator validator;

	public MortgageLoanHandler(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void approveLoan(User user) {
		if (validator.isValid(user)) {
			// proceed
			System.out.println("Mortgage loan have been approved");
		}

	}

}
