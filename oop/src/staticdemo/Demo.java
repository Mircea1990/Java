package staticdemo;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		User user1 = new User();
		System.out.println(user1.getId());
		System.out.println(User.getCounter());

		System.out.println();
		System.out.println("================================");
		System.out.println();

		User user2 = new User();
		System.out.println(user2.getId());
		System.out.println(User.getCounter());

		System.out.println();
		System.out.println("================================");
		System.out.println();

		User user3 = new Employee();
		user3.doAnyStaticAction();

		User.doAnyStaticAction();
		Employee.doAnyStaticAction();

		System.out.println();
		System.out.println("================================");
		System.out.println();

		int[] arr = { 1, 2, 3 };
		Arrays.sort(arr);
	}

}
