<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet"
	href="<c:url value='/resources/js/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/animate.min.css' />" />
<link rel="stylesheet" href="<c:url value='/resources/css/home.css' />" />
</head>
<body>
	<div id="header" class="container-fluid ">
		<nav class="navbar navbar-expand-lg navbar-light bg-light none-nav">
			<a class="navbar-brand" href="#"><img
				src="<c:url value='/resources/img/foody-vn.png' />" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto navbar-center">
					<li class="nav-item active"><a class="nav-link" href="#">Trang
							chủ</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Sản phẩm </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<c:forEach var="list" items="${danhmucsanphams }">
									<a class="dropdown-item" href='<c:url value="/sanpham/${list.getMadanhmuc() }/${list.getTendanhmuc() }" />'>${list.getTendanhmuc() }</a>
									<div class="dropdown-divider"></div>
								</c:forEach>
											
						
							
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">Dịch vụ</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Liên hệ</a>
					</li>
				</ul>
			
				<ul class="nav navbar-nav navbar-right navbar-right-login">
				<c:choose>
					<c:when test="${chucaidau != null}">
						<li><a href="dangnhap"><span style="width: 32px; height: 32px; border-radius: 16px; background-color: chocolate; 
						text-align: center; padding: 6px; margin-top: 10px; 
						margin-bottom: 15px;" class="circle-avatar">${chucaidau }</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a style="text-decoration: none;" href="dangnhap/">Đăng nhập</a></li>
					</c:otherwise>
				</c:choose>
					
				</ul>
				
				<span class="navbar-text"> <a href="<c:url value='/giohang/' />"><img
						src="<c:url value='/resources/img/Cart2x.png' />" /></a>
						<span style="color: white ;font-size: 11px;">${soluongsanphamgiohang}</span>
				</span>

			</div>
		</nav>
		<div class="event-header container wow shake ">
			<span>Ngày 17/02 - 19/02/2020</span><br />
			<div id="ngayevent">
				<span style="font-size: 50px">Mua 1 tặng 1</span>
			</div>
			<br />
			<div id="xemngay">
				<button>XEM NGAY</button>
			</div>
		</div>

	</div>

	<div id="info" class="container">
		<div class="row" style="margin-top: 42px">
			<div class="col-12 col-sm-4 col-md-4 wow fadeInLeft"
				data-wow-duration="1s">
				<img class="icon" alt=""
					src="<c:url value='/resources/img/chatluong48.png' />" /><br /> <span
					style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br />
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng
					sản phẩm tốt nhất</span>
			</div>
			<!-- Giao hàng -->
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown"
				data-wow-duration="1s" data-wow-delay="1s">
				<img class="icon" alt=""
					src="<c:url value='/resources/img/giaohang48.png' />" /><br /> <span
					style="font-size: 32px; font-weight: 500;">GIAO HÀNG</span><br />
				<span>Cam kết giao hàng tận nơi trong ngày.Để mang sản phẩm
					đến nhanh nhất cho khách hàng</span>
			</div>
			<!-- Giao hàng -->
			<div class="col-12 col-sm-4 col-md-4  wow fadeInUp "
				data-wow-duration="1s" data-wow-delay="2s">
				<img class="icon" alt=""
					src="<c:url value='/resources/img/tietkiem48.png' />" /><br /> <span
					style="font-size: 32px; font-weight: 500;">TIẾT KIỆM CHI PHÍ</span><br />
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn
					20% giá trị sản phẩm</span>
			</div>
		</div>
	</div>

	<div id="title-sanpham" class="container">
		<div class="wow heartBeat">
			<span>SẢN PHẨM HOT</span>
		</div>
		<div class="row">
			<c:forEach var="sanpham" items="${dssanphams }">
				
				<div class="col-md-3 col-sm-6">
					<a style="text-decoration: none;" href='<c:url value="/chitiet/${sanpham.getMasanpham() } " />'>
						<div class=" sanpham wow zoomIn">
							<img alt="hinh" src="<c:url value='/resources/img/images/${sanpham.getHinhsanpham()}' />" /><br />
							<span>${sanpham.getTensanpham() }</span><br /> 
							<span class="gia">${sanpham.getGiatien()} VNĐ</span>
						</div>
					</a>
				</div>
			
			</c:forEach>
			
			
			<!-- end sản phẩm -->
		</div>
	</div>
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow flipInY">
				<p>
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Yame là một thương hiệu thời trang lớn,uy tín luôn đảm
					bảo chất lượng sản phẩm tốt nhất cho khách hàng </span>
			</div>

			<div class="col-sm-4 col-md-4 wow flipInY">
				<p>
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>43 Nguyễn Trãi,Phường 12, Quận 2,Tp Hồ Chí Minh</span><br />
				<span>&copy;YameShop2020@gmail.com</span><br /> <span>Contact:
					090909090</span>
			</div>

			<div class="col-sm-4 col-md-4 wow flipInY">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form action="" method="post">
					<input name="tenNhanVien" class="footer-email" style="" placeholder="Email" />
					<textarea name="tuoi" class="footer-noidung" rows="4" cols="50"
						placeholder="Nội dung"></textarea>
					<button class="footer-submit" type="submit">Đồng ý</button>

				</form>
			</div>
		</div>

	</div>
	<script src="<c:url value='/resources/js/wow.min.js' />"></script>
	<script src="<c:url value='/resources/js/jquery-3.2.1.slim.min.js' />"></script>
	<script src="<c:url value='/resources/js/popper.min.js' />"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>


	<script src="<c:url value='/resources/js/custom.js' />"></script>
	<script>
		new WOW().init();
	</script>
</body>

</html>
