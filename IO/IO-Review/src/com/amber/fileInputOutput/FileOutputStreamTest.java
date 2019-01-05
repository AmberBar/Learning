package com.amber.fileInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileOutputStreamTest {
	
	/**
	 * 直接输出的话，文件不存在就会创建文件
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		FileOutputStream fos = null;
		try {
			File file = new File("fileOutputStream_test.txt");
			fos = new FileOutputStream(file);
			fos.write("I LOVE JAVA!!!".getBytes());
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
	
	
	@Test
	public void test2() throws IOException {
		FileOutputStream fos = null;
		try {
			File file = new File("fileOutputStream_test.txt");
			//直接覆盖文件
			fos = new FileOutputStream(file);
			//追加文件
//			fos = new FileOutputStream(file, true);
			fos.write("I LOVE JAVA123!!!".getBytes());
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
}

