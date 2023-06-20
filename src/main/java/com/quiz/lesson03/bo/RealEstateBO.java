package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateMapper;
import com.quiz.lesson03.domain.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input:  id
	// output: RealEstate => 컨트롤러 한테 돌려준다.
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input:  rentprice
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// input:  int, int
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price){
		return realEstateMapper.selectRealEstateListByAreaAndPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	// addRealEstateAsField("썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
	public int addRealEstateAsField(int realtorId, String address, int area, 
			String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(
				realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
