package com.laptrinhjavaweb.Service;

import com.laptrinhjavaweb.entity.NhanVien;

public interface INhanVienService {
	public boolean kiemtradangnhap(String email,String matkhau);
	public boolean ThemNhanVien(NhanVien nhanvien);

}
