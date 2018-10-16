package com.amber.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * 非阻塞式Nio
 * @author yt00786
 *
 */
public class NonBlockNioTest {
	
	@Test
	public void Client() {
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
			//设置非阻塞式
			socketChannel.configureBlocking(false);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			byteBuffer.put("你好".getBytes());
			socketChannel.write(byteBuffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void server() {
		ServerSocketChannel serverSocketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			serverSocketChannel.bind(new InetSocketAddress(9898));
			while (selector.select() > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

				while (iterator.hasNext()) {
					
					SelectionKey selectionKey = iterator.next();
				
					if (selectionKey.isAcceptable()) {

						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);
					} else if (selectionKey.isReadable()){
						//获取当前选择器中读就绪的channel
						SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						int len = 0;
						while ((len = socketChannel.read(buffer) )!= -1) {
							buffer.flip();
							System.out.println(buffer);
							buffer.clear();
						}
					}
					iterator.remove();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
