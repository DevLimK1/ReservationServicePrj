package kr.or.devlimk1.reservationweb.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.devlimk1.reservationweb.dto.ReservationInfoDto;
import kr.or.devlimk1.reservationweb.service.ReservationService;


@RestController
public class ReserveApiController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping(path = "/api/reservations")
	public Map<String, String> saveReservationInfo(@RequestBody ReservationInfoDto reservationInfo,HttpServletResponse response) throws IOException{
		Map<String, String> url=new HashMap<String, String>();
		int reservationInfoId=reservationInfo.getPrices().get(0).getReservationInfoId();//예약 id
		int displayInfoId=reservationInfo.getDisplayInfoId();
//		String url="/detail/"+displayInfoId;
		
		reservationService.saveReservation(reservationInfo,reservationInfoId);
		url.put("url", "/detail/"+displayInfoId);
		return url;
	}
}
