package kr.or.devlimk1.reservationweb.dao;

import static kr.or.devlimk1.reservationweb.dao.ReservationInfoDaoSqls.INSERT_RESERVATION_INFO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.devlimk1.reservationweb.dto.ReservationInfoDto;
import kr.or.devlimk1.reservationweb.dto.ReservationPriceDto;

@Repository
public class ReservationInfoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insertReservationInfo(ReservationInfoDto reservationInfo,List<ReservationPriceDto> prices, int reservationInfoId) {
		
		int insertResult=0;
		
		try(Connection con= jdbcTemplate.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_RESERVATION_INFO);
						PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO reservation_info_price VALUES(?,?,?,?)")){
			con.setAutoCommit(false);
			
			//reservation_info table
			pstmt.setInt(1, reservationInfoId);
			pstmt.setInt(2, reservationInfo.getProductId());
			pstmt.setInt(3, reservationInfo.getDisplayInfoId());
			pstmt.setString(4, reservationInfo.getReservationName());
			pstmt.setString(5, reservationInfo.getReservationTelephone());
			pstmt.setString(6, reservationInfo.getReservationEmail());
			pstmt.setString(7, reservationInfo.getReservationYearMonthDay());
			pstmt.setString(8, reservationInfo.getReservationYearMonthDay());
			pstmt.setString(9, reservationInfo.getReservationYearMonthDay());
			
			insertResult = pstmt.executeUpdate();

			//reservation_info_price table
			for (ReservationPriceDto price : prices) {
				pstmt2.setInt(1, price.getReservationInfoPriceId());	
				pstmt2.setInt(2, price.getReservationInfoId());
				pstmt2.setInt(3, price.getProductPriceId());
				pstmt2.setInt(4, price.getCount());
				pstmt2.addBatch();
			}
			
			pstmt2.executeBatch();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return insertResult;
	}

	
}
