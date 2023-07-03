<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
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
		<section class="contents">
			<h2 class="text-center font-weight-bold m-4">예약 목록 보기</h2>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bookingList}" var="booking">
					<tr>
						<td>${booking.name}</td>
						<td>
							<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일" />
						</td>
						<td>${booking.day}</td>
						<td>${booking.headcount}</td>
						<td>${booking.phoneNumber}</td>
						<td>${booking.state}</td>
						<td><button type="button" class="del-btn btn btn-danger" data-booking-id="${booking.id}">삭제</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
<script>
	$(document).ready(function() {
		// 삭제버튼 클릭
		$(".del-btn").on('click', function() {
			let deleteBookingId = $(this).data("booking-id");
			
			$.ajax({
				// request
				type: "delete"
				, url: "/booking/delete_booking"
				, data: {"id":deleteBookingId}
				
				// response
				, success: function(data) {
					if (data.code == 1) {
						alert("삭제 되었습니다.");
						location.reload(true);
					} else {
						alert(data.errorMessage);
					}
				}
				, error: function(request, status, error) {
					alert("삭제하는데 실패했습니다.");
				}
			});
		});
	});
</script>
</body>
</html>