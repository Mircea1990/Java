package io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User implements Externalizable {

	private String nickName;
	private String password;

	public User() {
	}

	public User(String nickName, String password) {
		this.nickName = nickName;
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.nickName);
		out.writeObject("1234");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.nickName = (String) in.readObject();
		this.password = (String) in.readObject();
	}

	@Override
	public String toString() {
		return "User [nickName=" + nickName + ", password=" + password + "]";
	}

}
