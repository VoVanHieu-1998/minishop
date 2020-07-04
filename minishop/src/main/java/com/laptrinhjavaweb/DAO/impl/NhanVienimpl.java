package com.laptrinhjavaweb.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DAO.INhanVienDAO;
import com.laptrinhjavaweb.entity.NhanVien;
@Repository
public class NhanVienimpl implements INhanVienDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean kiemTraDangNhap(String email, String matkhau) {
		Session session =sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien =(NhanVien) session.createQuery("from NHANVIEN where email='"+email+"'AND matkhau='"+matkhau+"'").getSingleResult();
			if(nhanVien!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
		
	}

	@Override
	@Transactional
	public boolean ThemNhanVien(NhanVien nhanvien) {
		Session session =sessionFactory.getCurrentSession();
		int manhanvien= (int)session.save(nhanvien);
		if(manhanvien > 0) {
			return true;
		}else {
			return false;
		}
		
	}


}
