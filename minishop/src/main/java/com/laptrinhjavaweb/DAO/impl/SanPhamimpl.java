package com.laptrinhjavaweb.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DAO.ISanPhamDAO;
import com.laptrinhjavaweb.entity.SanPham;
@Repository
public class SanPhamimpl implements ISanPhamDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		Session session =sessionFactory.getCurrentSession();
		List<SanPham> sanPham = new ArrayList<>();
		if(spbatdau < 0) {
			 sanPham= (List<SanPham>) session.createQuery("from SANPHAM " ).getResultList();

		}else {
			sanPham= (List<SanPham>) session.createQuery("from SANPHAM" ).setFirstResult(spbatdau).setMaxResults(5).getResultList();
		
		}
		return sanPham;
		
	}

	@Override
	@Transactional
	public SanPham layDanhSachSanhChiTietSanPhamTheoMa(int masanapham) {
		//hibernate thông qua relationship các quan hệ để nó inner john bảng lại với nhau .Mình không cần viết câu sql john bảng.
		//các quan hệ như là. @onetomany,@manytomany...
		Session session =sessionFactory.getCurrentSession();
		SanPham sanPham= (SanPham) session.createQuery("from SANPHAM sp where sp.masanpham="+masanapham ).getSingleResult();
		
		return sanPham;
	}

	@Override
	@Transactional
	public List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session =sessionFactory.getCurrentSession();
		List<SanPham> sanPham= (List<SanPham>) session.createQuery("from SANPHAM sp where sp.danhmucsanpham.madanhmuc="+madanhmuc ).getResultList();
		return sanPham;
	}

}
