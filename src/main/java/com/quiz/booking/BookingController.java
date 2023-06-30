package com.quiz.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

	// 1. 예약목록 페이지
	@GetMapping("/booking_list_view")
	public String bookingListView() {
		return "booking/bookingList";
	}
	
	// 1-1. AJAX 요청 => 예약삭제 기능
	
	// 2. 예약하기 페이지
	@GetMapping("/add_booking_view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// 2-1. AJAX 요청 => 예약하기 기능
	
	// 3. 예약조회 페이지 (통나무 펜션 사이트)
	@GetMapping("/booking_view")
	public String bookingView() {
		return "booking/booking";
	}
	
	// 3-1. AJAX 요청 => 예약조회 기능 
	
}
