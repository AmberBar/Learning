package com.amber;

/**
 * java5.0以前，定义枚举类。类中的对象是有限的
 * @author amber
 *
 */
public class Season {
	private final String seasonName;
	private final String seasonDescription;
	
	private Season(String seasonName, String seasonDescription) {
		this.seasonName = seasonName;
		this.seasonDescription = seasonDescription;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDescription() {
		return seasonDescription;
	}
	
	//定义枚举对象
	public static final Season SPRING = new Season("春天", "春意盎然");
	public static final Season SUMMER = new Season("夏天", "夏日炎炎");
	public static final Season AUTUMN = new Season("秋天", "秋风习习");
	public static final Season WINTER = new Season("冬天", "白雪皑皑");

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDescription=" + seasonDescription + "]";
	}
}
