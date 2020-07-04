package com.laptrinhjavaweb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.INhanVienDAO;
import com.laptrinhjavaweb.Service.INhanVienService;
import com.laptrinhjavaweb.entity.NhanVien;

@Service
public class NhanVienServiceimpl implements INhanVienService {
	@Autowired
	INhanVienDAO inhanvienDAO;
	
	@Override
	public boolean kiemtradangnhap(String email, String matkhau) {
		boolean kiemtra= inhanvienDAO.kiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	@Override
	public boolean ThemNhanVien(NhanVien nhanvien) {
		boolean ktThem= inhanvienDAO.ThemNhanVien(nhanvien);
		return ktThem;
	}

	

}
