package kr.or.devlimk1.reservationweb.service;

import java.util.List;

import kr.or.devlimk1.reservationweb.dto.Category;
import kr.or.devlimk1.reservationweb.dto.CommentDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoImageDto;
import kr.or.devlimk1.reservationweb.dto.ImagesInfoView;
import kr.or.devlimk1.reservationweb.dto.ProductImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductPriceDto;
import kr.or.devlimk1.reservationweb.dto.ProductsView;
import kr.or.devlimk1.reservationweb.dto.PromotionsView;
import kr.or.devlimk1.reservationweb.dto.ReservationInfoDto;
import kr.or.devlimk1.reservationweb.dto.ReservationPriceDto;

public interface ReservationService {
	public static final Integer PRODUCTS_VIEW_LIMIT=4; //Map의 키와 값은 객체여야함으로 Integer 
	public List<ImagesInfoView> getThImages();
	public List<PromotionsView> getPromotions();
	public List<ProductsView> getProducts(Integer categoryId, Integer start);
	public List<ProductsView> getProductsAll(Integer start);
	public List<Category> getCategories(); //카테고리 정보들
	public int getCategoryCount(Integer id);
	public int getCategoryCountAll();
	
	/**************detail page**********************/
	public DisplayInfoImageDto getDisplayInfoImage(Integer displayInfoId);
	public DisplayInfoDto getDisplayInfo(Integer displayInfoId);
	public List<ProductImageDto> getProductImages(Integer displayInfoId);
	public List<CommentDto> getComments(Integer productId);
	public List<ProductPriceDto> getProductPrices(Integer productId);
	public double getAverageScore(List<CommentDto> comments);
	
	/**************reserve page**********************/
	public ReservationInfoDto saveReservation(ReservationInfoDto reservationInfo,int reservationInfoId);
	public void saveReservation(List<ReservationPriceDto> prices);
	
}
