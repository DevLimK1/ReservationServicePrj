package kr.or.devlimk1.reservationweb.dto;

public class ProductImage {
	private int id;
	private int productId;
	private String type;
	private int fileId;
	
	public ProductImage() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductImage(int id, int productId, String type, int fileId) {
		super();
		this.id = id;
		this.productId = productId;
		this.type = type;
		this.fileId = fileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", productId=" + productId + ", type=" + type + ", fileId=" + fileId + "]";
	}

	
	
}
