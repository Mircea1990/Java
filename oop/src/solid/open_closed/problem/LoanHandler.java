package solid.open_closed.problem;

public class LoanHandler {

	private PersonalLoanValidator personalLoanValidator;
	private MortgageLoanValidator mortgageLoanValidator;

	public LoanHandler(PersonalLoanValidator personalLoanValidator, MortgageLoanValidator mortgageLoanValidator) {
		this.personalLoanValidator = personalLoanValidator;
		this.mortgageLoanValidator = mortgageLoanValidator;
	}

	public void approvePersonalLoan(User user) {
		if (personalLoanValidator.isValidUserForPersonalLoan(user)) {
			// proceed with personal loan approval
		}
	}

	public void approveMortgage(User user) {
		if (mortgageLoanValidator.isValidUserForMortgage(user)) {
			// proceed with loan approval
		}
	}
}
