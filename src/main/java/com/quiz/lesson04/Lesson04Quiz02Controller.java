package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	@Autowired
	private RealtorBO realtorBO;

	// 추가 페이지
	@GetMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 결과 페이지
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, // @ModelAttribute 어노테이션은 객체가 하나면 생략가능
			Model model) {
		
		// DB insert
		realtorBO.addRealtor(realtor);
		
		// DB select
		Realtor newRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// model에 담기
		model.addAttribute("realtor", newRealtor);
		
		// 결과 페이지로 이동
		return "lesson04/afterAddRealtor";
	}
}
