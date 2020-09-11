package kr.or.devlimk1.reservationweb.dto;

import java.util.List;

public class ReservationDto {
	private int displayInfoId; //전시상품 id
	private List<ReservationPriceDto> reservationPrices;//예약 가격 정보
	private int productId; //상품 id
	private String reservationEmail; //예약자 이메일
	private String reservationName; //예약자명
	private String reservationTelephone; //예약자 전화번호
	private String reservationYearMonthDay; //예약일
	
	public ReservationDto() {
	}
	
	public ReservationDto(int displayInfoId, List<ReservationPriceDto> reservationPrices, int productId,
			String reservationEmail, String reservationName, String reservationTelephone,
			String reservationYearMonthDay) {
		this.displayInfoId = displayInfoId;
		this.reservationPrices = reservationPrices;
		this.productId = productId;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTelephone = reservationTelephone;
		this.reservationYearMonthDay = reservationYearMonthDay;
	}


	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public List<ReservationPriceDto> getReservationPrices() {
		return reservationPrices;
	}
	public void setReservationPrices(List<ReservationPriceDto> reservationPrices) {
		this.reservationPrices = reservationPrices;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationTelephone() {
		return reservationTelephone;
	}
	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}
	public String getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}
	public void setReservationYearMonthDay(String reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}
	
	@Override
	public String toString() {
		return "ReservationDto [displayInfoId=" + displayInfoId + ", productId=" + productId + ", reservationEmail="
				+ reservationEmail + ", reservationName=" + reservationName + ", reservationTelephone="
				+ reservationTelephone + ", reservationYearMonthDay=" + reservationYearMonthDay + "]";
	}	
	
}
