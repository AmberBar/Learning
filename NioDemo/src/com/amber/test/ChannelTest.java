package com.amber.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.net.ssl.StandardConstants;

import org.junit.Test;

/**
 * channel通道，主要负责源节点和目标节点的连接，解决Java NIO中缓冲区数据的传输
 * channel不存储数据，数据存储在buffer中
 * java.nio.channels.channel接口
 * 	FileChannel	本地文件传输
 * 	socketChannel   TCP
 * 	ServerSocketChannel TCP
 * 	DatagramChannel	UDP
 * @author amber
 *
 *　获取通道
 *getChannel()
 *JDK1.7以后NIO2
 *
 *４．通道之间直接数据传输
 *	transferFrom
 *	transFerTo
 *5. 分散与聚集
 *分散读取scatter read
 *６．字符集
 *编码: 字符串　－>字节数组
 *解码:　字节数组 -> 字符集
 */
public class ChannelTest {
	
	/**
	 * 分散读取和聚集写入
	 */
	@Test
	public void test3() {
		long start = System.currentTimeMillis();
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			//建立通道
			inChannel = FileChannel.open(Paths.get("./resource/Java NIO.pdf"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("./resource/Java NIOCopyTest2.pdf"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			ByteBuffer buffer1 = ByteBuffer.allocate(200);
			ByteBuffer buffer2 = ByteBuffer.allocate(1024);
			ByteBuffer[] byteBuffers = {buffer1, buffer2};
			
			for (ByteBuffer byteBuffer : byteBuffers) {
				byteBuffer.flip();
			}
			//分散读取，从一个通道读取到多个缓冲区
			inChannel.read(byteBuffers);
			//聚集写入，从多个缓冲区写入到一个通道
			outChannel.write(byteBuffers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
				if (inChannel != null) {
					inChannel.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间 " + (end - start));
	}
	/**
	 * 直接缓冲区方式之二
	 * transferFrom
	 * transferTo
	 */
	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			//建立通道
			inChannel = FileChannel.open(Paths.get("./resource/Java NIO.pdf"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("./resource/Java NIOCopyTest2.pdf"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
		//	inChannel.transferTo(0, inChannel.size(), outChannel);
			outChannel.transferFrom(inChannel, 0, inChannel.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
				if (inChannel != null) {
					inChannel.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间直接缓冲区" + (end - start));
	}
	
	/**
	 * 直接缓冲区,用内存映射文件完成
	 * 可能遇到的问题: 文件已经copy完成，但是程序可能没有完成。我们只能控制什么时候写入映射文件，但是不能控制什么时候从映射文件写入磁盘
	 */
	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		MappedByteBuffer inMap = null;
		MappedByteBuffer outMap = null;
		
		try {
			//建立通道
			inChannel = FileChannel.open(Paths.get("./resource/Java NIO.pdf"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("./resource/Java NIOCopyTest2.pdf"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			//因为是内存文件映射，我们不需要读流,内存映射文件
			//MappedByteBuffer 相当于allocateDriect()
			inMap = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
			outMap = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			byte[] bytes = new byte[inMap.limit()];
			inMap.get(bytes);
			outMap.put(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
				if (inChannel != null) {
					inChannel.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间直接缓冲区" + (end - start));
	}
	/**
	 * 利用通道完成文件复制
	 * @throws IOException 
	 */
	@Test
	public void test() {
		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			//jdk1.7以前NIO 的获取通道的写法
			fis  = new FileInputStream("./resource/Java NIO.pdf");
			fos = new FileOutputStream("./resource/demoCopyTest.jpeg");
			
			//1.获取通道
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			//2.创建缓冲区,并分配大小
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			//３．把数据写进缓冲区
			while (inChannel.read(byteBuffer) != -1) {
				
				//4.切换读取数据模式
				byteBuffer.flip();
				outChannel.write(byteBuffer);
				byteBuffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
				if (inChannel != null) {
					inChannel.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间非直接缓存" + (end - start));
	}
}
