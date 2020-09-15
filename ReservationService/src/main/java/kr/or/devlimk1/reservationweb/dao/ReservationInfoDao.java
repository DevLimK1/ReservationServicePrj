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
//	private NamedParameterJdbcTemplate jdbc;
//    private SimpleJdbcInsert insertAction;
	private JdbcTemplate jdbcTemplate;
	
	public ReservationInfoDao(DataSource dataSource) {
//        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
//        this.insertAction = new SimpleJdbcInsert(dataSource)
//                .withTableName("log")
//                .usingGeneratedKeyColumns("id");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insertReservationInfo(ReservationInfoDto reservationInfo, int reservationInfoId) {
		int result = jdbcTemplate.update(INSERT_RESERVATION_INFO, reservationInfoId, reservationInfo.getProductId(),
				reservationInfo.getDisplayInfoId(), reservationInfo.getReservationName(),
				reservationInfo.getReservationTelephone(), reservationInfo.getReservationEmail(),
				reservationInfo.getReservationYearMonthDay(), reservationInfo.getReservationYearMonthDay(),
				reservationInfo.getReservationYearMonthDay());

//		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
//		return insertAction.executeAndReturnKey(params).longValue();
//		INSERT_RESERVATION_INFO
		
		return result;
	}

	public void insertReservationInfoPrice(List<ReservationPriceDto> prices) {
		try (Connection con= jdbcTemplate.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO reservation_info_price VALUES(?,?,?,?)")) {
			con.setAutoCommit(false);
			
			for (ReservationPriceDto price : prices) {
				pstmt.setInt(1, price.getReservationInfoPriceId());	
				pstmt.setInt(2, price.getReservationInfoId());
				pstmt.setInt(3, price.getProductPriceId());
				pstmt.setInt(4, price.getCount());
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("insertReservationInfoPrice complete");
	}
	
	
}
