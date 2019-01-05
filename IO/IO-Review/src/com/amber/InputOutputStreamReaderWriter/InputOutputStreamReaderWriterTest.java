package com.amber.InputOutputStreamReaderWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 转化流，实现字节流到字符流直接的转换
 * 需要知道编码集
 * @author amberlei
 *
 */
public class InputOutputStreamReaderWriterTest {
	
	/**
	 * 转化流，可以指定编码集，这样可以实现不同编码的转化
	 */
	@Test
	public void test() {
		File file = new File("fileReaderAndWriter_GKB.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw  = null;
		InputStreamReader isr = null;
		
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream("fileReaderAndWriter_utf-8.txt");
			isr = new InputStreamReader(fis, "GBK");
			osw = new OutputStreamWriter(fos, "utf-8");
			int len;
			char[] data = new char[1024];
			while ((len = isr.read(data)) != -1) {
				osw.write(data,0,len);
				osw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) {
					osw.close();
				}
				if (isr != null) {
					osw.close();
				}
				if (fis != null) {
					osw.close();
				}
				if (fos != null) {
					osw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
