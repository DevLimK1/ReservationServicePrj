package kr.or.devlimk1.reservationweb.dto;

public class ProductPriceDto {
	private String createDate;
	private double discountRate;
	private String modifyDate;
	private Integer price;
	private String priceTypeName;
	private Integer productId;
	private Integer productPriceId;

	public ProductPriceDto() {
	}

	public ProductPriceDto(String createDate, double discountRate, String modifyDate, Integer price,
			String priceTypeName, Integer productId, Integer productPriceId) {
		super();
		this.createDate = createDate;
		this.discountRate = discountRate;
		this.modifyDate = modifyDate;
		this.price = price;
		this.priceTypeName = priceTypeName;
		this.productId = productId;
		this.productPriceId = productPriceId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}

	@Override
	public String toString() {
		return "ProductPriceDto [createDate=" + createDate + ", discountRate=" + discountRate + ", modifyDate="
				+ modifyDate + ", price=" + price + ", priceTypeName=" + priceTypeName + ", productId=" + productId
				+ ", productPriceId=" + productPriceId + "]";
	}

}
