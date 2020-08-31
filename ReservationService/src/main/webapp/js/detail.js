window.addEventListener("DOMContentLoaded", function(e) {

	let sectionBtn=document.querySelector(".section_btn");
	let container = document.querySelector('#container');
	let displayInfo = container.querySelector('.displayInfo');
	let displayInfoId = displayInfo.value; // 해당 페이지 아이디값 추출

	sectionBtn.onclick=function(){
		location.href="/reserve/"+displayInfoId;
	}
	
	
	// Ajax로 상품 전시 정보 가져오기
	sendProductsAjax("/api/products", displayInfoId);

	function sendProductsAjax(url, displayInfoId) {
		let oReq = new XMLHttpRequest();
		oReq.open('GET', `${url}/${displayInfoId}`);

		oReq.addEventListener("load", function() {

			let json = JSON.parse(oReq.responseText);
			let productImages = json.productImages; // 상단 이미지들
			let displayInfo = json.displayInfo; // 전시 타이틀

			// 상품 이미지가 2개있으면 prev,next 표시
			if (productImages.length == 1) {
				$(".prev").css("display", "none");
				$(".nxt").css("display", "none");
			}
			
			// ************** 상단 slider *****************************

			let containerVisual = document.querySelector(".container_visual");
			let visualImg = containerVisual.querySelector(".visual_img");// ul태그
			let slideItem = document.querySelector("#slideItem");
			let images = visualImg.querySelectorAll("img");
			let nxtBtn = document.querySelector(".nxt_inn");
			let prevBtn = document.querySelector(".prev_inn");
			let prevIcon=prevBtn.querySelector("i");
			let pagination=document.querySelector(".pagination");
			let bindTemplate;
			
			let pageTemplate=document.querySelector("#pager").innerHTML;
			let pageResultTemplate="";
			
			const slideObj = {
				slideCount : 0, // 슬라이드 개수
				currentCount : 1, // 슬라이드 이미지 현재위치 카운트
				position: 1,
				slideWidth : 0, // 슬라이드 너비
				visualImgWidth : 0, // ul태그 width값 가지고오기
				init : function(){
					slides = visualImg.querySelectorAll(".item");
					this.slideCount = slides.length;
					this.visualImgWidth = parseInt(getComputedStyle(visualImg).width);
					this.slideWidth = Math.ceil(this.visualImgWidth / this.slideCount);
				},
				showSlide :function(){ // ★ slideObj. 으로 접근말고 this. 으로 접근할 수 있는 방법은 없을까요? ★ 
					visualImg.style.setProperty("transform", "translateX("
							+ -slideObj.slideWidth + "px)");
			

					if (slideObj.currentCount === slideObj.slideCount - 1) { // 마지막 이미지가 보이면
						visualImg.style.setProperty("transform", "translateX("
								+ 0 + "px)");

						visualImg.insertAdjacentElement("afterbegin",
								slides[slideObj.slideCount - 1]); // 마지막사진을 ul태그 바로 아래 첫번째 태그로 구현

						slides = visualImg.querySelectorAll(".item"); 
					}

					slideObj.currentCount++;
					slideObj.position++;
						
					bindTemplate=Handlebars.compile(pageTemplate);
					pageResultTemplate=bindTemplate(slideObj);
					pagination.innerHTML=pageResultTemplate;
					
					if (slideObj.currentCount === slideObj.slideCount){
						slideObj.currentCount = 1; 
						slideObj.position=0;
					}
					
					if(visualImg.children[0].classList.contains("first")){ //첫 이미지이면 이전버튼 off 추가
						prevIcon.classList.add("off");
						slideObj.position = 1;
					}
					else
						prevIcon.classList.remove("off");
				}
			}

			let slideTemplate = document.querySelector("#slideItem").innerHTML;
			let resultTemplate = "";
			bindTemplate= Handlebars.compile(slideTemplate);
			
			for ( let product in productImages) {
				let item = productImages[product];
				item["productDescription"]=displayInfo.productDescription;
				resultTemplate+=bindTemplate(item);
			}

			// ul태그에 template
			visualImg.innerHTML = resultTemplate;
			visualImg.children[0].classList.add("first");
		
			slideObj.init(); //객체 리터럴 Obj 초기화
			
			//상단 이미지 슬라이드 페이저 초기화
			bindTemplate=Handlebars.compile(pageTemplate);
			pageResultTemplate=bindTemplate(slideObj);
			pagination.innerHTML=pageResultTemplate;

			nxtBtn.onclick =slideObj.showSlide;	
			prevBtn.onclick= slideObj.showSlide;
			 
		});

		oReq.send();
	}

	
	// 펼쳐보기/ 접기 기능
	$(".bk_more").click(function(e) {
		e.preventDefault();
		$(".store_details").toggleClass("close3");
		$(".bk_more").toggle();
	});

	const detailObj={
			showDetail : function(){
				$(".item._path").removeClass("active");
				$(".item._path").children(".anchor").removeClass("active");
				$(".detail_area_wrap").removeClass("hide");
				$(".detail_location").addClass("hide");					
			}
	}
	
	const pathObj={
			showPath : function(){
				$(".item._detail").removeClass("active");
				$(".item._detail").children(".anchor").removeClass("active");
				$(".detail_area_wrap").addClass("hide");
				$(".detail_location").removeClass("hide");					
			}
	}
	
	$(".info_tab_lst").click(function(e){
		e.preventDefault();
		let elem=$(e.target);
		
		while(!elem.hasClass("item")){
			elem=elem.parent();
		}
		
		elem.addClass("active");
		elem.children(".anchor").addClass("active");
		
		if(elem.hasClass("_detail")){
			detailObj.showDetail();
		}else if(elem.hasClass("_path")){
			pathObj.showPath();
		}
		
	});
	
	$(".bottom_common_path").click(function(e){ //길찾기, 네비게이션 버튼 반응X
		e.preventDefault();
	});
	
	$(".detail_location").click(function(e){
		e.preventDefault();
	});
	
	
	
});