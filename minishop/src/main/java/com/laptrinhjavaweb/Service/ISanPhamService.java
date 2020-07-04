package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.entity.SanPham;

public interface ISanPhamService {
	List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	SanPham layDanhSachSanhChiTietSanPhamTheoMa(int masanapham);
	List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc);
}
