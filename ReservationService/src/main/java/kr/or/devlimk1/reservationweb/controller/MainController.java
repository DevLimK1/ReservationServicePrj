package kr.or.devlimk1.reservationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.devlimk1.reservationweb.dto.ImagesInfoView;
import kr.or.devlimk1.reservationweb.dto.ProductsView;
import kr.or.devlimk1.reservationweb.service.ReservationService;

@Controller
public class MainController {

	@Autowired
	ReservationService reservationService;

	@GetMapping(path = "/main")
	public String main(ModelMap model) {

		int start = 0;
		int id = 0; // 카테고리 id 0->전체
		int count = 0; // 카테고리 카운트

		List<ImagesInfoView> images = reservationService.getThImages(); // 프로모션 이미지들
		List<ProductsView> list = reservationService.getProductsAll(start); // 상품리스트
		
		count = reservationService.getCategoryCountAll();

		start += ReservationService.PRODUCTS_VIEW_LIMIT; // 더보기 버튼에 start 값 설정

		model.addAttribute("images", images);
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("start", start);
		model.addAttribute("count", count);

		return "mainpage";
	}

}
