package com.sample.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化
 * 
 * @author zhengy
 *
 */
public class SimpleSerial {
	public static void main(String[] args) throws Exception {
		File file = new File("d:\\person.out");
		// serialize(file);
		deserialize(file);

	}

	public static void serialize(File file) throws FileNotFoundException, IOException {
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Person person = new Person("John", 101, Gender.MALE);
		oout.writeObject(person);
		oout.close();
	}

	public static void deserialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject();
		oin.close();
		System.out.println(newPerson);
	}
}
