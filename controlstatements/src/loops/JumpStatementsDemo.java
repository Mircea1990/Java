package loops;

public class JumpStatementsDemo {

	public static void main(String[] args) {
		System.out.println("=========== continue");
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0)
				continue;

			System.out.println("Counter: " + i);
		}

		System.out.println("=========== break");
		for (int i = 0; i < 5; i++) {
			if (i == 3)
				break;
			System.out.println("Counter: " + i);
		}

		System.out.println("=========== break nested loop");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 3)
					break;
				System.out.println("j: " + j);
			}
			System.out.println("Counter: " + i);
		}
	}

}
