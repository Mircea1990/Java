package loops;

public class DoWhileLoopDemo {

	public static void main(String[] args) {
		System.out.println("=========== do-while loop");
		int counter = 0;
		do {
			System.out.println("counter: " + counter++);
		} while (counter < 5);

		System.out.println();

		do {
			System.out.println("counter is 5 already: " + counter);
		} while (counter < 5);
	}

}
