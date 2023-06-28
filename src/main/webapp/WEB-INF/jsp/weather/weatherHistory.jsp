<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/css/weather/style.css">
</head>
<body>
	<div id="wrap">
		<div class="contents d-flex">
			<%-- 메뉴 영역 --%>
			<nav class="col-2">
				<jsp:include page="menu.jsp" />
			</nav>

			<%-- 날씨 히스토리 --%>
			<section class="weather-history col-10 mt-3 ml-5">
				<h3>과거 날씨</h3>

				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${weatherHistoryList}" var="history">
						<tr>
							<td><fmt:formatDate value="{history.date}" pattern="yyyy년 M월 d일" /></td>
							<td>
								<c:choose>
									<c:when test="${history.weather eq '맑음'}">
										<img src="/image/sunny.jpg" alt="맑음">
									</c:when>
									<c:when test="${history.weather eq '흐림'}">
										<img src="/image/cloudy.jpg" alt="흐림">
									</c:when>
									<c:when test="${history.weather eq '구름조금'}">
										<img src="/image/partlycloudy.jpg" alt="구름조금">
									</c:when>
									<c:when test="${history.weather eq '비'}">
										<img src="/image/rainy.jpg" alt="비">
									</c:when>
									<c:otherwise>
										${history.weather}
									</c:otherwise>
								</c:choose>
							</td>
							<td>${history.temperatures}°C</td>
							<td>${history.precipitation}mm</td>
							<td>${history.microDust}/td>
							<td>${history.windSpeed}km/h</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</section>
		</div>
		<footer class="d-flex align-items-center">
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
</body>
</html>