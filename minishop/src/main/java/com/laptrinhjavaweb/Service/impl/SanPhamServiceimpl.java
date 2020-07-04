package com.laptrinhjavaweb.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.ISanPhamDAO;
import com.laptrinhjavaweb.Service.ISanPhamService;
import com.laptrinhjavaweb.entity.SanPham;
@Service
public class SanPhamServiceimpl implements ISanPhamService {
	@Autowired
	ISanPhamDAO isanpham;

	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		
		return isanpham.layDanhSachSanPhamLimit(spbatdau);
	}

	@Override
	public SanPham layDanhSachSanhChiTietSanPhamTheoMa(int masanapham) {
		// TODO Auto-generated method stub
		return isanpham.layDanhSachSanhChiTietSanPhamTheoMa(masanapham);
	}

	@Override
	public List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		
		return isanpham.layDanhSachSanPhamTheoMaDanhMuc(madanhmuc);
	}

}
