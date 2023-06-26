package com.quiz.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather.domain.WeatherHistory;

@Controller
@RequestMapping("/weather")
public class WeatherHistoryController {

	// 목록 화면
	@GetMapping("/weather_history_view")
	public String weatherHistoryView(
			@ModelAttribute WeatherHistory weatherHistory,
			Model model) {
		
		model.addAttribute("weatherHistory", weatherHistory);
		return "weather/weatherHistory";
	}
	
	// 추가 화면
	@GetMapping("/add_weather_view")
	public String addWeatherView() {
		return "weather/addWeather";
	}
}
