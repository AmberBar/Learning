package com.amber;

import java.util.Arrays;

import org.junit.Test;

public class SeasonTest {
	
	/**
	 * java5之后定义枚举类的方法values
	 */
	@Test
	public void seasonTest() {
		//values()获取枚举类中所有的对象
		Season1[] values = Season1.values();
		System.out.println(Arrays.toString(values));
	}
	
	/**
	 * valueOf的用法
	 */
	@Test
	public void seasonValueOf() {
		//valueOf(String name)根据对象名称获得对象
		Season1 spring = Season1.valueOf("SPRING");
		System.out.println(spring);
		//valueOf(Class<T> enumTYpe, String name)根据名称返回指定类型的枚举对象
		Season1 summer = Season1.valueOf(Season1.class, "SUMMER");
		System.out.println(summer);
	}
	
	/**
	 * 重写show方法
	 */
	@Test
	public void seasonShow() {
		Season1 spring = Season1.valueOf("SPRING");
		Season1 summer = Season1.valueOf("SUMMER");
		spring.show();
		summer.show();
	}
}
