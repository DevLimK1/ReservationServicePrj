package kr.or.devlimk1.reservationweb.dto;

import java.util.Date;

public class Product {
	private int id;
	private int categoryId;
	private String description;
	private String content;
	private String event;
	private Date createDate;
	private Date modifyDate;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Product(int id, int categoryId, String description, String content, String event, Date createDate,
			Date modifyDate) {
		this.id = id;
		this.categoryId = categoryId;
		this.description = description;
		this.content = content;
		this.event = event;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}




	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getCategoryId() {
		return categoryId;
	}





	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getContent() {
		return content;
	}





	public void setContent(String content) {
		this.content = content;
	}





	public String getEvent() {
		return event;
	}





	public void setEvent(String event) {
		this.event = event;
	}





	public Date getCreateDate() {
		return createDate;
	}





	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}





	public Date getModifyDate() {
		return modifyDate;
	}





	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}





	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", description=" + description + ", content="
				+ content + ", event=" + event + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

	
}
