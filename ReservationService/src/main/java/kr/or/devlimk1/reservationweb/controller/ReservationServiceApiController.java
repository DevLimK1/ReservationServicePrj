package kr.or.devlimk1.reservationweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.devlimk1.reservationweb.dto.CommentDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductPriceDto;
import kr.or.devlimk1.reservationweb.dto.ProductsView;
import kr.or.devlimk1.reservationweb.dto.PromotionsView;
import kr.or.devlimk1.reservationweb.dto.RespCategoriesDto;
import kr.or.devlimk1.reservationweb.service.ReservationService;

//@RequestMapping(path = "/api/")
@RestController
public class ReservationServiceApiController {

	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path = "/api/promotions")
	public Map<String, Object> getPromotions() {
		
		Map<String, Object> map = new HashMap<>();
		List<PromotionsView> promotions = null;

		promotions = reservationService.getPromotions();

		map.put("items", promotions);

		return map;
	}
	
	@GetMapping(path = "/api/categories") // tab 클릭시
	public RespCategoriesDto getCategories() {

		RespCategoriesDto dto = new RespCategoriesDto();
		
		int start = 0;
		
		dto.setCategories(reservationService.getCategories());
		dto.setStart(start);
		
		return dto;
	}
	
	@GetMapping(path = "/api/products") // 더보기 클릭시
	public Map<String, Object> getProducts(
			@RequestParam(name = "categoryId", defaultValue = "0") int categoryId,
			@RequestParam(name = "start", defaultValue = "0") int start) {

		Map<String, Object> map = new HashMap<>();
		List<ProductsView> products = null;

		int count = 0;

		if (categoryId == 0)
			products = reservationService.getProductsAll(start);
		else
			products = reservationService.getProducts(categoryId, start);

		if (categoryId == 0) {// 전체 카테고리
			count = reservationService.getCategoryCountAll();
		} else {
			count = reservationService.getCategoryCount(categoryId);
		}

		map.put("totalCount", count);
		map.put("items", products);

		return map;

	}
	
	/*****************detail page****************************/
	
	@GetMapping(path = "/api/products/{displayInfoId}")
	public Map<String, Object> getDisplayInfo(@PathVariable Integer displayInfoId){
		Map<String, Object> map = new HashMap<>();
		DisplayInfoDto displayInfo = reservationService.getDisplayInfo(displayInfoId);
		DisplayInfoImageDto displayInfoImage=reservationService.getDisplayInfoImage(displayInfoId);
		List<ProductImageDto> productImages=reservationService.getProductImages(displayInfo.getProductId());
		List<CommentDto> comments=reservationService.getComments(displayInfo.getProductId());
		List<ProductPriceDto> productPrices=reservationService.getProductPrices(displayInfo.getProductId());
		double averageScore=reservationService.getAverageScore(comments);
		
		map.put("comments", comments);
		map.put("displayInfo",displayInfo);
		map.put("displayInfoImage",displayInfoImage);
		map.put("productImages",productImages);
		map.put("averageScore", averageScore);
		map.put("productPrices", productPrices);
		
		return map;
		
	}
	

}
