package com.amber.objectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.amber.pojo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ObjectInputOutputStreamTest {
	
	@Test
	public void test() throws FileNotFoundException, IOException {
		User user = new User();
		user.setAge(18);
		user.setName("amber");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		oos.writeObject(user);
		oos.flush();
		oos.close();
	}
	
	@Test
	public void test2() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
		User user = (User)ois.readObject();
		System.out.println(user.toString());
		ois.close();
	}
}
