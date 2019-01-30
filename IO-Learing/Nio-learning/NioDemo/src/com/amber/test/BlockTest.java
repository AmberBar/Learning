package com.amber.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * 阻塞式Nio demo
 * @author amber
 *
 */
public class BlockTest {
	
	
	@Test
	public void serverTest() {
		ServerSocketChannel serverSocketChannel = null;
		FileChannel fileChannel = null;
		SocketChannel socketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(9898));
			socketChannel = serverSocketChannel.accept();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			fileChannel = FileChannel.open(Paths.get("./resource/blockTest.jpeg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

			while (socketChannel.read(byteBuffer) != -1) {
				byteBuffer.flip();
				System.out.println(byteBuffer);
				fileChannel.write(byteBuffer);
				byteBuffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fileChannel != null) {
					fileChannel.close();
				}
				if (serverSocketChannel != null) {
					serverSocketChannel.close();
				}
				if (socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void socketTest() {
		SocketChannel socketChannel = null;
		FileChannel fileChannel = null;
		ByteBuffer buffer = null;
		try {
			socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
			fileChannel = FileChannel.open(Paths.get("./resource/demo.jpeg"), StandardOpenOption.READ);
			buffer = ByteBuffer.allocate(1024);
			while (fileChannel.read(buffer) != -1) {
				buffer.flip();
				socketChannel.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fileChannel != null) {
					fileChannel.close();
				}
				if (socketChannel != null) {
					socketChannel.close();
				}
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
