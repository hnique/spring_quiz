package com.quiz.booking;

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

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;

	// 1. 예약목록 페이지
	@GetMapping("/booking_list_view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// 1-1. AJAX 요청 => 예약삭제 기능
	@ResponseBody
	@DeleteMapping("/delete_booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// DB delete
		int row = bookingBO.deleteBookingById(id);
				
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			// 성공
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			// 삭제할 데이터 없음
			result.put("code", 500);
			result.put("errorMessage", "삭제될 데이터가 없습니다.");
		}
		
		return result;
	}
	
	// 2. 예약하기 페이지
	@GetMapping("/add_booking_view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// 2-1. AJAX 요청 => 예약하기 기능
	@ResponseBody
	@PostMapping("/add_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date, // @DateTimeFormat을 붙이고 Date 객체로 받아와도 된다.
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		int row = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "예약 데이터가 추가되지 못했습니다.");
		}
		
		return result;
	}
	
	// 3. 예약조회 페이지 (통나무 펜션 사이트)
	@GetMapping("/booking_view")
	public String bookingView() {
		return "booking/booking";
	}
	
	// 3-1. AJAX 요청 => 예약조회 기능 
	@ResponseBody
	@PostMapping("/search_booking")
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB select
		Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (booking == null) {
			result.put("code", 300);
			result.put("errorMessage", "예약 내역이 없습니다.");
		} else {
			result.put("code", 1);
			result.put("booking", booking);
		}
		
		return result;
	}
	
}
