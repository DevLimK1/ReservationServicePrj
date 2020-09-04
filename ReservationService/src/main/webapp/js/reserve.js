window.addEventListener("DOMContentLoaded", function(e) {

	let ticketBody = document.querySelector(".ticket_body");

	ticketBody.onclick = ticketCountClicked;

	function ticketCountClicked(e) {
		e.preventDefault();
		let elem = e.target;
		
		if(!elem.classList.contains("ico_minus3")&&!elem.classList.contains("ico_plus3")){
			return;
		}
		
		let ticketPriceElem=e.target;
		let minusBtn;
		let plusBtn;
		let inputCountElem;
//		let inputCount; //카운트가 초기화 됨
		let ticketPrice;
		let individualPriceElem=elem.parentElement.nextElementSibling;
		let totalPriceElem=individualPriceElem.children[0];
		let totalPrice=totalPriceElem.innerText;
		
//		console.log(total_price.innerText);
	
		
		if (elem.classList.contains("ico_minus3")) { //변수명 초기화
			minusBtn = elem;
			inputCountElem = minusBtn.nextElementSibling;
			plusBtn=minusBtn.nextElementSibling.nextElementSibling;
		} else if (elem.classList.contains("ico_plus3")) {
			plusBtn = elem;
			inputCountElem = plusBtn.previousElementSibling;
			minusBtn=elem.previousElementSibling.previousElementSibling;
		}
		
//		inputCount=inputCountElem.value;
		
		while(true){ //티켓 가격 추출
			if(!ticketPriceElem.classList.contains("count_control")){
				ticketPriceElem=ticketPriceElem.parentElement;
			}else if(ticketPriceElem.classList.contains("count_control")){
				ticketPrice=ticketPriceElem.nextElementSibling.children[1].children[0].innerText;
				break;
			}
		}
		
//		console.log(parseInt(ticketPrice)+parseInt(totalPrice));
		

		if (minusBtn === elem) { // 마이너스 버튼 클릭시
			if (inputCountElem.value > 0){
				inputCountElem.value--;
				totalPrice=inputCountElem.value*ticketPrice;
				totalPriceElem.innerText=totalPrice;
			}
			
			if(inputCountElem.value==0){
				minusBtn.classList.add("disabled");
				inputCountElem.classList.add("disabled");
			}

		} else if (plusBtn === elem) { //플러스 버튼 클릭시
			inputCountElem.value++;
			totalPrice=inputCountElem.value*ticketPrice;
			totalPriceElem.innerText=totalPrice;
			if (inputCountElem.value> 0) {
				if (minusBtn.classList.contains("disabled")) {
					minusBtn.classList.remove("disabled");
					inputCountElem.classList.remove("disabled");
				}
			}
		}

		/*
		 * if (elem.classList.contains("ico_minus3")) { if
		 * (elem.nextElementSibling.value != 0){
		 * --(elem.nextElementSibling.value); elem.classList.remove("disabled");
		 * elem.nextElementSibling.classList.remove("disabled"); } else{
		 * elem.classList.add("disabled");
		 * elem.nextElementSibling.classList.add("disabled"); } } else if
		 * (elem.classList.contains("ico_plus3")) { if()
		 * elem.previousElementSibling.previousElementSibling.classList.remove("disabled");
		 * ++(elem.previousElementSibling.value); }
		 */
	}

});