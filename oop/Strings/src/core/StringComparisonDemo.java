package core;

public class StringComparisonDemo {

	public static void main(String[] args) {
		System.out.println("===== String comparison =====");
		System.out.println();

		String s1 = " Hello ";
		String s2 = " Hello ";
		System.out.println("s1 == s2: " + (s1 == s2));

		String s3 = new String(" Hello ");
		System.out.println("s1 == s3: " + (s1 == s3));

		System.out.println("s1.equals(s3): " + s1.equals(s3));
		System.out.println("s1 == s3.intern(): " + (s1 == s3.intern()));

		String fName = "Mircea";
		String fName2 = "mircea";
		System.out.println("fName.equals(fName2): " + fName.equals(fName2));
		System.out.println("fName.equalsIgnoreCase(fName2): " + fName.equalsIgnoreCase(fName2));

	}

}
