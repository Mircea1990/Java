package io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ind;
	private String name;
	private Map<String, String> props;

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "Employee [ind=" + ind + ", name=" + name + ", props=" + props + "]";
	}

	/**
	 * this method is executed by jvm when writeObject() is called during
	 * serialization
	 * 
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		// perform any changes with object before serializing it
		oos.defaultWriteObject();
		System.out.println("=============== serialization in-progress");
	}

	/**
	 * this method is executed by jvm when readObject() is called during
	 * serialization
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		// perform any changes with object after deserializing it
		System.out.println("=============== de-serialization in-progress");
	}
}
