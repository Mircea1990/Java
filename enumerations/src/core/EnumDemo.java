package core;

public class EnumDemo {

	public static void main(String[] args) {

		Priority priority = Priority.HIGH;

		switch (priority) {
		case LOW:
			System.out.println("High priority");
			break;
		case MEDIUM:
			System.out.println("Medium priority");
			break;
		case HIGH:
			System.out.println("High priority");
			break;
		}

		System.out.println("============ Enum valueOf()");

		Priority priority2 = Priority.valueOf("HIGH");
		System.out.println(priority2);

		System.out.println("============ Enum comparison");
		System.out.println(priority == Priority.MEDIUM);
		System.out.println(priority == Priority.HIGH);

		System.out.println("============ Enum ordinal()");
		System.out.println(Priority.HIGH.ordinal());
		System.out.println(Priority.MEDIUM.ordinal());

		System.out.println("============ Enum iteration");
		Priority[] values = Priority.values();
		for (Priority pri : values) {
			System.out.println(pri);
		}

		System.out.println("============ Enum fields and methods");
		System.out.println(Month.MARCH.getDays());
	}

}
