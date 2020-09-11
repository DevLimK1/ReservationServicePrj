package kr.or.devlimk1.reservationweb.dto;

public class ReservationPriceDto {
	private int count; //예약 상품 수
	private int productPriceId; //상품 가격 id
	private int reservationInfoId;//예약 id
	private int reservationInfoPriceId; //예약 가격 id
	
	
	public ReservationPriceDto() {
	}
	
	
	
	public ReservationPriceDto(int count, int productPriceId, int reservationInfoId, int reservationInfoPriceId) {
		super();
		this.count = count;
		this.productPriceId = productPriceId;
		this.reservationInfoId = reservationInfoId;
		this.reservationInfoPriceId = reservationInfoPriceId;
	}



	public int getCount() {
		return count;
	}




	public void setCount(int count) {
		this.count = count;
	}




	public int getProductPriceId() {
		return productPriceId;
	}




	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}




	public int getReservationInfoId() {
		return reservationInfoId;
	}




	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}




	public int getReservationInfoPriceId() {
		return reservationInfoPriceId;
	}




	public void setReservationInfoPriceId(int reservationInfoPriceId) {
		this.reservationInfoPriceId = reservationInfoPriceId;
	}




	@Override
	public String toString() {
		return "ReservationPriceDto [count=" + count + ", productPriceId=" + productPriceId + ", reservationInfoId="
				+ reservationInfoId + ", reservationInfoPriceId=" + reservationInfoPriceId + "]";
	}
	
	
}
