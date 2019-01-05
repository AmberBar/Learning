package com.amber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

/**
 * 1.java.io.file
 * 2.file可以表示文件也可以表示文件目录
 * @author amberlei
 *
 */
public class FileTest {
	
	public static void main(String[] args) {
		try {
			printDirFiles(new File("/home/amberlei/Videos"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 遍历某个目录下的所有文件，并输出文件绝对路径
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static void printDirFiles(File file) throws FileNotFoundException {
		if (file == null || !file.exists()) {
			throw new FileNotFoundException("file doesn't exist");
		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File listFile : listFiles) {
				printDirFiles(listFile);
			}
		} else {
			System.out.println(file.toString());
		}
	}
	@Test
	public void fileTest() throws IOException {
		File file = new File("hello.txt");
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		File file2 = new File(file.getParent(),"hello1.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
	}
}
