package kr.or.devlimk1.reservationweb.dao;

import static kr.or.devlimk1.reservationweb.dao.ReservationInfoDaoSqls.INSERT_RESERVATION_INFO;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.devlimk1.reservationweb.dto.ReservationInfoDto;

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
    	this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

	public void insertReservationInfo(ReservationInfoDto reservationInfo,int reservationInfoId) {
		
//		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
//		return insertAction.executeAndReturnKey(params).longValue();
//		INSERT_RESERVATION_INFO
		int result=jdbcTemplate.update(INSERT_RESERVATION_INFO,
				reservationInfoId,
				reservationInfo.getProductId(),
				reservationInfo.getDisplayInfoId(),
				reservationInfo.getReservationName(),
				reservationInfo.getReservationTelephone(),
				reservationInfo.getReservationEmail(),
				reservationInfo.getReservationYearMonthDay(),
				reservationInfo.getReservationYearMonthDay(),
				reservationInfo.getReservationYearMonthDay()
				);
		System.out.println(result);
	}
}
