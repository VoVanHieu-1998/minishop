package com.laptrinhjavaweb.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DAO.IChiTietHoaDon;
import com.laptrinhjavaweb.entity.ChiTietHoaDon;
import com.laptrinhjavaweb.entity.ChiTietHoaDonId;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonimpl implements IChiTietHoaDon {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietHoaDonId id = (ChiTietHoaDonId)  session.save(chiTietHoaDon);
		if(id != null) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
