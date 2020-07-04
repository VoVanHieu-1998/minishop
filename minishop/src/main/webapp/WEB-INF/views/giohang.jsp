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
	href="<c:url value='/resources/css/chitiet.css' />" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
</head>
<body>
<!-- khi ajax trên thực hiện xong thì done(function(){.....ajax dưới thực hiện $(".circle-giohang").html = "<span>" + value thay đổi
   đoạn text của class .circle-giohang thì .html .   function (value) là kết quả trả về trong phương thức ở controller chỗ return;
.......}) -->
<script>
$(document).ready(function(){
	
	
	GanTongTienGioHang();
	function GanTongTienGioHang(isEventChange) {
		var tongtien=0;
		$(".giatien").each(function() {
			var soluong = $(this).closest("tr").find(".soluong-giohang").val();
			var giatien = $(this).text();
			
			var tinhtiensoluongsp= soluong * parseInt(giatien);
			var format = parseFloat(tinhtiensoluongsp).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, '$1.')
			
			if(!isEventChange){
				$(this).html(format);
			}
			tongtien= tongtien + tinhtiensoluongsp;
			
			var formattongtien=tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, '$1.').toString()
			$("#tongtien").html(formattongtien+"")
		})
	}
	$(".xoa-giohang").click(function() {
		var self =$(this);
		var masp= $(this).closest("tr").find(".ten").attr("data-masp");		
		var mamau= $(this).closest("tr").find(".mau").attr("data-mamau");		
		var masize= $(this).closest("tr").find(".size").attr("data-masize");
		
		 $.ajax({
				url:"/minishop/api/xoagiohang",
				type :"GET",
				data:{
					masp:masp,
					masize:masize,
					mamau:mamau,
					
				},
				success: function (value) {
					self.closest("tr").remove();
					GanTongTienGioHang(true);
				}
			})
	})
	
 	$(".soluong-giohang").change(function () {
	var soluong = $(this).val();
	var giatien = $(this).closest("tr").find(".giatien").attr("data-giatien");
	var tongtien= soluong * parseInt(giatien);
	var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, '$1.').toString()
	$(this).closest("tr").find(".giatien").html(format);
	GanTongTienGioHang(true);
	
	var masp= $(this).closest("tr").find(".ten").attr("data-masp");
	
	var mamau= $(this).closest("tr").find(".mau").attr("data-mamau");
	
	var masize= $(this).closest("tr").find(".size").attr("data-masize");
	var soluong = $(this).val();
	
	
	
	
	 $.ajax({
			url:"/minishop/api/capnhapgiohang",
			type :"GET",
			data:{
				masp:masp,
				masize:masize,
				mamau:mamau,
				soluong:soluong
			},
			success: function (value) {
				
			}
		})
	
	
	})
	
 
	
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
						aria-expanded="false"> Dropdown </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
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

				<span style="display: flex;" class="navbar-text"> <a href="<c:url value='/giohang/' />"><img
						src="<c:url value='/resources/img/Cart2x.png' />" /></a>
						<span class="circle-giohang" style="color: white ;font-size: 11px;">${soluongsanphamgiohang }</span>
				</span>

			</div>
		</nav>


	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h3>Danh sách sản phẩm trong giỏ hàng</h3>
				<table class="table">
					<thead>
						<tr>
							<td><h5>Tên sản phẩm</h5></td>
							<td><h5>Màu sản phẩm</h5></td>
							<td><h5>Size</h5></td>
							<td><h5>Số lượng</h5></td>
							<td><h5>Giá tiền</h5></td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="listitemgiohang" items="${listgiohang }">
							<tr data-machitiet="${listitemgiohang.getMachitiet() }">
								<td class="ten" data-masp="${listitemgiohang.getMasp() }">${listitemgiohang.getTensp() }</td>
								<td class="mau" data-mamau="${listitemgiohang.getMamau() }">${listitemgiohang.getTenmau() }</td>
								<td class="size" data-masize="${listitemgiohang.getMasize() }">${listitemgiohang.getTensize() }</td>
								<td class="soluong"><input class="soluong-giohang" min="1" type="number"
									value="${listitemgiohang.getSoluong() }" /></td>
								<td class="giatien" data-giatien="${listitemgiohang.getGiatien() }">${listitemgiohang.getGiatien() }</td>
								<td class="xoa-giohang btn btn-danger">Xóa</td>
							</tr>

						</c:forEach>

					</tbody>

				</table>
				<h3 >Tổng tiền:<span id="tongtien" style="color: red">0</span> </h3>
			</div>
			<div class="col-md-6 col-sm-12">
				<h3>Thông tin người mua</h3>
				
				<div class="form-group">
					<form action="" method="post">
					<label for=""tenkhachhang"">Tên người mua:</label> 
					<input type="text"class="form-control" id="tenkhachhang" name="tenkhachhang">
					<label for="sodt">Số điện thoại:</label> 
					<input type="text"class="form-control" id="sodt" name="sodt">
					 
					    <div class="radio">
					      <label><input type="radio" name="hinhthucgiaohang" checked value="Giao hàng tận nơi">Giao hàng tận nơi </label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" name="hinhthucgiaohang" value="Nhận hàng tại của hàng">Nhận hàng tại của hàng</label>
					    </div>
					    
					  <label for="diachigiaohang">Địa chỉ:</label> 
					<input type="text"class="form-control" id="diachigiaohang" name="diachigiaohang">
					 
					    <div class="form-group">
					      <label for="ghichu">Ghi chú:</label>
					      <textarea class="form-control" rows="5" id="ghichu" name="ghichu"></textarea>
					    </div>
					 	<input type="submit" class="btn btn-primary" value="Đặt hàng"/>
					  
					  </form>
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
