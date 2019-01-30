package com.amber.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class BufferInputOutputStreamTest {
	
	@Test
	public void test1() {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			File inFile = new File("beauty.jpg");
			File outFile = new File("beauty_out.jpg");
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] data = new byte[1024];
			int len = 0;
			while((len = bis.read(data)) != -1) {
				bos.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				
				if (bos != null) {
					bos.close();
				}
				
				if (fis != null) {
					fis.close();
				}
				
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
