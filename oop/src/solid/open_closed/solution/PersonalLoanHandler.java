package solid.open_closed.solution;

public class PersonalLoanHandler implements LoanHandler {

	private Validator validator;

	public PersonalLoanHandler(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void approveLoan(User user) {
		if (validator.isValid(user)) {
			// proceed...
			System.out.println("Personal loan have been approved");
		}
	}

}
