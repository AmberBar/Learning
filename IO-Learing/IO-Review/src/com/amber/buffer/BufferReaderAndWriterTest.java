package com.amber.buffer;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class BufferReaderAndWriterTest {
	
	@Test
	public void test() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		FileReader fr = null;
		try {	
			File inFile = new File("fileReaderAndWriter.txt");
			File outFile = new File("fileReaderAndWriter_out.txt");
			fr = new FileReader(inFile);
			fw = new FileWriter(outFile);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			char[] data = new char[1024];
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}
		
	}
}
