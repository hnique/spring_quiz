package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {

	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>() {
			{
				put("rate", 15);
				put("director", "봉준호");
				put("time", 131);
				put("title", "기생충");
			}
		};
		list.add(map);
		
		map = new HashMap<String, Object>() {
			{
				put("rate", 0);
				put("director", "로베르토 베니니");
				put("time", 116);
				put("title", "인생은 아름다워");
			}
		};
		list.add(map);
		
		map = new HashMap<String, Object>() {
			{
				put("rate", 12);
				put("director", "크리스토퍼 놀란");
				put("time", 147);
				put("title", "인셉션");
			}
		};
		list.add(map);
		
		map = new HashMap<String, Object>() {
			{
				put("rate", 19);
				put("director", "윤종빈");
				put("time", 133);
				put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
			}
		};
		list.add(map);
		
		map = new HashMap<String, Object>() {
			{
				put("rate", 15);
				put("director", "프란시스 로렌스");
				put("time", 137);
				put("title", "헝거게임");
			}
		};
		list.add(map);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Forum> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter => HTML
		// @ResponseBody + return 객체 => HttpMessageConverter => jackson라이브러리 => JSON String
		
		List<Forum> list = new ArrayList<>();
		// 생성자로 리스트에 추가
		list.add(new Forum("안녕하세요 가입인사 드립니다.", "hagulu", 
				"안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다."));
		list.add(new Forum("헐 대박", "bada", 
				"오늘 목요일이었어.. 금요일인줄"));
		list.add(new Forum("오늘 데이트 한 이야기 해드릴게요.", "dulumary", 
				"..."));
		
		// 메소드로 리스트에 추가
//		Forum forum = new Forum();
//		forum.setTitle("안녕하세요 가입인사 드립니다.");
//		forum.setUser("hagulu");
//		forum.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
//		list.add(forum);
//		
//		forum = new Forum();
//		forum.setTitle("헐 대박");
//		forum.setUser("bada");
//		forum.setContent("오늘 목요일이었어.. 금요일인줄");
//		list.add(forum);
//		
//		forum = new Forum();
//		forum.setTitle("오늘 데이트 한 이야기 해드릴게요.");
//		forum.setUser("dulumary");
//		forum.setContent("...");
//		list.add(forum);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Forum> quiz02_3() {
		Forum forum = new Forum();
		forum.setTitle("안녕하세요 가입인사 드립니다.");
		forum.setUser("hagulu");
		forum.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(forum, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
