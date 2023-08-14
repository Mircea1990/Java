package solid.single_responsibility.solution;

public class SingleResponsibilityDemo {

	public static void main(String[] args) {
		MailboxSettingsService service = new MailboxSettingsService();
		User user = new User();

		// responsibility #1 of the MilboxSettingsService - change settings in mailbox
		service.changeEmail(user, "newEmail@gmail.com");

		// responsibility #1 of the SecurityService - verify access
		SecurityService securityService = new SecurityService();
		if (securityService.hasAcces(user)) {
			user.sendMoney(new User(), 1000);
		}

	}

}
