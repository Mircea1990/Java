package core;

import java.util.Arrays;

public class StringMainMethodsOverview {

	public static void main(String[] args) {
		System.out.println("===== String methods =====");

		System.out.println();

		String s = "\u2001	hello ";
		System.out.println("s.length(): " + s.length());
		System.out.println("s.contains(): " + s.contains("he"));
		System.out.println("s.isEmpty(): " + s.isEmpty());
		System.out.println("s.toUpperCase(): " + s.toUpperCase());
		System.out.println("s.startsWith(): " + s.startsWith("h"));
		System.out.println("s.startsWith(): " + s.startsWith(" "));
		System.out.println("s.endsWith(): " + s.endsWith(" "));
		System.out.println("s.replace(): " + s.replace("ll", " "));
		System.out.println("s.trim(): " + s.trim());
		System.out.println("s.stripe(): " + s.strip());
		System.out.println("s.substring(): " + s.substring(0, 5));
		System.out.println("Arrays.toSubstring(s.getBytes())" + Arrays.toString(s.getBytes()));
		System.out.println("Arrays.toSubstring(s.toCharArray())" + Arrays.toString(s.toCharArray()));
		System.out.println("s.charAt(1): " + s.charAt(3));
		System.out.println("Arrays.toString(s.split()): " + Arrays.toString(s.split("l")));
		System.out.println(s);
	}

}
