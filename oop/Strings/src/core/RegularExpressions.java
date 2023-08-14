package core;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		System.out.println("===== Regular expressions =====");
		System.out.println();

		String gmailPattern = "[a-zA-Z-\\d]+@gmail\\.com";
		Pattern pattern = Pattern.compile(gmailPattern);
		String sample = "Some random text that contains gmail address like this one"
				+ " some-email@gmail.com. And some other text";
		Matcher matcher = pattern.matcher(sample);

		matcher.find();
		String gmailAddress = matcher.group();
		System.out.println(gmailAddress);

		String sample2 = "There are 3 sentences in this string. Are you sure? Yes!";
		String[] sentences = sample2.split("[\\.!?]");
		System.out.println(Arrays.toString(sentences));
	}

}
