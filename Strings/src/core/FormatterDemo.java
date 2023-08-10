package core;

import java.util.Formatter;

public class FormatterDemo {

	public static void main(String[] args) {
		Formatter formatter = new Formatter();
		System.out.println();
		System.out.println("===== Space format specifier =====");

		System.out.println();
		formatter.format("%d", -111);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("% d", 111);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("% d", -222);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("% d", 222);
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== + Sign Specifier =====");
		System.out.println();

		formatter = new Formatter();
		formatter.format("%+d", 111);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("%+d", -111);
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== ( specifier =====");
		System.out.println();
		formatter = new Formatter();
		formatter.format("%(d", -111);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("%(d", 111);
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== Comma, Specifier =====");
		System.out.println();

		formatter = new Formatter();
		formatter.format("%, d", 1000000);
		System.out.println(formatter);

		formatter = new Formatter();
		formatter.format("%, .3f", 45464643.456);
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== Left Justification(-) Specifier =====");
		System.out.println();

		formatter = new Formatter();
		formatter.format("|%20.4f|", 1234.4897);
		System.out.println(formatter);
		formatter = new Formatter();
		formatter.format("|%-20.4f|", 1234.4897);
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== The %n format specifiers =====");
		System.out.println();
		formatter = new Formatter();
		formatter.format("Becoming a Java programmer%nPractice through exercise");
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== The %% format specifiers =====");
		System.out.println();
		formatter = new Formatter();
		formatter.format("10 %% 4 = 2");
		System.out.println(formatter);

		System.out.println();
		System.out.println("===== The %x %X format specifiers =====");
		System.out.println();
		formatter = new Formatter();
		formatter.format("%x", 250);
		System.out.println(formatter);

		System.out.println("Lower Hexadecimal" + " using %x: " + formatter);

		formatter = new Formatter();
		formatter.format("%X", 250);
		System.out.println("UpperCase Hexadecimal" + " using %X: " + formatter);

		formatter = new Formatter();
		formatter.format("%e", 134.4677);
		System.out.println("LowerCase Scientific notation" + " using %e:" + formatter);
		formatter = new Formatter();
		formatter.format("%E", 4646.467);
		System.out.println("UpperCase Scientific notation" + " using %E:" + formatter);

		System.out.println();
		System.out.println("===== Precision Formats =====");
		System.out.println();

		formatter = new Formatter();
		formatter.format("%10.2e", 1324.4679);
		System.out.println("Scientific notation to 2 places: " + formatter);
		formatter = new Formatter();
		formatter.format("%.4f", 46864.46946);
		System.out.println("Decimal floating-point notation to 4 places: " + formatter);
		formatter = new Formatter();
		formatter.format("%.15s", 468644694);
		System.out.println("String notation to 15 places: " + formatter);
		formatter = new Formatter();
		formatter.format("%010d", 94);
		System.out.println("Value in 10 digits: " + formatter);
	}

}
