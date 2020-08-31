package kr.or.devlimk1.reservationweb.dao;

import static kr.or.devlimk1.reservationweb.dao.ReservationDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.devlimk1.reservationweb.dto.Category;
import kr.or.devlimk1.reservationweb.dto.CommentDto;
import kr.or.devlimk1.reservationweb.dto.CommentImageDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoDto;
import kr.or.devlimk1.reservationweb.dto.DisplayInfoImageDto;
import kr.or.devlimk1.reservationweb.dto.ImagesInfoView;
import kr.or.devlimk1.reservationweb.dto.ProductImageDto;
import kr.or.devlimk1.reservationweb.dto.ProductPriceDto;
import kr.or.devlimk1.reservationweb.dto.ProductsView;
import kr.or.devlimk1.reservationweb.dto.PromotionsView;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ImagesInfoView> imagesInfoViewRowMapper = BeanPropertyRowMapper.newInstance(ImagesInfoView.class);
	private RowMapper<Category> categoryRowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	private RowMapper<ProductsView> productsRowMapper = BeanPropertyRowMapper.newInstance(ProductsView.class);
	private RowMapper<PromotionsView> promotionsRowMapper = BeanPropertyRowMapper.newInstance(PromotionsView.class);

	/***************detail page******************8*/
	private RowMapper<DisplayInfoDto> displayInfoMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);
	private RowMapper<DisplayInfoImageDto> displayInfoImageMapper = BeanPropertyRowMapper
			.newInstance(DisplayInfoImageDto.class);
	private RowMapper<ProductImageDto> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImageDto.class);
	private RowMapper<CommentDto> commentsRowMapper = BeanPropertyRowMapper.newInstance(CommentDto.class);
	private RowMapper<CommentImageDto> commentImagesRowMapper = BeanPropertyRowMapper
			.newInstance(CommentImageDto.class);
	private RowMapper<ProductPriceDto> productPricesRowMapper=BeanPropertyRowMapper
			.newInstance(ProductPriceDto.class);	

	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	// 메인화면 썸네일 이미지들 조회
	public List<ImagesInfoView> selectThImages() {
		return jdbc.query(SELECT_PRODUCT_TH_IMAGES, Collections.emptyMap(), imagesInfoViewRowMapper);
	}

	public List<PromotionsView> selectPromotions() {
		return jdbc.query(SELECT_PROMOTIONS, Collections.emptyMap(), promotionsRowMapper);
	}

	// 전체 카테고리 상품리스트
	public List<ProductsView> selectProductsAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(SELECT_PRODUCTS_ALL, params, productsRowMapper);
	}

	// 카테고리에 따른 상품리스트
	public List<ProductsView> selectProducts(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(SELECT_PRODUCTS, params, productsRowMapper);
	}

	// 카테고리별 정보들(categoryId,categoryName,count)
	public List<Category> selectCategories() {
		return jdbc.query(SELECT_CATEGORIES, Collections.emptyMap(), categoryRowMapper);
	}

	// 상품리스트 전체 카테고리 개수
	public int selectCountAll() {
		return jdbc.queryForObject(SELECT_COUNT_ALL, Collections.emptyMap(), Integer.class);
	}

	// 상품리스트 카테고리별 개수
	public int selectCount(Integer id) {
		Map<String, ?> param = Collections.singletonMap("id", id);
		return jdbc.queryForObject(SELECT_COUNT, param, Integer.class);
	}

	/***************** detail page ****************************/

	public DisplayInfoDto selectDisplayInfo(Integer displayInfoId) {
		Map<String, ?> param = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(SELECT_DISPLAY_INFO, param, displayInfoMapper);
	}

	public DisplayInfoImageDto selectDisplayInfoImage(Integer displayInfoId) {
		Map<String, ?> param = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(SELECT_DISPLAY_INFO_IMAGE, param, displayInfoImageMapper);
	}

	public List<ProductImageDto> selectProductImages(Integer productId) {
		int limit = 2; // 상단 사진 2개 노출
		Map<String, Integer> params = new HashMap<>();

		params.put("productId", productId);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_IMAGES, params, productImageRowMapper);
	}

	public List<CommentDto> selectComments(Integer productId) {
		Map<String, ?> param = Collections.singletonMap("productId", productId);
		List<CommentDto> comments = jdbc.query(SELECT_COMMENTS, param, commentsRowMapper);
		List<CommentImageDto> commentImages = null;

		int index = 0;
		for (CommentDto comment : comments) { // comments의 commentImages 추가
			param = Collections.singletonMap("reservationUserCommentId", comment.getCommentId());
			commentImages = jdbc.query(SELECT_COMMENT_IMAGES, param, commentImagesRowMapper);

			if (commentImages != null) { // commentImages가 있다면
				comments.get(index).setCommentImages(commentImages);
			}

			index++;
		}

		return comments;
	}
	
	public List<ProductPriceDto> selectProductPrices(Integer productId){
		Map<String,?> param= Collections.singletonMap("productId", productId);
		return jdbc.query(SELECT_PRODUCT_PRICES, param,productPricesRowMapper);
	}

}
