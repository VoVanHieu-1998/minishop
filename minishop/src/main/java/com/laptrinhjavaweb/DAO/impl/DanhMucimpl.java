package com.laptrinhjavaweb.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DAO.IDanhMucDAO;
import com.laptrinhjavaweb.entity.DanhMucSanPham;
@Repository
public class DanhMucimpl implements IDanhMucDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		Session session =sessionFactory.getCurrentSession();
		String query="from DANHMUCSANPHAM ";
		List<DanhMucSanPham> danhmucsanphams=  session.createQuery(query).getResultList();
		return danhmucsanphams;
	}

}
