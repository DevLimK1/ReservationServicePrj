package kr.or.devlimk1.reservationweb.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.devlimk1.reservationweb.dto.DisplayInfoDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductPriceDto;
import kr.or.devlimk1.reservationweb.service.ReservationService;

@Controller
public class ReserveController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path = "/reserve/{displayInfoId}")
	public String getReserveInfo(@PathVariable Integer displayInfoId,ModelMap model) {
		DisplayInfoImageDto displayInfoImage = reservationService.getDisplayInfoImage(displayInfoId);
		DisplayInfoDto displayInfo = reservationService.getDisplayInfo(displayInfoId);
		List<ProductImageDto> productImages = reservationService.getProductImages(displayInfo.getProductId());
		List<ProductPriceDto> productPrices=reservationService.getProductPrices(displayInfo.getProductId());
		
		
		Calendar cal=Calendar.getInstance(Locale.KOREA);
		String reservationDate="";
		
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int date=cal.get(Calendar.DATE);
		date+=Math.floor(Math.random()*6); //0~5까지의 난수를 현재일에 더한다.
		reservationDate=String.format("%d.%d.%d", year,month,date);
		
		model.addAttribute("reservationDate",reservationDate);
		model.addAttribute("productImages", productImages);
		model.addAttribute("displayInfo", displayInfo);
		model.addAttribute("displayInfoImage", displayInfoImage);
		model.addAttribute("productPrices",productPrices);
		
		return "reserve";
	}
	
	@PostMapping(path = "/api/reseravtions")
	public String saveReservationInfo(){
		
	}
}
