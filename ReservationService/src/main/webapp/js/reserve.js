window.addEventListener("DOMContentLoaded", function(e) {

	const ticketBody = document.querySelector(".ticket_body");
	const totalCount=document.querySelector("#totalCount");
	const bookingAgreement=document.querySelector(".section_booking_agreement");
	const chkAgree=bookingAgreement.querySelector(".chk_agree");
	let totalTicketCount=0;
	let reservationInfoId=15;
	let reservationInfoPriceId=19;
	const counts=document.querySelectorAll(".count_control_input");
	const productPriceIds=document.querySelectorAll(".productPriceId");
	
	//----------티켓 변경--------------//
	ticketBody.onclick = clickTicketCount;

	function clickTicketCount(e) { //티켓 +,- 버튼 클릭
		
		e.preventDefault();
		
		let elem = e.target;
		
		if(!elem.classList.contains("ico_minus3")&&!elem.classList.contains("ico_plus3")){
			return;
		}
		
		let ticketPriceElem=e.target;
		let minusBtn;
		let plusBtn;
		let inputCountElem;
		let ticketPrice;
		let individualPriceElem=elem.parentElement.nextElementSibling;
		let totalPriceElem=individualPriceElem.children[0];
		let totalPrice=totalPriceElem.innerText;
		
		
		if (elem.classList.contains("ico_minus3")) { //변수명 초기화
			minusBtn = elem;
			inputCountElem = minusBtn.nextElementSibling;
			plusBtn=minusBtn.nextElementSibling.nextElementSibling;
		} else if (elem.classList.contains("ico_plus3")) {
			plusBtn = elem;
			inputCountElem = plusBtn.previousElementSibling;
			minusBtn=elem.previousElementSibling.previousElementSibling;
		}
		
		
		while(true){ //티켓 가격 추출
			if(!ticketPriceElem.classList.contains("count_control")){
				ticketPriceElem=ticketPriceElem.parentElement;
			}else if(ticketPriceElem.classList.contains("count_control")){
				ticketPrice=ticketPriceElem.nextElementSibling.children[1].children[0].innerText;
				break;
			}
		}
		

		if (minusBtn === elem) { // 마이너스 버튼 클릭시
			if (inputCountElem.value > 0){
				--inputCountElem.value;
				totalTicketCount--;
				totalPrice=inputCountElem.value*ticketPrice;
				totalPriceElem.innerText=totalPrice;
			}
			
			if(inputCountElem.value==0){
				minusBtn.classList.add("disabled");
				inputCountElem.classList.add("disabled");
				individualPriceElem.classList.remove("on_color");
			}

		} else if (plusBtn === elem) { //플러스 버튼 클릭시
			++inputCountElem.value;
			totalTicketCount++;
			totalPrice=inputCountElem.value*ticketPrice;
			totalPriceElem.innerText=totalPrice;
			if (inputCountElem.value> 0) {
				if(!individualPriceElem.classList.contains("on_color"))
					individualPriceElem.classList.add("on_color");
				
				if (minusBtn.classList.contains("disabled")) {
					minusBtn.classList.remove("disabled");
					inputCountElem.classList.remove("disabled");
				}
			}
		}
		
		totalCount.innerText=totalTicketCount; //총 예매수
		if(totalTicketCount<1 && chkAgree.checked){
			chkAgree.checked=false;
			bkBtnWrap.classList.add("disable");
		}
		
	}	
	
	//--------예매자 정보 유효성 검사---------//
	
	const telWrap=document.querySelector(".inline_control.tel_wrap");
	const tel=telWrap.querySelector("#tel");
	const email=document.querySelector("#email");
	const name=document.querySelector("#name");
	let isTelValidation;
	let isEmailValidation;
	let isNameValidation;
	let infoCnt=0;
	
	name.addEventListener("blur",function(e){
		isNameValidation=check(name,name.value);
	});
	
	tel.addEventListener("blur",function(e){ //전화번호 유효성검사
		isTelValidation=check(tel,tel.value);
		if(!isTelValidation&&tel.value!==""){
			tel.nextElementSibling.style.position="relative";
			tel.nextElementSibling.style.visibility="visible";
			if(chkAgree.checked){
				chkAgree.checked=false;
				bkBtnWrap.classList.add("disable");
			}
		}
	});

	tel.addEventListener("focus",function(e){
		tel.nextElementSibling.style.visibility="hidden";
		tel.nextElementSibling.style.position="absolute";
	});
	
	email.addEventListener("blur",function(e){//이메일 유효성검사
		isEmailValidation=check(email,email.value);
		if(!isEmailValidation&&email.value!==""){
			email.nextElementSibling.style.position="relative";
			email.nextElementSibling.style.visibility="visible";
			if(chkAgree.checked){
				chkAgree.checked=false;
				bkBtnWrap.classList.add("disable");
			}
		}
	});
	
	email.addEventListener("focus",function(e){
		email.nextElementSibling.style.visibility="hidden";
		email.nextElementSibling.style.position="absolute";
	});
	
	const bkBtnWrap=document.querySelector(".bk_btn_wrap");
	chkAgree.onclick=checkAgreement; //이용자 약관 클릭
	
	let flag=true;
	function checkAgreement(e){
		if(isNameValidation&&
				isTelValidation&&
				isEmailValidation&&(totalTicketCount>0)&&flag){
			chkAgree.checked=true;
			bkBtnWrap.classList.remove("disable");
			flag=false;
		}else {
			chkAgree.checked=false;
			bkBtnWrap.classList.add("disable");
			flag=true;
		}
	}
	
	function check(field,str){ //유효성 검사
		let telRegExp=/(^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$)|(^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]))-(\d{3,4})-(\d{4})$)/;
		let emailRegExp=/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/i;
		
		if(field===tel&&str.match(telRegExp)!=null){
			return true;
		}else if(field===email&&str.match(emailRegExp)!=null) {
			return true;
		}else if(field===name&&str!==""){
			return true;
		}else
			return false;
	}
	
	// 이용자 약관 동의 보기/접기 기능
	$(".btn_agreement").click(function(e) {
		e.preventDefault();
		$(e.target).parents(".agreement").toggleClass("open");
	});
	
	
	bkBtnWrap.onclick=doReservation;
	
	function doReservation(e){
		e.preventDefault();
		let elem=e.currentTarget;
		let displayInfoId=parseInt(document.querySelector("#displayInfoId").value);
		let productId=parseInt(document.querySelector("#productId").value);
		let reservationDate=document.querySelector("#reservationDate").value;
		let name="";
		let email="";
		let tel="";
		
//		if(elem.classList.contains("disable"))
//			return;
		
		let formData=$(".form_horizontal").serializeArray();
		for(let data in formData){ //예매자 정보 값 추출
			if(formData[data].name==="name"){
				name=formData[data].value;
			}else if(formData[data].name==="tel"){
				tel=formData[data].value;
			}else if(formData[data].name==="email"){
				email=formData[data].value;
			}
		}
		
		console.log(productId);
		console.log(displayInfoId);
		console.log(reservationDate);
		console.log(name);
		console.log(email);
		console.log(tel);
		
		const obj={
				ticketInfo :{
					count:5,
					productPriceId:1,
					reservationInfoId:1,
					reservationInfoPriceId:1
					}
				}
		
		
		
//		let newObj=Object.keys(obj);
		console.log(Object.keys(obj));
		console.log(Object.values(obj));
		console.log(Object.entries(obj));
		console.log(counts);
		
		for(let i=0;i<counts.length;i++){
			console.log(counts[i].value);
			console.log("productPriceId:");
			console.log(productPriceIds[i].value);
		}
//		console.log(newObj);
//		$.post("/api/reservations",
//				);
		let arr=[{
			 "count": 5,
		      "productPriceId": 1,
		      "reservationInfoId": 16,
		      "reservationInfoPriceId": 20
		},{
			"count": 2,
		      "productPriceId": 2,
		      "reservationInfoId": 16,
		      "reservationInfoPriceId": 21
		}];
		console.log(arr);
		
		$.ajax({
			type:"POST",
			url: "/api/reservations",
//			traditional : true,
			contentType: "application/json; charset=utf-8;",
			dataType: "json",
			data:JSON.stringify({
				"displayInfoId": displayInfoId,
				  "prices": arr,
				  "productId": productId,
				  "reservationEmail": email,
				  "reservationName": name,
				  "reservationTelephone": tel,
				  "reservationYearMonthDay":reservationDate 
			})
		}).done(function(res) {
			location.href=res.url; //redirect: /detail/displayInfoId
		}).fail(function(error) {
			console.log(error);
		})
	}
	
	
	

});