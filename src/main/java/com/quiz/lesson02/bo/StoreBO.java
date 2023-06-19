package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;

@Service
public class StoreBO {
	@Autowired
	private StoreMapper storeMapper; // spring bean을 주입받는다. DI

	// input: X
	// output: storeList => 컨트롤러한테 돌려준다.
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
}
