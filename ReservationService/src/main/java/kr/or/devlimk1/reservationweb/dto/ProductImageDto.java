package kr.or.devlimk1.reservationweb.dto;

import java.util.Arrays;

public class ProductImageDto {
	private String contentType;
	private String createDate;
	private boolean deleteFlag;
	private Integer fileInfoId;
	private String fileName;
	private String modifyDate;
	private Integer productId;
	private Integer productImageId;
	private String saveFileName;
	private String type; // ma,th,et

	public ProductImageDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductImageDto(String contentType, String createDate, boolean deleteFlag, Integer fileInfoId,
			String fileName, String modifyDate, Integer productId, Integer productImageId, String saveFileName,
			String type) {
		super();
		this.contentType = contentType;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.fileInfoId = fileInfoId;
		this.fileName = fileName;
		this.modifyDate = modifyDate;
		this.productId = productId;
		this.productImageId = productImageId;
		this.saveFileName = saveFileName;
		this.type = type;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getFileInfoId() {
		return fileInfoId;
	}

	public void setFileInfoId(Integer fileInfoId) {
		this.fileInfoId = fileInfoId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImageDto [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag="
				+ deleteFlag + ", fileInfoId=" + fileInfoId + ", fileName=" + fileName + ", modifyDate=" + modifyDate
				+ ", productId=" + productId + ", productImageId=" + productImageId + ", saveFileName=" + saveFileName
				+ ", type=" + type + "]";
	}

}
