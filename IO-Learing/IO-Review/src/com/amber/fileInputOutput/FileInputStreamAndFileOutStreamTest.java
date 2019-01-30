package com.amber.fileInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 同时使用输出流和输入流
 * @author amberlei
 *
 */
public class FileInputStreamAndFileOutStreamTest {
	
	@Test
	public void test1() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			fos = new FileOutputStream(new File("hello1.txt"));
			byte[] data = new byte[fis.available()];
			int len = -1;
			while ((len = fis.read(data)) != -1) {
				fos.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		
	}
}
