package com.amber.fileInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputStreamTest {
	/**
	 * FileInputStream文件输入流
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			//返回值如果是-1的话，那么证明读到了文件末尾
			int data ;
			while ((data = fis.read()) != -1) {
				//data实际上是ASCII 编码，如果要输出需要转化成char类型
				System.out.print((char) data);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
	
	/**
	 * 优化test1方法，每次读取多个字节
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			//使用字节数组接受从文件中读取到的数据
			byte[] data = new byte[7];
			int len = -1;
			while ((len = fis.read(data)) != -1) {
				//正确的写法
				String string = new String(data, 0, len);
				//一种错误的写法,可以自己输出看看发生了什么，产生的原因，是因为字节数组中存在上一次读取的字节
//				String string = new String(data, 0, data.length);
				System.out.print(string);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
