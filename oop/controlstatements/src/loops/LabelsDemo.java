package loops;

public class LabelsDemo {

	public static void main(String[] args) {
		System.out.println("=========== labels");
		loop1: for (int i = 0; i < 5; i++) {
			System.out.println("Counter i: " + i);

			loop2: for (int j = 0; j < 5; j++) {
				System.out.println("Counter j: " + j);
				if (j >= 0 && j < 3) {
					System.out.println("continue loop2");
					continue loop2;
				} else {
					System.out.println("break loop1");
					break loop1;
				}
			}
		}

	}

}
