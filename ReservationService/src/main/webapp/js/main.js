window.addEventListener("DOMContentLoaded", function() {

	let header = document.querySelector(".header");

	header.onclick = function(e) {
		e.preventDefault();
	}

	// ************** promotion slider *****************************

	let containerVisual = document.querySelector(".inner.container_visual");
	let visualImg = containerVisual.querySelector(".visual_img");// ul태그
	let promotionItem = document.querySelector("#promotionItem");
	let slides = promotionItem.querySelectorAll(".slide");
	let images = visualImg.querySelectorAll("img");
	
	let slideCount = 0; // 슬라이드 개수
	let currentCount = 0; // 슬라이드 이미지 현재위치 카운트
	let count = 0; // 슬라이드 이동할 px 카운트
	let timer = 0; // 슬라이드 이미지간의 시간간격을 주기위한 변수
	let slideWidth = 0; // 슬라이드 너비
	let visualImgWidth = 0; // ul태그 width값 가지고오기

	let oReq = new XMLHttpRequest();

	oReq.open('GET', '/api/promotions');

	oReq.addEventListener("load",function() {
				let json = JSON.parse(oReq.responseText);
				
				// 템플릿에 json 데이타를 넣고
				let list = json.items;

				let promotionTemplate = document.querySelector("#promotionItem").innerHTML;
				let resultTemplate = "";

				for ( let val in list) {
					let item = list[val];
					resultTemplate += promotionTemplate.replace(
							"{productImageUrl}", item.productImageUrl);
				}

				// ul태그에 template
				visualImg.innerHTML = resultTemplate;

				slides = visualImg.querySelectorAll(".slide");
				slideCount = slides.length;
				visualImgWidth = parseInt(getComputedStyle(visualImg).width);
				slideWidth = Math.ceil(visualImgWidth / slideCount);

				requestAnimationFrame(run);
			});

	oReq.send();


	function run() {
		if (timer === 150) {// 슬라이드간의 시간차를 할당

			if (currentCount === slideCount - 1) { // 마지막 이미지가 보이면

				visualImg.style.setProperty("transform", "translateX(" + 0 + "px)"); // ul태그 시작

				visualImg.insertAdjacentElement("afterbegin",
						slides[slideCount - 1]); // 마지막사진을 ul태그 바로 아래 첫번째 태그로 구현

				slides = visualImg.querySelectorAll(".slide"); // 위 과정을 반복하기 위해 slide들의 index 조정
				count = 0;
			}

			timer = 0;
			currentCount++;
			if (currentCount === slideCount)
				currentCount = 1; // 마지막 이미지에 도달하면 그 다음 이미지를 멈추지않고 계속 움직이게 보이려고 구현

		} else {

			if (count <= slideWidth * currentCount) { // 슬라이드 이동
				visualImg.style.setProperty("transform", "translateX(" + -count + "px)");
				count += 6;
			}

			timer++;
		}

		requestAnimationFrame(run);
	};

	// ************** Tab UI *****************************
	let more = document.querySelector('.more');
	let sectionEventTab = document.querySelector('.section_event_tab');
	let eventTabLst = sectionEventTab.querySelector('.event_tab_lst');
	let sectionEventLst = document.querySelector('.section_event_lst');
	let eventLstTxt = sectionEventLst.querySelector('.event_lst_txt');
	let template = document.querySelector('#itemListCount').innerHTML;
	

	sectionEventLst.onclick = function(e) {
//		e.preventDefault();
	}

	eventTabLst.onclick = function(e) { // 카테고리 탭 클릭
		let elem = e.target;
		let activeElem = e.target;
		let anchorAll = eventTabLst.querySelectorAll('.anchor');
		let categoryId = 0;
		
		// a태그 전체 active 초기화
		for (let i = 0; i < anchorAll.length; i++) {
			if (anchorAll[i].classList.contains("active"))
				anchorAll[i].classList.remove("active");
		}

		// elem을 li 태그로 변환, 변환과정에 A태그라면 active 추가
		if (elem.tagName === 'SPAN') {
			elem = elem.parentElement.parentElement;
			activeElem.parentElement.classList.add("active");
		} else if (elem.tagName === 'A') {
			elem.classList.add("active");
			elem = elem.parentElement;
		} else if (elem.tagName === 'LI') {
			elem.firstElementChild.classList.add("active");
		} else if (elem.tagName === 'UL') {
			return;
		}

		categoryId = parseInt(elem.getAttribute("data-category"));
		sendCategoriesAjax("/api/categories", categoryId);
	}

	function sendCategoriesAjax(url, categoryId) {

		let oReq = new XMLHttpRequest();
		oReq.open('GET', url);

		oReq.addEventListener("load", function() {

			let json = JSON.parse(oReq.responseText);
			let categories = json.categories;

			getCategoryCount(categories,categoryId);

			sendProductsAjax("/api/products", categoryId);

		});

		oReq.send();

	}// end of sendAjax(url,categoryId)

	
	function getCategoryCount(items,categoryId) { // 카테고리 카운트
		let categoryCnt = 0;
		let resultTemplate = "";

		for ( let val in items) { // 카테고리 카운트 변경
			if (items[val].id === categoryId) {
				resultTemplate = template.replace("{count}", items[val].count);
				break;
			}
			categoryCnt += items[val].count;
		}

		if (categoryId === 0)
			resultTemplate = template.replace("{count}", categoryCnt);

		eventLstTxt.innerHTML = resultTemplate; // count 변경
	}

	function sendProductsAjax(url, categoryId) {
		let oReq2 = new XMLHttpRequest();

		// 카테고리에 맞는 상품리스트 정보 가져오기
		if (categoryId === 0)
			oReq2.open('GET', url);
		else
			oReq2.open('GET', url + "?categoryId=" + categoryId);

		oReq2.addEventListener("load", function() {
			let json = JSON.parse(oReq2.responseText);
			let list = json.items;
			let listSize = list.length;
			let start=4;
			
			if (listSize !== 0) // 추가적인 상품리스트가 있다면 더보기 버튼 보이게하기
				more.classList.remove("hide");

			let listTemplate = document.querySelector("#itemList").innerHTML;
			let listResultTemplate = "";

			let eventBox = document.querySelectorAll('.lst_event_box');

			for (let i = 0; i < list.length; i++) {
				let item = list[i];
				listResultTemplate += listTemplate.replace(/{displayInfoId}/gi,item.displayInfoId)
												  .replace(/{description}/gi,item.productDescription) // 정규식을 이용하여 중복되는 {description}을 변경
												  .replace("{saveFileName}", item.productImageUrl)
												  .replace("{placeName}", item.placeName)
												  .replace("{content}",item.productContent);

				if (listSize % 2 == 0) {// 품목 수가 짝수일 때
					if ((listSize / 2 - 1) == i) {
						eventBox[0].innerHTML = listResultTemplate;
						listResultTemplate = "";
					} else if ((listSize - 1) == i) { // 두번째 ul태그에 삽입
						eventBox[1].innerHTML = listResultTemplate;
					}
				} else {// 홀수 일 때
					if (Math.floor(listSize / 2) == i) {
						eventBox[0].innerHTML = listResultTemplate;
						listResultTemplate = "";
					} else if ((listSize - 1) == i) { // 두번째 ul태그에 삽입
						eventBox[1].innerHTML = listResultTemplate;
					}
				}

			}

			more.setAttribute('data-category', categoryId);
			more.setAttribute('data-start', start);
		});
		oReq2.send();

	}

	/** ************** 더보기 ********************** */

	let btn = more.querySelector('.btn');

	more.onclick = function(e) {
		let categoryId = e.currentTarget.dataset.category; // data-category
		let start = e.currentTarget.getAttribute("data-start");// data-start
		
		let oReq = new XMLHttpRequest();

		if (categoryId === 0)
			oReq.open('GET', '/api/products?start=' + start);
		else
			oReq.open('GET', '/api/products?categoryId=' + categoryId
					+ '&start=' + start);

		oReq.addEventListener("load", function() {
			let json = JSON.parse(oReq.responseText);
			let list = json.items;
			let totalCount=json.totalCount;

			let listSize = list.length;

			let template = document.querySelector("#itemList").innerHTML;
			let resultTemplate = "";

			let eventBox = document.querySelectorAll('.lst_event_box');

			for (let i = 0; i < list.length; i++) {
				let item = list[i];
				resultTemplate += template.replace(/{displayInfoId}/gi,item.displayInfoId)
										  .replace(/{description}/gi,item.productDescription) // 정규식을 이용하여 중복되는 {description}을 변경
										  .replace("{saveFileName}", item.productImageUrl)
										  .replace("{placeName}", item.placeName)
										  .replace("{content}",item.productContent);

				if (listSize % 2 == 0) {// 품목 수가 짝수일 때
					if ((listSize / 2 - 1) == i) {
						eventBox[0].insertAdjacentHTML("beforeend",resultTemplate);
						resultTemplate = "";
					} else if ((listSize - 1) == i) { // 두번째 ul태그에 삽입
						eventBox[1].insertAdjacentHTML("beforeend",resultTemplate);
					}
				} else {// 품목 수가 홀수 일 때

					if (Math.floor(listSize / 2) == i) {
						eventBox[0].insertAdjacentHTML("beforeend",
								resultTemplate);
						resultTemplate = "";
					} else if ((listSize - 1) == i) { // 두번째 ul태그에 삽입
						eventBox[1].insertAdjacentHTML("beforeend",
								resultTemplate);
					}
				}
			}
			
			start=parseInt(start)+parseInt(listSize);
			
			if(start===totalCount)// 추가적인 상품리스트가 없다면 더보기 버튼 감추기
				more.classList.add("hide");
			
			more.setAttribute('data-category', categoryId);
			more.setAttribute('data-start', start);

		});
		oReq.send();
	}
	

	/**************** detail page **************************/
	let wrapEventBox=document.querySelector('.wrap_event_box');
	
//	wrapEventBox.onclick=clickItem;
//	
//	function clickItem(e){
//		e.preventDefault();
//		
//		console.log(e.target);
//	}
	
	

});
