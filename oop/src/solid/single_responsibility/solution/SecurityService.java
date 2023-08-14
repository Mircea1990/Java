package solid.single_responsibility.solution;

public class SecurityService {

	public boolean hasAcces(User user) {
		if (user.getRole() == Role.ADMIN)
			return true;
		else
			return false;
	}
}
