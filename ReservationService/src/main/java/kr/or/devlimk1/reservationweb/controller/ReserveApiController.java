package kr.or.devlimk1.reservationweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.devlimk1.reservationweb.dto.ReservationInfoDto;
import kr.or.devlimk1.reservationweb.service.ReservationService;


@RestController
public class ReserveApiController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping(path = "/api/reservations")
	public ModelAndView saveReservationInfo(@RequestBody ReservationInfoDto reservationInfo, ModelAndView view){
		view.setViewName("mainpage");
		int reservationInfoId=reservationInfo.getPrices().get(0).getReservationInfoId();//예약 id
		
		reservationService.saveReservation(reservationInfo,reservationInfoId);
//		reservationService.saveReservation(reservationInfo.getPrices());
		
		System.out.println(reservationInfo);
		return view;
	}
}
