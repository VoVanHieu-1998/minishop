package com.laptrinhjavaweb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IChiTietHoaDon;
import com.laptrinhjavaweb.Service.IChiTietHoaDonService;
import com.laptrinhjavaweb.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonServiceimpl implements IChiTietHoaDonService{
	@Autowired
	IChiTietHoaDon iChiTietHoaDon;
	
	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		return iChiTietHoaDon.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
