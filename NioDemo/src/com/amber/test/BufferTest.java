package com.amber.test;


import java.nio.ByteBuffer;

import org.junit.Test;
// 0 < mark <=position <= limit <= capacity
public class BufferTest {
	
	private byte[] byteArrs;
	
	/**
	 * 直接缓冲区与非直接缓冲区
	 * 非直接缓冲区通过allocate()方法分配内存,存放在JVM内存中
	 * 直接缓冲区通过allocateDirect()，存放在物理内存中，此方法可以提高效率
	 * 直接缓冲区通过在物理内存中的映射文件达到提高效率，弊端就是消耗资源。
	 */
	@Test
	public void test3() {
		//直接缓冲区与非直接缓冲区
		//创建非直接缓冲区
		ByteBuffer allocate = ByteBuffer.allocate(1024);
		//创建直接缓冲区
		ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
		//判断是否是直接缓冲区
		System.out.println(allocate.isDirect());
		System.out.println(allocateDirect.isDirect());
	}
	@Test
	public void test() {
		String str = "123";
		//指定buffer的容量大小
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//属性
		System.out.println("-----------------------");
		//当前操作的数据所在的位置
		System.out.println(buffer.position());
		//界限，表示缓冲区中可以操作数据的大小，　limit后的数据不能读写
		System.out.println(buffer.limit());
		//缓冲区中最大存储数据容量
		System.out.println(buffer.capacity());
		
		buffer.put(str.getBytes());
		System.out.println("---------put--------------");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		//切换成读模式
		buffer.flip();
		System.out.println("---------flip--------------");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		byteArrs = new byte[buffer.limit()];
		ByteBuffer byteBuffer = buffer.get(byteArrs);
		System.out.println(byteBuffer.toString());
		// rewind,切换成读模式，可以重新读
		buffer.rewind();
		System.out.println("===========rewind============");
		System.out.println(buffer.toString());
		
		//清空缓存区,数据依然存在。数据处于被遗忘状态
		buffer.clear();
		System.out.println("===========clear============");
		System.out.println(buffer);
		System.out.println((char)buffer.get());
	}
	
	@Test
	public void markTest() {
//		可以记录position位置,有点类似于事物的save()保存点
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("134654".getBytes());
		//可以通过reset()可以回到mark记录的位置
		buffer.flip();
		byte[] bytes = new byte[buffer.limit()];
		ByteBuffer byteBuffer = buffer.get(bytes, 0 , 2);
		System.out.println(byteBuffer);
		System.out.println(bytes);
		for (byte b : bytes) {
			System.out.println((char)b);
		}
		//标记点
		buffer.mark();
		ByteBuffer byteBuffer1 = buffer.get(bytes, 2 , 2);
		System.out.println(byteBuffer1);
		//回到标记点
		buffer.reset();
		System.out.println(byteBuffer1);
		
		//查看缓冲区还有没有可以操作的数据
		if (buffer.hasRemaining()) {
			//查看缓冲区还有可操作数据的个数
			System.out.println(buffer.limit() - buffer.position());
			System.out.println(buffer.remaining());
		}
	}
}
