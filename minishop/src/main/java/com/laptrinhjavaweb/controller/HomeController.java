package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptrinhjavaweb.Service.IDanhMucService;
import com.laptrinhjavaweb.Service.ISanPhamService;
import com.laptrinhjavaweb.entity.DanhMucSanPham;
import com.laptrinhjavaweb.entity.GioHang;
import com.laptrinhjavaweb.entity.SanPham;



@Controller
@RequestMapping("/")
@SessionAttributes("giohang")
public class HomeController {
	@Autowired
	ISanPhamService isanphamservice;
	@Autowired
	IDanhMucService idanhmucservice;
	
	//HttpSession thông qua cái này để lấy SessionAttribute.   lấy cái này model.addAttribute("chucaidau",chucaidau);
	@GetMapping
	@Transactional
	public String getHome(HttpSession httpSession,ModelMap model) {
		
		List<DanhMucSanPham> danhmucsanphams=idanhmucservice.LayDanhMuc();
		model.addAttribute("danhmucsanphams", danhmucsanphams);
		if(httpSession.getAttribute("email") != null) {
			String email1= (String)httpSession.getAttribute("email");
			String chucaidau= email1.substring(0,1).toUpperCase();
			model.addAttribute("chucaidau",chucaidau);
		}
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("giohang");
			model.addAttribute("soluongsanphamgiohang",gioHangs.size() );
		}
		List<SanPham> dssanphams= isanphamservice.layDanhSachSanPhamLimit(-1);
		model.addAttribute("dssanphams", dssanphams);
		return "home";
	}

	@PostMapping
	@Transactional
	public String themNhanVien(@RequestParam String tenNhanVien, @RequestParam int tuoi) {
		return "home";
	}

	
	
	
}
