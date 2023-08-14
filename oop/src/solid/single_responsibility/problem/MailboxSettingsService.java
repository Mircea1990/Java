package solid.single_responsibility.problem;

public class MailboxSettingsService {

	public void changeEmail(User user, String newEmail) {
		if (hasAccess(user)) {
			user.setEmail(newEmail);
		}
	}

	public boolean hasAccess(User user) {
		if (user.getRole() == Role.AMIN)
			return true;
		else
			return false;
	}
}
