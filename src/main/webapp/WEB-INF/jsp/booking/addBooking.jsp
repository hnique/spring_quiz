<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<!-- bootstrap, jquery -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<!-- datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav>
			<jsp:include page="menu.jsp" />
		</nav>
		<section class="contents">
			<h2 class="text-center font-weight-bold m-4">예약 하기</h2>
			<div class="d-flex justify-content-center">
				<div class="reservation-box">
					<div class="subject-text my-2 font-weight-bold">이름</div>
					<input type="text" class="form-control" name="name">
					
					<div class="subject-text my-2 font-weight-bold">예약날짜</div>
					<input type="text" class="form-control" name="date">
					
					<div class="subject-text my-2 font-weight-bold">숙박일수</div>
					<input type="text" class="form-control" name="day">
					
					<div class="subject-text my-2 font-weight-bold">숙박인원</div>
					<input type="text" class="form-control" name="headcount">
					
					<div class="subject-text my-2 font-weight-bold">전화번호</div>
					<input type="text" class="form-control" name="phoneNumber">
					
					<button type="button" id="reservationBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
		</section>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
<script>
	$(document).ready(function() {
		// 날짜 선택 데이트 피커
		$('input[name=date]').datepicker({
			dateFormat:"yy-mm-dd"
			, minDate:0
		});
		
		// 예약버튼 클릭
		$("#reservationBtn").on('click', function() {
			let name = $('input[name=name]').val().trim();
			let date = $('input[name=date]').val().trim();
			let day = $('input[name=day]').val().trim();
			let headcount = $('input[name=headcount]').val().trim();
			let phoneNumber = $('input[name=phoneNumber]').val().trim();
			
			// validation
			if (name == "") {
				alert("이름을 입력하세요.");
				return;
			}
			
			if (date.length < 1) {
				alert("날짜를 선택하세요.");
				return;
			}
			
			if (!day) {
				alert("숙박일을 입력하세요.");
				return;
			}
			
			if (isNaN(day)) { // 숫자가 아닐 때 참
				alert("숙박일수는 숫자만 입력 가능합니다.");
				return;
			}
			
			if (headcount == "") {
				alert("숙박인원을 입력하세요.");
				return;
			}
			
			if (isNaN(headcount)) {
				alert("숙박인원은 숫자만 입력 가능합니다.");
				return;
			}
			
			if (!phoneNumber) {
				alert("전화번호를 입력하세요.");
				return;
			}
			
			// AJAX 요청 => insert
			$.ajax({
				// request
				type: "post"
				, url: "/booking/add_booking"
				, data: {"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				
				// response
				, success: function(data) {
					if (data.code == 1) {
						alert("예약 되었습니다.");
						location.href="/booking/booking_list_view";
					} else {
						alert(data.errorMessage);
					}
				}
				, error: function(request, status, error) {
					alert("예약하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	});
</script>
</body>
</html>