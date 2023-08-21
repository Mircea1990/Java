package io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {

	public static void main(String[] args) {
		User user = new User("nickname", "password");
		var byteArrayOutputStream = serializeUser(user);

		User copyUser = deserizeUser(byteArrayOutputStream);
		System.out.println(copyUser);
	}

	private static User deserizeUser(ByteArrayOutputStream byteArrayOutputStream) {
		try (var ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
			return (User) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ByteArrayOutputStream serializeUser(User user) {
		try (var byteArrayOutputStream = new ByteArrayOutputStream();
				var oos = new ObjectOutputStream(byteArrayOutputStream)) {

			oos.writeObject(user);
			return byteArrayOutputStream;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
