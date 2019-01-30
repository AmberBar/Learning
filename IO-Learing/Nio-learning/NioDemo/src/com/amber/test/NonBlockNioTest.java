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
			//创建Selector对象
			Selector selector = Selector.open();
			//把serverSocketChannel交给Selector管理，并绑定监听状态OP_ACCEPT
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			serverSocketChannel.bind(new InetSocketAddress(9898));
			while (selector.select() > 0) {
				//获得迭代器
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					//判断channel是否是 is ready to accept准备
					if (selectionKey.isAcceptable()) {
						//服务器连接请求！！！这个时候才连接，而不是像阻塞Io那样，不管三七二十一直接连接请求
						SocketChannel socketChannel = serverSocketChannel.accept();
						//设置成非阻塞
						socketChannel.configureBlocking(false);
						//注册channel到selector,这里注意，SocketChannel是一个新的渠道也需要注册
						//监听read
						socketChannel.register(selector, SelectionKey.OP_READ);
					} else if (selectionKey.isReadable()){
						//获取当前选择器中读就绪的channel
						SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						int len = 0;
						while ((len = socketChannel.read(buffer) )!= -1) {
							buffer.flip();
							//这里可以把客户端传过来的byte做一些转化
							System.out.println(buffer);
							buffer.clear();
						}
					}
					//从迭代器中把已经完成是事件移除
					iterator.remove();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
