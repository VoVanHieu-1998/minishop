package com.laptrinhjavaweb.DAO;

import com.laptrinhjavaweb.entity.NhanVien;

public interface INhanVienDAO {

	public boolean kiemTraDangNhap(String email,String matkhau);
	public boolean ThemNhanVien(NhanVien nhanvien);
}
