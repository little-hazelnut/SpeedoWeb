package edu.csu.speedo.control;

public class Item {
	private int num;
	private String id;

	public Item(int num, String id) {
		this.num = num;
		this.id = id;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public String id() {
		return id;
	}
}
