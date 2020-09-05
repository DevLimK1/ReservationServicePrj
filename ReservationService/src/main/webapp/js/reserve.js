window.addEventListener("DOMContentLoaded", function(e) {

	const ticketBody = document.querySelector(".ticket_body");
	const totalCount=document.querySelector("#totalCount");
	let totalTicketCount=0;

	
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
		
	}

});