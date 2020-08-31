package kr.or.devlimk1.reservationweb.dto;

import java.util.List;

public class RespCategoriesDto {
	private List<Category> categories;
	private int start;
	
	
	public RespCategoriesDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RespCategoriesDto(List<Category> categories, int start) {
		super();
		this.categories = categories;
		this.start = start;
	}

	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public int getStart() {
		return start;
	}




	public void setStart(int start) {
		this.start = start;
	}




	@Override
	public String toString() {
		return "RespCategoriesDto [categories=" + categories + ", start=" + start + "]";
	}
	
	
}
