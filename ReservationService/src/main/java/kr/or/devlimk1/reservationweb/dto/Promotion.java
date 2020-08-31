package kr.or.devlimk1.reservationweb.dto;

public class Promotion {
	private int id;
	private int productId;

	public Promotion() {
	}

	public Promotion(int id, int productId) {
		this.id = id;
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + "]";
	}

}