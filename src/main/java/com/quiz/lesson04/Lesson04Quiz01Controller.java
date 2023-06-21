package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost:8080/lesson04/quiz01/add_seller_view
	@GetMapping("/add_seller_view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 추가 action
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 입력 성공 페이지
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 정보 페이지
	// http://localhost:8080/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String sellerInfo(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		Seller seller = null;
		
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			// id가 있는 경우
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("seller", seller);
		
		// 결과 페이지
		return "lesson04/sellerInfo";
	}
}
