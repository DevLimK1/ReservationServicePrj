package kr.or.devlimk1.reservationweb.dto;

public class ImagesInfoView {
		private int id;
		private int productId;
		private String type;
		private int fileId;
		private String saveFileName;
	
	public ImagesInfoView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ImagesInfoView(int id, int productId, String type, int fileId, String saveFileName) {
		this.id = id;
		this.productId = productId;
		this.type = type;
		this.fileId = fileId;
		this.saveFileName = saveFileName;
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
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "ImagesInfoView [id=" + id + ", productId=" + productId + ", type=" + type + ", fileId=" + fileId
				+ ", saveFileName=" + saveFileName + "]";
	}
	
	
	
}
