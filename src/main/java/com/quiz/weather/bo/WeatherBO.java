package com.quiz.weather.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather.dao.WeatherMapper;
import com.quiz.weather.domain.WeatherHistory;

@Service
public class WeatherBO {

	@Autowired
	private WeatherMapper weatherMapper;
	
	public List<WeatherHistory> getWeatherHistoryList(){
		return weatherMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(Date date, String weather, String microDust,
			double temperatures, double precipitation, double windSpeed) {
		
		weatherMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
