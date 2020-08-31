package kr.or.devlimk1.reservationweb.dto;

import java.util.List;

public class CommentDto {
	private String comment;
	private Integer commentId;
	private List<CommentImageDto> commentImages;
	private String createDate;
	private String modifyDate;
	private Integer productId;
	private String reservationDate;
	private String reservationEmail;
	private Integer reservationInfoId;
	private String reservationName;
	private String reservationTelephone;
	private double score;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}

	
	public CommentDto(String comment, Integer commentId, List<CommentImageDto> commentImages, String createDate,
			String modifyDate, Integer productId, String reservationDate, String reservationEmail,
			Integer reservationInfoId, String reservationName, String reservationTelephone, double score) {
		super();
		this.comment = comment;
		this.commentId = commentId;
		this.commentImages = commentImages;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.productId = productId;
		this.reservationDate = reservationDate;
		this.reservationEmail = reservationEmail;
		this.reservationInfoId = reservationInfoId;
		this.reservationName = reservationName;
		this.reservationTelephone = reservationTelephone;
		this.score = score;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public List<CommentImageDto> getCommentImages() {
		return commentImages;
	}

	public void setCommentImages(List<CommentImageDto> commentImages) {
		this.commentImages = commentImages;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public Integer getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "CommentDto [comment=" + comment + ", commentId=" + commentId + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", productId=" + productId + ", reservationDate=" + reservationDate
				+ ", reservationEmail=" + reservationEmail + ", reservationInfoId=" + reservationInfoId
				+ ", reservationName=" + reservationName + ", reservationTelephone=" + reservationTelephone + ", score="
				+ score + "]";
	}

	
	
	
	
}
