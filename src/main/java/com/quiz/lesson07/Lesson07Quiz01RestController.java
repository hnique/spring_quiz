package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save1() {
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		CompanyEntity company = companyBO.addCompany(name, business, scale, headcount);
		return company;
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		// id:8, 중소기업, 34명
		return companyBO.updateCompanyById(8, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete() {
		// id: 8
		companyBO.deleteCompanyById(8);
		return "삭제완료";
	}
}
