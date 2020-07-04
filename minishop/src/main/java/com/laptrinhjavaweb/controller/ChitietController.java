package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptrinhjavaweb.Service.IDanhMucService;
import com.laptrinhjavaweb.Service.ISanPhamService;
import com.laptrinhjavaweb.entity.ChiTietSanPham;
import com.laptrinhjavaweb.entity.DanhMucSanPham;
import com.laptrinhjavaweb.entity.GioHang;
import com.laptrinhjavaweb.entity.SanPham;

@Controller
@RequestMapping("chitiet/")
@SessionAttributes("giohang")
public class ChitietController {
	@Autowired
	ISanPhamService isanphamservice;
	@Autowired
	IDanhMucService idanhmucservice;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham,ModelMap model,HttpSession httpSession) {
		SanPham sanphamtheoma= isanphamservice.layDanhSachSanhChiTietSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> danhmucsanphams=idanhmucservice.LayDanhMuc();
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("giohang");
			model.addAttribute("soluongsanphamgiohang",gioHangs.size() );
		}
		
		model.addAttribute("sanphamtheoma", sanphamtheoma);
		model.addAttribute("danhmucsanphams", danhmucsanphams);
		
		return "chitiet";
	}
}
