package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptrinhjavaweb.Service.IChiTietHoaDonService;
import com.laptrinhjavaweb.Service.IHoaDonService;
import com.laptrinhjavaweb.entity.ChiTietHoaDon;
import com.laptrinhjavaweb.entity.ChiTietHoaDonId;
import com.laptrinhjavaweb.entity.GioHang;
import com.laptrinhjavaweb.entity.HoaDon;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang")
public class GioHangController {
	@Autowired
	IHoaDonService ihoadonservice;
	
	@Autowired
	IChiTietHoaDonService iChiTietHoaDonService;

	@GetMapping
	public String Default(HttpSession httpSession, ModelMap model) {

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			model.addAttribute("soluongsanphamgiohang", gioHangs.size());
			model.addAttribute("listgiohang", gioHangs);
		}
		return "giohang";
	}

	@PostMapping
	public String ThemHoaDon(HttpSession httpSession, @RequestParam String tenkhachhang, @RequestParam String sodt,
			@RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu) {

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenkhachhang);
			hoaDon.setSodt(sodt);
			hoaDon.setDiachigiaohang(diachigiaohang);
			hoaDon.setHinhthucgiaohang(hinhthucgiaohang);
			hoaDon.setGhichu(ghichu);
			
			//@EmbeddedId vif sử dụng cái này nên phải thêm hóa đơn trước rồi mới thêm chitiethoadon sau vì nếu làm save(hoadon) chung
			//thì nó ko contrains đc Mahoadon trong chitiethoadonid 
			//cho nên save(hoadon) trả về id
			//con save(Chitiethoadonid) trả về ChitiethoadonId
			int idhoadon =ihoadonservice.ThemHoaDon(hoaDon);
			if (idhoadon > 0) {
				Set<ChiTietHoaDon> listchitietHoaDons = new HashSet<ChiTietHoaDon>();
				for (GioHang gioHang : gioHangs) {

					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitiet());
					chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiatien().toString());
					chiTietHoaDon.setSoluong(gioHang.getSoluong());
					
					iChiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
					
				}
			} else {

			}

			

		}

		return "giohang";
	}
}
