package kr.or.devlimk1.reservationweb.dto;

import java.util.List;

public class ReservationInfoDto {
	private int displayInfoId; // 전시상품 id
	private List<ReservationPriceDto> prices;// 예약 가격 정보
	private int productId; // 상품 id
	private String reservationEmail; // 예약자 이메일
	private String reservationName; // 예약자명
	private String reservationTelephone; // 예약자 전화번호
	private String reservationYearMonthDay; // 예약일

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public List<ReservationPriceDto> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationPriceDto> prices) {
		this.prices = prices;
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
		return "ReservationDto [displayInfoId=" + displayInfoId + ", prices=" + prices + ", productId=" + productId
				+ ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", reservationYearMonthDay="
				+ reservationYearMonthDay + "]";
	}

}
