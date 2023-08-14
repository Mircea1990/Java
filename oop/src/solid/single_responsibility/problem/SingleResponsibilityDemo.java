package solid.single_responsibility.problem;

public class SingleResponsibilityDemo {

	public static void main(String[] args) {
		MailboxSettingsService service = new MailboxSettingsService();
		User user = new User();

		// responsibility #1 of the MilboxSettingsService - change settings in mailbox
		service.changeEmail(user, "new@gmail.com");

		// responsibility #2 of the MilboxSettingsService - verify access
		if (service.hasAccess(user)) {
			user.sendMoney(new User(), 1000);
		}

	}

}
