package kr.or.devlimk1.reservationweb.dto;

public class PromotionsView extends Promotion {
	private String productImageUrl;

	public PromotionsView() {
		// TODO Auto-generated constructor stub
	}
	
	public PromotionsView(String productImageUrl) {
		super();
		this.productImageUrl = productImageUrl;
	}



	public String getProductImageUrl() {
		return productImageUrl;
	}


	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	@Override
	public String toString() {
		return "PromotionsView [toString()=" + super.toString() + ", productImageUrl=" + productImageUrl+ "]";
	}



	
	
	

}
