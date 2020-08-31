package kr.or.devlimk1.reservationweb.dao;

public class ReservationDaoSqls {
	
	public static final String SELECT_PRODUCT_TH_IMAGES="SELECT * FROM (SELECT p.id, p.product_id, p.type, p.file_id , f.save_file_name FROM product_image p JOIN file_info f ON p.file_id = f.id) r WHERE type='th'";
	
	public static final String SELECT_PROMOTIONS="SELECT p.id, i.product_id AS productId,f.save_file_name AS productImageUrl FROM promotion p JOIN product_image i ON p.product_id = i.product_id JOIN file_info f ON i.file_id = f.id WHERE i.type = 'th'";
	
	public static final String SELECT_COUNT="SELECT COUNT(*) " + 
			"FROM (SELECT p.id, p.category_id, c.name AS category_name, p.description, p.content, pi.type, pi.file_id, d.place_name, f.save_file_name " + 
			"FROM product p LEFT JOIN product_image pi ON p.id = pi.product_id LEFT JOIN display_info d ON p.id = d.product_id LEFT JOIN display_info_image di ON d.id = di.display_info_id LEFT JOIN file_info f ON pi.file_id = f.id LEFT JOIN category c ON p.category_id = c.id) r " + 
			"WHERE type='th' GROUP BY category_id HAVING category_id=:id";
	
	
	public static final String SELECT_COUNT_ALL="SELECT COUNT(*) " + 
			"FROM (SELECT p.id, p.category_id, c.name AS category_name, p.description, p.content, pi.type, pi.file_id, d.place_name, f.save_file_name " + 
			"FROM product p LEFT JOIN product_image pi ON p.id = pi.product_id LEFT JOIN display_info d ON p.id = d.product_id LEFT JOIN display_info_image di ON d.id = di.display_info_id LEFT JOIN file_info f ON pi.file_id = f.id LEFT JOIN category c ON p.category_id = c.id) r " + 
			"WHERE type='th'";
	

	public static final String SELECT_CATEGORIES="SELECT category_id id,category_name name,COUNT(*) count " + 
			"FROM (SELECT p.id, p.category_id, c.name AS category_name, p.description, p.content, pi.type, pi.file_id, d.place_name, f.save_file_name " + 
			"FROM product p LEFT JOIN product_image pi ON p.id = pi.product_id LEFT JOIN display_info d ON p.id = d.product_id LEFT JOIN display_info_image di ON d.id = di.display_info_id LEFT JOIN file_info f ON pi.file_id = f.id LEFT JOIN category c ON p.category_id = c.id) r " + 
			"WHERE type='th' GROUP BY category_id";
	
	
	public static final String SELECT_PRODUCTS="SELECT displayInfoId,productId,productDescription,placeName,productContent,productImageUrl " + 
			"FROM (SELECT DISTINCT d.id AS displayInfoId, d.product_id AS productId, v.description AS productDescription, d.place_name AS placeName, v.content AS productContent, v.save_file_name AS productImageUrl " + 
			"FROM (SELECT p.id, p.category_id, c.name AS category_name, p.description, p.content, pi.type, pi.file_id, d.place_name, f.save_file_name " + 
			"FROM product p LEFT JOIN product_image pi ON p.id = pi.product_id LEFT JOIN display_info d ON p.id = d.product_id LEFT JOIN display_info_image di ON d.id = di.display_info_id LEFT JOIN file_info f ON pi.file_id = f.id LEFT JOIN category c ON p.category_id = c.id) v JOIN display_info d ON v.id = d.product_id " + 
			"WHERE v.type = 'th') v JOIN product p ON p.id=v.productId WHERE category_id=:categoryId limit :start, :limit";
	
