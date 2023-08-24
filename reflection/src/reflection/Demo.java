package reflection;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class userClass = new User().getClass();
		System.out.println("Get class name: " + userClass.getName());

		Field[] fields = userClass.getDeclaredFields();
		System.out.println("\n===== Get Fields Names =====");
		Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));

		System.out.println("\n===== Get Fields Type =====");
		Arrays.stream(fields).forEach(field -> System.out.println(field.getType()));

		System.out.println("\n===== Does Field have private modifier? =====");
		Arrays.stream(fields).forEach(field -> System.out.println(Modifier.isPrivate(field.getModifiers())));

		System.out.println("Get package name: " + userClass.getPackageName());

		System.out.println("Get super class: " + userClass.getSuperclass());

		System.out.println("\n===== Get Interfaces =====");
		Class[] interfaces = userClass.getInterfaces();
		Arrays.stream(interfaces).forEach(i -> System.out.println(i.getName()));

		System.out.println("\n===== Get Constructors =====");
		Constructor<User>[] constructors = userClass.getDeclaredConstructors();
		System.out.println("Number of constructors: " + constructors.length);
		Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));

		System.out.println("\n===== Get Private Constructor =====");
		Constructor<User> privateConstrutor = userClass.getDeclaredConstructor(String.class);
		System.out.println(privateConstrutor);

		System.out.println("\n===== Get Methods =====");
		Method[] methods = userClass.getDeclaredMethods();
		Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));

//		System.out.println("\n===== Get Method =====");
//		Method method = userClass.getMethod("mergeTwoUserAccounts", User.class);
//		System.out.println(method);

		System.out.println("\n===== New Instance =====");
		Constructor<User> defaultContructor = userClass.getConstructor();
		User newInstance = defaultContructor.newInstance();
		System.out.println(newInstance);
		System.out.println(privateConstrutor.newInstance("mircea@gmail.com"));

		System.out.println("\n===== Field initalization =====");
		Field firstNameField = userClass.getDeclaredField("firstName");
		firstNameField.setAccessible(true);
		firstNameField.set(newInstance, "Georgiana");
		System.out.println(newInstance);

		System.out.println("\n===== Static Field initalization =====");
		Field idField = userClass.getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(null, 26);
		System.out.println(newInstance);

		System.out.println("\n===== Read Value from Field +====");
		System.out.println(firstNameField.get(newInstance));
		System.out.println(idField.get(null));

		System.out.println("\n===== Method invocation =====");
		Method privateMethod = userClass.getDeclaredMethod("doSomething", String.class);
		privateMethod.setAccessible(true);
		privateMethod.invoke(newInstance, "Test String");

		System.out.println("\n===== Static Method invocation =====");
		Method privateStaticMethod = userClass.getDeclaredMethod("doSomethingStatic", String.class);
		privateStaticMethod.setAccessible(true);
		privateStaticMethod.invoke(null, "Test private static method");
	}

	private static class User implements Serializable, Cloneable {

		private static int id = 0;

		private String firstName;
		private String lastName;
		private String email;

		static {
			id++;
		}

		private User(String defaultEmail) {
			this.email = defaultEmail;
		}

		public User() {
			this("default@user.com");
		}

		public void printFullNameToConsole() {
			System.out.println(firstName + " " + lastName);
		}

		public double calculateTotalAmountSpentInOnlineStore() {
			return 1347.87;
		}

		public void mergeTwoUsersAccount(User anotherUser) {

		}

		private void doSomething(String someString) {
			System.out.println("Private method invocation with arguments: " + someString);
		}

		private static void doSomethingStatic(String someString) {
			System.out.println("Private static method invocation with arguments: " + someString);
		}

		@Override
		public String toString() {
			return "User [Id: " + id + " firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";

		}
	}
}
