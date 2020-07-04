package com.laptrinhjavaweb.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptrinhjavaweb.Service.INhanVienService;
import com.laptrinhjavaweb.entity.NhanVien;

@Controller
@RequestMapping("dangnhap/")
public class DangnhapController {
	@Autowired
	INhanVienService inhanvienservice;

	@GetMapping
	public String getDefaul() {
		
		return "dangnhap";
	}

	// @PostMapping xử lý method post ở thẻ form
	//@RequestParam String email nó dữ liệu ở thẻ input trong page dangnhap .không cần request.getParam()

	@PostMapping
	public String xulydangky(@RequestParam String email, @RequestParam String matkhau,@RequestParam String nhaplaimatkhau, ModelMap model) {
		 boolean ktmail= validate(email);
		 if(ktmail) {
			 if(matkhau.equals(nhaplaimatkhau)) {
				 NhanVien nhanvien = new NhanVien();
				 nhanvien.setEmail(email);
				 nhanvien.setTendangnhap(email);
				 nhanvien.setMatkhau(matkhau);
				boolean ktThem= inhanvienservice.ThemNhanVien(nhanvien);
				String kt=String.valueOf(ktThem);
				model.addAttribute("ktdangnhap", kt);
				if(ktThem) {
					model.addAttribute("kiemtradangnhap", "Tạo tài khoản thành công!");
				}else {
					model.addAttribute("kiemtradangnhap", "Tạo tài khoản thất bại!");
				}
			 }else {
				 model.addAttribute("kiemtradangnhap", "Mật khẩu không trùng khớp!"); 
			 }
		 }else {
			 model.addAttribute("kiemtradangnhap", "Email không hợp lệ!");
		 }
		return "dangnhap";
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		    return matcher.find();
	}

}
