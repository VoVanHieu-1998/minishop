package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhjavaweb.Service.IDanhMucService;
import com.laptrinhjavaweb.Service.ISanPhamService;
import com.laptrinhjavaweb.entity.DanhMucSanPham;
import com.laptrinhjavaweb.entity.SanPham;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	
	@Autowired
	IDanhMucService idanhmucservice;
	@Autowired
	ISanPhamService isanphamService;
	
	@GetMapping("/{id}/{tendanhmuc}")
	public String Default(ModelMap model,@PathVariable int id,@PathVariable String tendanhmuc) {
		List<SanPham> listSanPhams =isanphamService.layDanhSachSanPhamTheoMaDanhMuc(id);
		model.addAttribute("listsanphamtheomadanhmuc", listSanPhams);
		List<DanhMucSanPham> danhmucsanphams=idanhmucservice.LayDanhMuc();
		model.addAttribute("danhmucsanphams", danhmucsanphams);
		model.addAttribute("tendanhmuc", tendanhmuc);
		return "sanpham";
	}

}
