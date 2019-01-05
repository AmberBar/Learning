package com.amber.fileWriterReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 字符流 FileReader FileWriter
 * @author amberlei
 *
 */
public class FileWriterAndReaderStreamTest {
	
	@Test
	public void testFileReaderAndWriter() {
		File file = new File("fileReaderAndWriter.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file);
			fw = new FileWriter(new File("fileReaderAndWriter_1.txt"));
			char[] data = new char[1024];
			int len = -1;
			while ((len = fr.read(data)) != -1) {
				fw.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
