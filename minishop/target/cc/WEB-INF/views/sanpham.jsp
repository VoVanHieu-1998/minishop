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
<link rel="stylesheet"
	href="<c:url value='/resources/css/sanpham.css' />" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<!-- khi ajax trên thực hiện xong thì done(function(){.....ajax dưới thực hiện $(".circle-giohang").html = "<span>" + value thay đổi
   đoạn text của class .circle-giohang thì .html .   function (value) là kết quả trả về trong phương thức ở controller chỗ return;
.......}) -->
<script>
$(document).ready(function(){
	$(".btn-giohang").click(function(){
		
		var machitiet = $(this).attr("data-machitiet");
		var mamau= $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau= $(this).closest("tr").find(".mau").text();
		var masize= $(this).closest("tr").find(".size").attr("data-masize");
		var tensize= $(this).closest("tr").find(".size").text();
		var soluong= $(this).closest("tr").find(".soluong").text();
		var tensp=$("#tensp").text();
		var masp= $("#tensp").attr("data-masp");
		var giatien= $("#giatien").attr("data-value");
		
		 $.ajax({
			url:"/minishop/api/themgiohang",
			type :"GET",
			data:{
				masp:masp,
				masize:masize,
				mamau:mamau,
				tensp:tensp,
				giatien:giatien,
				tenmau:tenmau,
				tensize:tensize,
				soluong:soluong,
				machitiet:machitiet
			},
			success: function (value) {
				
			}
		}).done(function(){
			 $.ajax({
					url:"/minishop/api/laysoluonggiohang",
					type :"GET",
					
					success: function (value) {
						$(".circle-giohang").html( "<span>" + value + "</span>") ;
					}
				})
		}) 
	});
	
});

</script>

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
							<li><a href="dangnhap"><span
									style="width: 32px; height: 32px; border-radius: 16px; background-color: chocolate; text-align: center; padding: 6px; margin-top: 10px; margin-bottom: 15px;"
									class="circle-avatar">${chucaidau }</span></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="dangnhap">Đăng nhập</a></li>
						</c:otherwise>
					</c:choose>

				</ul>

				<span style="display: flex;" class="navbar-text"> <a href="#"><img
						src="<c:url value='/resources/img/Cart2x.png' />" /></a>
						<span class="circle-giohang" style="color: white ;font-size: 11px;">${soluongsanphamgiohang }</span>
				</span>

			</div>
		</nav>


	</div>

	<div class="container">
		<div class="row" style="margin-top: 16px">
			<div class="col-sm-2 col-md-2">
				<h3>Danh mục</h3>
				<ul class="mymenu">
				<c:forEach var="list" items="${danhmucsanphams }">
					<li><a href='<c:url value="/sanpham/${list.getMadanhmuc() }/${list.getTendanhmuc() }" />'>${list.getTendanhmuc() }</a></li>
				
				</c:forEach>
					
				</ul>
			</div>

			<div class="col-sm-10 col-md-10">
					<div id="title-sanpham" class="container">
						<div class="wow heartBeat">
							<span>${tendanhmuc }</span>
						</div>
						<div class="row">
						<c:forEach var="sanpham" items="${listsanphamtheomadanhmuc }">
							
							<div class="col-md-4 col-sm-6">
								<a style="text-decoration: none;" href="chitiet/${sanpham.getMasanpham() }">
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

			</div>
			
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
					<input name="tenNhanVien" class="footer-email" style=""
						placeholder="Email" />
					<textarea name="tuoi" class="footer-noidung" rows="4" cols="50"
						placeholder="Nội dung"></textarea>
					<button class="footer-submit" type="submit">Đồng ý</button>

				</form>
			</div>
		</div>

	</div>
	<script src="<c:url value='/resources/js/wow.min.js' />"></script>
	<script src="<c:url value='/resources/js/popper.min.js' />"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>


	<script src="<c:url value='/resources/js/custom.js' />"></script>
	<script>
		new WOW().init();
	</script>
</body>

</html>
