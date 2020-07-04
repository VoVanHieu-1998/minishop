package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhjavaweb.Service.impl.SanPhamServiceimpl;
import com.laptrinhjavaweb.entity.SanPham;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	@Autowired
	SanPhamServiceimpl sanPhamServiceimpl;
	@GetMapping
	public String Default(ModelMap model) {
		List<SanPham>listSanPhams= sanPhamServiceimpl.layDanhSachSanPhamLimit(0);
		List<SanPham>allSanPham= sanPhamServiceimpl.layDanhSachSanPhamLimit(-1);
		double tongsopage=Math.ceil((double)allSanPham.size()/5);
		model.addAttribute("listsanpham", listSanPhams);
		model.addAttribute("allsanpham", allSanPham);
		model.addAttribute("tongsopage", tongsopage);
		return "themsanpham";
	}
}
