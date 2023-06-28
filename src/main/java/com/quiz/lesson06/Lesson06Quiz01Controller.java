package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

	// 문제1: 즐겨찾기 추가 화면
	@GetMapping("/add_bookmark_view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 문제2: 즐겨찾기 목록 화면
	@GetMapping("/bookmark_list_view")
	public String bookmarkListView() {
		return "lesson06/bookmarkList";
	}
}
