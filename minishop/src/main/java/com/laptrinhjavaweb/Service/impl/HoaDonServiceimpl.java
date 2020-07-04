package com.laptrinhjavaweb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IHoaDon;
import com.laptrinhjavaweb.Service.IHoaDonService;
import com.laptrinhjavaweb.entity.HoaDon;
@Service
public class HoaDonServiceimpl implements IHoaDonService{
	@Autowired
	IHoaDon ihoadon;
	
	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
		
		return ihoadon.ThemHoaDon(hoaDon);
	}


}
