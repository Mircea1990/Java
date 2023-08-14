package solid.single_responsibility.solution;

public class MailboxSettingsService {

	private SecurityService securityService;

	{
		securityService = new SecurityService();
	}

	public void changeEmail(User user, String newEmail) {
		if (securityService.hasAcces(user)) {
			user.setEmail(newEmail);
		}
	}
}
