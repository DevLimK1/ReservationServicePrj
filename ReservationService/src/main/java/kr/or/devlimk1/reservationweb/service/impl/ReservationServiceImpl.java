package kr.or.devlimk1.reservationweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.devlimk1.reservationweb.dao.ReservationDao;
import kr.or.devlimk1.reservationweb.dao.ReservationInfoDao;
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
import kr.or.devlimk1.reservationweb.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;

	@Autowired
	ReservationInfoDao reservationInfoDao;

	@Override
	@Transactional(readOnly = true)
	public List<ImagesInfoView> getThImages() { // 썸네일 이미지들 가져오기
		List<ImagesInfoView> list = reservationDao.selectThImages();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PromotionsView> getPromotions() { // 프로모션 목록 구하기
		List<PromotionsView> list = reservationDao.selectPromotions();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductsView> getProducts(Integer categoryId, Integer start) {// 카테고리에 따른 상품리스트
		List<ProductsView> list = reservationDao.selectProducts(categoryId, start,
				ReservationService.PRODUCTS_VIEW_LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductsView> getProductsAll(Integer start) {// 전체 카테고리 상품리스트
		List<ProductsView> list = reservationDao.selectProductsAll(start, ReservationService.PRODUCTS_VIEW_LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public int getCategoryCount(Integer id) { // 카테고리 갯수
		return reservationDao.selectCount(id);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCategoryCountAll() { // 전체 카테고리 갯수
		return reservationDao.selectCountAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		List<Category> list = reservationDao.selectCategories();
		return list;
	}

	/***************** detail page ****************************/

	@Override
	@Transactional(readOnly = true)
	public DisplayInfoImageDto getDisplayInfoImage(Integer displayInfoId) {
		DisplayInfoImageDto displayInfoImage = reservationDao.selectDisplayInfoImage(displayInfoId);
		return displayInfoImage;
	}

	@Override
	@Transactional(readOnly = true)
	public DisplayInfoDto getDisplayInfo(Integer displayInfoId) {
		DisplayInfoDto displayInfo = reservationDao.selectDisplayInfo(displayInfoId);
		return displayInfo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductImageDto> getProductImages(Integer productId) {
		List<ProductImageDto> productImages = reservationDao.selectProductImages(productId);
		return productImages;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentDto> getComments(Integer productId) {
		List<CommentDto> comments = reservationDao.selectComments(productId);
		return comments;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductPriceDto> getProductPrices(Integer productId) {
		List<ProductPriceDto> productPrices = reservationDao.selectProductPrices(productId);
		return productPrices;
	}

	@Override
	@Transactional(readOnly = true)
	public double getAverageScore(List<CommentDto> comments) {
		double sum = 0.0;
		double averageScore = 0.0;

		if (comments.size() != 0) {
			for (CommentDto comment : comments) {
				sum += comment.getScore();
			}
			averageScore = sum / comments.size();
		}

		return averageScore;
	}

	@Override
	@Transactional
	public ReservationInfoDto saveReservation(ReservationInfoDto reservationInfo, int reservationInfoId) {
		List<ReservationPriceDto> prices = reservationInfo.getPrices();
		// reservation_info table에 insert
		int result = reservationInfoDao.insertReservationInfo(reservationInfo, reservationInfoId);

		System.out.println("insertReservationInfo result: " + result);
		
		System.out.println("complete");
		return null;
	}

	@Override
	@Transactional
	public void saveReservation(List<ReservationPriceDto> prices) {
			reservationInfoDao.insertReservationInfoPrice(prices);
			
	}

}
