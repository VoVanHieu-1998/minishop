package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.entity.SanPham;

public interface ISanPhamDAO {
	List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	SanPham layDanhSachSanhChiTietSanPhamTheoMa(int masanapham);
	List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc);
	
}
