package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	// 문제1: 즐겨찾기 추가 화면
	@GetMapping("/add_bookmark_view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 문제1: AJAX의 요청
	@ResponseBody
	@PostMapping("/add_bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB insert
		bookmarkBO.addBookmark(name, url);
		
		// 응답: {"code":1, "result":"성공"} JSON String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
	// AJAX가 하는 요청 => URL 중복확인
	@ResponseBody
	@PostMapping("/is_duplication_url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("isDuplication", false);
		
		// DB select by url
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url); // bookmark or NULL
		
		if (bookmark != null) { // 중복
			result.put("isDuplication", true);
		}
		
		return result;
	}
	
	// 문제2: 즐겨찾기 목록 화면
	@GetMapping("/bookmark_list_view")
	public String bookmarkListView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/bookmarkList";
	}
	
	// AJAX 요청 => 즐겨찾기 삭제
	@ResponseBody
	@DeleteMapping("/delete_bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("bookmarkId") int id) {
		
		// DB delete
		int row = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row == 1) {
			// 성공
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			// 삭제된 행 없음 -> 실패
			result.put("code", 500);
			result.put("errorMessage", "삭제될 데이터가 없습니다.");
		}
		
		return result;
	}
}
