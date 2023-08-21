package io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializationDemo {

	public static void main(String[] args) throws IOException {
		Employee employee = new Employee();
		employee.setInd(1);
		employee.setName("Radu");
		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1500");
		props.put("city", "Bucharest");
		employee.setProps(props);

		var byteArrayOutputStream = serializeEmployee(employee);
		Employee copyEmployee = deserizeEmployee(byteArrayOutputStream);
		System.out.println(copyEmployee);
	}

	private static Employee deserizeEmployee(ByteArrayOutputStream byteArrayOutputStream) {
		try (var ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
			return (Employee) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ByteArrayOutputStream serializeEmployee(Employee employee) {
		try (var byteArrOutputStream = new ByteArrayOutputStream();
				var oos = new ObjectOutputStream(byteArrOutputStream)) {
			oos.writeObject(employee);
			return byteArrOutputStream;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
