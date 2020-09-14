package kr.or.devlimk1.reservationweb.dao;

public class ReservationInfoDaoSqls {
	public static final String INSERT_RESERVATION_INFO=
			"INSERT INTO reservation_info(id,product_id,display_info_id,reservation_name,reservation_tel,reservation_email,\r\n" + 
			"reservation_date,create_date,modify_date) VALUES(?,?,?,?,?,?,?,?,?)";
}
