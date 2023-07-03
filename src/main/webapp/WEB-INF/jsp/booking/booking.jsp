<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

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
		<section class="banner bg-info">
			<img id="bannerImage" src="/image/test06_banner1.jpg" alt="banner" width="1110" height="500">
		</section>
		<section class="reserve bg-primary d-flex">
			<section class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
				<div class="display-4 text-white">
					실시간<br>예약하기
				</div>
			</section>
			<section class="confirm col-4">
				<div class="m-3">
					<span class="reserve-confirm mr-3">예약 확인</span>
				</div>
				
				<!-- 예약 확인 -->
				<div id="memberInputBox" class="m-2">
					<div class="d-flex justify-content-end mr-3">
						<span class="text-white">이름: </span>
						<input type="text" id="name" class="form-control input-form">
					</div>
					<div class="d-flex mt-2 justify-content-end mr-3">
						<span class="text-white">전화번호: </span>
						<input type="text" id="phoneNumber" class="form-control input-form">
					</div>
					
					<!-- 버튼 -->					
					<div class="text-right mt-3 mr-3">
						<button type="button" id="searchBtn" class="btn btn-success submit-btn">조회하기</button>
					</div>
				</div>
			</section>
			<section class="inquiry col-4 d-flex justify-content-center align-items-center">
				<div class="text-white">
					<h4 class="font-weight-bold">예약문의: </h4>
					<h1>010-<br>0000-1111</h1>
				</div>
			</section>
		</section>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
<script>
	$(document).ready(function() {
		$('#searchBtn').on('click', function() {
			let name = $('#name').val().trim();
			let phoneNumber = $('#phoneNumber').val().trim();
			
			// validation
			if (name == "") {
				alert("이름을 입력하세요.");
				return;
			}
			
			if (!phoneNumber) {
				alert("전화번호를 입력하세요.");
				return;
			}
			
			$.ajax({
				// request
				type: "post"
				, url: "/booking/search_booking"
				, data: {"name":name, "phoneNumber":phoneNumber}
				
				// response
				, success: function(data) {
					if (data.code == 1) {
						alert("이름: " + data.booking.name
								+ "\n날짜: " + data.booking.date.slice(0, 10)
								+ "\n일수: " + data.booking.day
								+ "\n인원: " + data.booking.headcount
								+ "\n상태: " + data.booking.state);
					} else {
						alert(data.errorMessage);
					}
				}
				, error: function(request, status, error) {
					alert("조회에 실패했습니다.");
				}
			});
		});
	});
</script>
</body>
</html>