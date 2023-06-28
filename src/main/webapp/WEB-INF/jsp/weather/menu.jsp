<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 상단 로고 --%>
<div class="logo d-flex justify-content-center mt-3">
	<img
		src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png"
		width="25"> <span class="text-white font-weight-bold ml-2">기상청</span>
</div>

<%-- flex-column: 세로 메뉴 --%>
<ul class="nav flex-column mt-4">
	<li class="nav-item"><a href="/weather/weather_history_view"
		class="nav-link menu-font">날씨</a></li>
	<li class="nav-item"><a href="/weather/add_weather_view"
		class="nav-link menu-font">날씨입력</a></li>
	<li class="nav-item"><a href="#" class="nav-link menu-font">테마날씨</a></li>
	<li class="nav-item"><a href="#" class="nav-link menu-font">관측 기후</a></li>
</ul>