package kr.or.devlimk1.reservationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.devlimk1.reservationweb.dto.CommentDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductPriceDto;
import kr.or.devlimk1.reservationweb.service.ReservationService;

@Controller
public class DetailController {

	@Autowired
	ReservationService reservationService;

	@GetMapping(path = "/detail/{displayInfoId}")
	public String getDetail(@PathVariable Integer displayInfoId, ModelMap model) {
		DisplayInfoDto displayInfo = reservationService.getDisplayInfo(displayInfoId);
		DisplayInfoImageDto displayInfoImage = reservationService.getDisplayInfoImage(displayInfoId);
		List<ProductImageDto> productImages = reservationService.getProductImages(displayInfo.getProductId());
		List<CommentDto> comments = reservationService.getComments(displayInfo.getProductId());
		List<ProductPriceDto> productPrices = reservationService.getProductPrices(displayInfo.getProductId());
		double averageScore = reservationService.getAverageScore(comments);

		// 백분율 환산
		averageScore = Math.floor(averageScore * 10) / 10.0; // 첫째자리까지
		int valueWidth = (int) (averageScore * 100 / 5.0);
		int cmtCount = comments.size();

		model.addAttribute("displayInfoId", displayInfoId);
		model.addAttribute("comments", comments);
		model.addAttribute("displayInfo", displayInfo);
		model.addAttribute("displayInfoImage", displayInfoImage);
		model.addAttribute("productImages", productImages);
		model.addAttribute("productPrices", productPrices);
		model.addAttribute("averageScore", averageScore);
		model.addAttribute("valueWidth", valueWidth);
		model.addAttribute("cmtCount", cmtCount);
		return "detail";
	}

	@GetMapping(path = "/review/{displayInfoId}")
	public String getReview(@PathVariable("displayInfoId") Integer displayInfoId, ModelMap model) {
		DisplayInfoDto displayInfo = reservationService.getDisplayInfo(displayInfoId);
		List<CommentDto> comments = reservationService.getComments(displayInfo.getProductId());
		double averageScore = reservationService.getAverageScore(comments);

		// 백분율 환산
		averageScore = Math.floor(averageScore * 10) / 10.0; // 첫째자리까지
		int valueWidth = (int) (averageScore * 100 / 5.0);
		int cmtCount = comments.size();

		model.addAttribute("displayInfoId",displayInfoId);
		model.addAttribute("comments", comments);
		model.addAttribute("averageScore", averageScore);
		model.addAttribute("valueWidth", valueWidth);
		model.addAttribute("cmtCount", cmtCount);

		return "review";
	}
	
	
	@GetMapping(path = "/myreservation")
	public String getMyReservation() {
		return "myreservation";
	}

}
