package kr.or.devlimk1.reservationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		
		model.addAttribute("productImages", productImages);
		model.addAttribute("displayInfo", displayInfo);
		model.addAttribute("displayInfoImage", displayInfoImage);
		model.addAttribute("productPrices",productPrices);
		
		return "reserve";
	}
}
