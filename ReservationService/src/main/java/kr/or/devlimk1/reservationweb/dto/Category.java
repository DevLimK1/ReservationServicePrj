package kr.or.devlimk1.reservationweb.dto;

public class Category {
	private int id;
	private String name;
	private int count;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Category(int id, String name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
	
	
	
	
}
