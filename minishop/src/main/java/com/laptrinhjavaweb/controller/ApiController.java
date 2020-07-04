package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.filter.HttpPutFormContentFilter;

import com.laptrinhjavaweb.Service.INhanVienService;
import com.laptrinhjavaweb.Service.ISanPhamService;
import com.laptrinhjavaweb.entity.GioHang;
import com.laptrinhjavaweb.entity.SanPham;

/*<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>*/
@Controller
@SessionAttributes({ "email", "giohang" })
@RequestMapping("api/")
public class ApiController {
	@Autowired
	INhanVienService inhanvienService;
	@Autowired
	ISanPhamService iSanPhamService;
	
	@GetMapping("kiemtradangnhap")
	@Transactional
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		//
		boolean kiemtra = inhanvienService.kiemtradangnhap(email, matkhau);
		modelMap.addAttribute("email", email);

		return "" + kiemtra;
	}
	@GetMapping("capnhapgiohang")
	@ResponseBody
	public void capnhatgiohang(HttpSession httpSession,@RequestParam int soluong,@RequestParam int masp,@RequestParam int mamau,@RequestParam int masize) {
		if (null != httpSession.getAttribute("giohang") ) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamTonTaiGioHang(masp, masize, mamau, httpSession, listGioHangs);
			listGioHangs.get(vitri).setSoluong(soluong);
		}
	}
	
	
	@GetMapping("xoagiohang")
	@ResponseBody
	public void xoagiohang(HttpSession httpSession,@RequestParam int masp,@RequestParam int mamau,@RequestParam int masize) {
		if (null != httpSession.getAttribute("giohang") ) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamTonTaiGioHang(masp, masize, mamau, httpSession, listGioHangs);
			listGioHangs.remove(vitri);
		}
	}
	
	
	@GetMapping("themgiohang")
	@ResponseBody
	public void themgiohang(@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau,
			@RequestParam String tensp, @RequestParam String giatien, @RequestParam String tenmau,
			@RequestParam String tensize, @RequestParam int soluong,@RequestParam int machitiet, HttpSession httpSession) {
		if (null == httpSession.getAttribute("giohang") ) {

			List<GioHang> gioHangs = new ArrayList<GioHang>();
			GioHang gioHang = new GioHang();
			gioHang.setMasp(masp);
			gioHang.setMasize(masize);
			gioHang.setMamau(mamau);
			gioHang.setTensp(tensp);
			gioHang.setGiatien(giatien);
			gioHang.setTenmau(tenmau);
			gioHang.setTensize(tensize);
			gioHang.setSoluong(1);
			gioHang.setMachitiet(machitiet);

			gioHangs.add(gioHang);
			httpSession.setAttribute("giohang", gioHangs);
			
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			System.out.println(listGioHangs.size());
		} else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri= KiemTraSanPhamTonTaiGioHang(masp, masize, mamau, httpSession,listGioHangs);
			if(vitri==-1) {
				
				GioHang gioHang = new GioHang();
				gioHang.setMasp(masp);
				gioHang.setMasize(masize);
				gioHang.setMamau(mamau);
				gioHang.setTensp(tensp);
				gioHang.setGiatien(giatien);
				gioHang.setTenmau(tenmau);
				gioHang.setTensize(tensize);
				gioHang.setSoluong(1);
				gioHang.setMachitiet(machitiet);
				listGioHangs.add(gioHang);
			}else {
			
				int soluongmoi= listGioHangs.get(vitri).getSoluong() +1;
				listGioHangs.get(vitri).setSoluong(soluongmoi);
			}
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		for (GioHang gioHang : listGioHangs) {
			System.out.println(gioHang.getMasp() +"+" +gioHang.getTensp() +"-" +gioHang.getTenmau() +"-"+ gioHang.getTensize() +"-"+gioHang.getSoluong());
		}

	}
	
	
	
	/*
	 * @GetMapping("themgiohang")
	 * 
	 * @ResponseBody public String themgiohang(@RequestParam int masp, @RequestParam
	 * int masize, @RequestParam int mamau,
	 * 
	 * @RequestParam String tensp, @RequestParam String giatien, @RequestParam
	 * String tenmau,
	 * 
	 * @RequestParam String tensize, @RequestParam int soluong, HttpSession
	 * httpSession) { if (null == httpSession.getAttribute("giohang") ) {
	 * 
	 * List<GioHang> gioHangs = new ArrayList<GioHang>(); GioHang gioHang = new
	 * GioHang(); gioHang.setMasp(masp); gioHang.setMasize(masize);
	 * gioHang.setMamau(mamau); gioHang.setTensp(tensp);
	 * gioHang.setGiatien(giatien); gioHang.setTenmau(tenmau);
	 * gioHang.setTensize(tensize); gioHang.setSoluong(1);
	 * 
	 * gioHangs.add(gioHang); httpSession.setAttribute("giohang", gioHangs);
	 * 
	 * List<GioHang> listGioHangs = (List<GioHang>)
	 * httpSession.getAttribute("giohang"); return gioHangs.size ;
	 * } else { List<GioHang> listGioHangs = (List<GioHang>)
	 * httpSession.getAttribute("giohang"); int vitri=
	 * KiemTraSanPhamTonTaiGioHang(masp, masize, mamau, httpSession,listGioHangs);
	 * if(vitri==-1) {
	 * 
	 * GioHang gioHang = new GioHang(); gioHang.setMasp(masp);
	 * gioHang.setMasize(masize); gioHang.setMamau(mamau); gioHang.setTensp(tensp);
	 * gioHang.setGiatien(giatien); gioHang.setTenmau(tenmau);
	 * gioHang.setTensize(tensize); gioHang.setSoluong(1);
	 * listGioHangs.add(gioHang); }else {
	 * 
	 * int soluongmoi= listGioHangs.get(vitri).getSoluong() +1;
	 * listGioHangs.get(vitri).setSoluong(soluongmoi); } } List<GioHang>
	 * listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang"); 
	 * return listGioHangs.size+""
	 * }
	 */


	private int KiemTraSanPhamTonTaiGioHang(int masp, int masize, int mamau, HttpSession httpSession,List<GioHang> listGioHangs) {
		
		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMasp() == masp && listGioHangs.get(i).getMasize() == masize
					&& listGioHangs.get(i).getMamau() == mamau) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	@GetMapping(path ="laysoluonggiohang",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String laysoluonggiohang(HttpSession httpSession,ModelMap model) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("giohang");
			return gioHangs.size()+"";
		}
		return "";
	}
	@GetMapping("laysanphamlimit")
	@Transactional
	@ResponseBody
	public String laysanphamlimit(@RequestParam int spbatdau) {
		String html="";
		List<SanPham> listsanphams= iSanPhamService.layDanhSachSanPhamLimit(spbatdau);
		for (SanPham sanPham : listsanphams) {
			html+="<tr>";
			html+="<td> <div class='checkbox'> <label><input type='checkbox' class='checkboxsanpham' value=''></label></div> </td>";
			html+="<td class='ten' data-masp='"+sanPham.getMasanpham()+"'>"+sanPham.getTensanpham()+"</td>";
			html+="<td class='giatien' >"+sanPham.getGiatien()+"</td>";
			html+="<td class='danhcho' >"+sanPham.getDanhcho()+"</td>";
			html+="</tr>";
		}
		return html;
	}
	
}
