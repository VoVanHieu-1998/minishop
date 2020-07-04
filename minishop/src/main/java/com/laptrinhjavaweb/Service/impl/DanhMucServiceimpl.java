package com.laptrinhjavaweb.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IDanhMucDAO;
import com.laptrinhjavaweb.Service.IDanhMucService;
import com.laptrinhjavaweb.entity.DanhMucSanPham;
@Service
public class DanhMucServiceimpl implements IDanhMucService {
	
	@Autowired
	IDanhMucDAO danhmucDAO;
	@Override
	public List<DanhMucSanPham> LayDanhMuc() {
		
		return danhmucDAO.LayDanhMuc();
	}

}
