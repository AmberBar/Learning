package com.amber;

/**
 * java5.0以前，定义枚举类。类中的对象是有限的
 * @author amber
 *
 */
public enum Season1 {
	//定义枚举对象.需要把对象放在第一行
	SPRING ("春天", "春意盎然"){
		@Override
		public void show() {
			System.out.println("This is Spring!");
		}
	},
	SUMMER ("夏天", "夏日炎炎"),
	AUTUMN ("秋天", "秋风习习"),
	WINTER ("冬天", "白雪皑皑");
	
	private final String seasonName;
	private final String seasonDescription;
	
	private Season1(String seasonName, String seasonDescription) {
		this.seasonName = seasonName;
		this.seasonDescription = seasonDescription;
	}
	public void show() {
		System.out.println("This is Season!");
	}
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDescription() {
		return seasonDescription;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDescription=" + seasonDescription + "]";
	}
}