	public static final String SELECT_PRODUCTS_ALL="SELECT displayInfoId,productId,productDescription,placeName,productContent,productImageUrl " + 
			"FROM (SELECT DISTINCT d.id AS displayInfoId, d.product_id AS productId, v.description AS productDescription, d.place_name AS placeName, v.content AS productContent, v.save_file_name AS productImageUrl " + 
			"FROM (SELECT p.id, p.category_id, c.name AS category_name, p.description, p.content, pi.type, pi.file_id, d.place_name, f.save_file_name " + 
			"FROM product p LEFT JOIN product_image pi ON p.id = pi.product_id LEFT JOIN display_info d ON p.id = d.product_id LEFT JOIN display_info_image di ON d.id = di.display_info_id LEFT JOIN file_info f ON pi.file_id = f.id LEFT JOIN category c ON p.category_id = c.id) v JOIN display_info d ON v.id = d.product_id " + 
			"WHERE v.type = 'th') v JOIN product p ON p.id=v.productId limit :start , :limit";
	
	
	/*****************detail page****************************/
	
	public static final String SELECT_DISPLAY_INFO="SELECT p.id productId, p.category_id categoryId,c.name categoryName,d.id displayInfoId, p.description productDescription,p.content productContent,p.event productEvent,\r\n" + 
			"d.opening_hours openingHours, d.place_name placeName,d.place_lot placeLot,d.place_street placeStreet,d.tel telephone,\r\n" + 
			"d.homepage homepage, d.email ,d.create_date createDate,d.modify_date modifyDate FROM product p JOIN category c ON p.category_id= c.id\r\n" + 
			"JOIN display_info d ON d.product_id = p.id WHERE d.id=:displayInfoId";
	
	public static final String SELECT_PRODUCT_IMAGES="SELECT p.product_id productId,p.id productImageId,p.type,p.file_id fileInfoId,\r\n" + 
			"f.file_name fileName, f.save_file_name saveFileName,f.content_type contentType,\r\n" + 
			"f.delete_flag deleteFlag,f.create_date createDate,f.modify_date modifyDate FROM file_info f JOIN product_image p ON f.id=p.file_id WHERE type NOT IN ('th') and p.product_id=:productId limit :limit";
	
	public static final String SELECT_DISPLAY_INFO_IMAGE="SELECT d.id displayInfoImageId, d.display_info_id displayInfoId, d.file_id fileId,\r\n" + 
			"f.file_name fileName, f.save_file_name saveFileName, f.content_type contentType,\r\n" + 
			"f.delete_flag deleteFlag, f.create_date createDate, f.modify_date modifyDate FROM display_info_image d JOIN file_info f ON d.file_id = f.id WHERE d.display_info_id =:displayInfoId";
	
	public static final String SELECT_COMMENTS="SELECT c.id commentId,c.product_id productId,c.reservation_info_id reservationInfoId,\r\n" + 
			"c.score, c.comment,r.reservation_name reservationName,r.reservation_tel reservationTelephone,\r\n" + 
			"r.reservation_email reservationEmail,r.reservation_date reservationDate,c.create_date createDate,c.modify_date modifyDate FROM reservation_user_comment c JOIN product p ON c.product_id = p.id\r\n" + 
			"JOIN reservation_info r ON c.reservation_info_id =r.id WHERE c.product_id = :productId ORDER BY commentId DESC";
	
	public static final String SELECT_COMMENT_IMAGES="SELECT r.id imageId, r.reservation_info_id reservationInfoId,r.reservation_user_comment_id reservationUserCommentId,\r\n" + 
			"r.file_id fileId, f.file_name fileName,f.save_file_name saveFileName,f.content_type contentType,\r\n" + 
			"f.delete_flag deleteFlag, f.create_date createDate, f.modify_date modifyDate FROM reservation_user_comment_image r JOIN file_info f ON r.file_id =f.id WHERE r.reservation_user_comment_id=:reservationUserCommentId";
	
	public static final String SELECT_PRODUCT_PRICES="SELECT id productPriceId,product_id productId,price_type_name priceTypeName,price,discount_rate discountRate,create_date createDate,modify_date modifyDate FROM product_price WHERE product_id=:productId";
}
