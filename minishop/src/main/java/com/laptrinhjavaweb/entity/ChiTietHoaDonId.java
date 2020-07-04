package com.laptrinhjavaweb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
//neeus nhuw class này chứa 2 id khóa chính vầ còn chứa thêm các trường khác thì tạo ra 1 lớp mới chưa 2 id và @Embeddable
@Embeddable
public class ChiTietHoaDonId implements Serializable {
	int mahoadon;
	int machitietsanpham;
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public int getMachitietsanpham() {
		return machitietsanpham;
	}
	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}
	
}
