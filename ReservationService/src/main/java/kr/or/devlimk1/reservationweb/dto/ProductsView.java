package kr.or.devlimk1.reservationweb.dto;

public class ProductsView {
	
	private int displayInfoId;
	private int productId;
	private String productDescription;
	private String placeName;
	private String productContent;
	private String productImageUrl;
	
	public ProductsView() {
		// TODO Auto-generated constructor stub
	}


	public ProductsView(int displayInfoId, int productId, String productDescription, String placeName,
			String productContent, String productImageUrl) {
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.productDescription = productDescription;
		this.placeName = placeName;
		this.productContent = productContent;
		this.productImageUrl = productImageUrl;
	}


	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	@Override
	public String toString() {
		return "ProductsView [displayInfoId=" + displayInfoId + ", productId=" + productId + ", productDescription="
				+ productDescription + ", placeName=" + placeName + ", productContent=" + productContent
				+ ", productImageUrl=" + productImageUrl + "]";
	}
	
	
	
	
}
