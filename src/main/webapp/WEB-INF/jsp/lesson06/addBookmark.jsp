<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">URL 주소</label>
			<div class="d-flex justify-content-between">
				<input type="text" id="url" class="form-control col-11">
				<button type="button" id="urlCheckBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="urlStatusArea"></small>
		</div>
		<button type="button" id="addBookmarkBtn" class="btn btn-success btn-block">추가</button>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#addBookmarkBtn').on('click', function() {
				let name = $("#name").val().trim();
				let url = $('#url').val().trim();
				
				// validationsadasd
				if (name == "") {
					alert("제목을 입력하세요.");
					return;
				}
				
				if (!url) {
					alert("주소를 입력하세요.");
					return;
				}
				
				// 주소 형식이 잘못되었을 때 참: http && https 가 아닐 때
				if (!url.startsWith('http://') && url.startsWith("https://") == false) {
					alert("주소 형식이 잘못 되었습니다.");
					return;
				}
				
				// AJAX 통신 => 서버 요청
				$.ajax({
					// request
					type: "post"
					, url: "/lesson06/quiz01/add_bookmark"
					, data: {"name":name, "url":url}
					
					// response
					, success: function(data) { // String, JSON => 자바스크립트의 객체로 변환
						/* alert(data.code);
						alert(data.result); */
						if (data.result == "성공") {
							location.href = "/lesson06/quiz01/bookmark_list_view"; // GET method
						}
					}
					, error: function(request, status, error) {
						alert("즐겨찾기를 추가하는데 실패했습니다.");
					}
				});
			});
			
			$("#urlCheckBtn").on('click', function() {
				$('#urlStatusArea').empty();
				let url = $('#url').val().trim();
				
				// url 중복확인 AJAX 통신 (DB 확인)
				$.ajax({
					// request
					type: "get" // get 일 때는 생략 가능 (ajax의 기본요청이기 때문)
					, url: "/lesson06/quiz01/is_duplication"
					, data: {"url":url}
					
					// response
					, success: function(data) {
						// alert(data);
						if (data.isDuplication) { // 중복
							$("#urlStatusArea").append('<span class="text-danger">중복된 url 입니다.</span>');
						} else {
							$("#urlStatusArea").append('<span class="text-danger">저장 가능한 url 입니다.</span>');
						}
					}
					, error: function(request, status, error) {
						alert("중복 확인에 실패했습니다.");
					}
				});
			});
		});
	</script>
</body>
</html>