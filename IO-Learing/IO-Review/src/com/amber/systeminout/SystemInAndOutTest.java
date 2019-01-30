package com.amber.systeminout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class SystemInAndOutTest {
	
	@Test
	public void test() throws IOException {
		//把字节输入流转化成转化流
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while(true) {
			String str;
			
			if ((str = br.readLine()) != null) {
				if (str.equalsIgnoreCase("EXIT")) {
					break;
				}
				System.out.println(str.toUpperCase());
			}
		}
	}

}
