<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Đăng nhập</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<c:url value='/resources/js/custom.js' />"></script>
</head>
<body id="body-login">
<script>
$(document).ready(function(){
	$("#trangdangky").click(function(){
		$(this).addClass("actived");
		$("#trangdangky").removeClass("actived");
		$(".container-signup-form").show();
		$(".container-login-form").css("display","none");
	});
	$("#trangdangnhap").click(function(){
		$(this).addClass("actived");
		$("#trangdangnhap").removeClass("actived");
		$(".container-signup-form").hide();
		$(".container-login-form").show();
		
	});
});
</script>

	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-left" class="header-login">
					<span id="text-logo">WELCOME</span><br/>
					<span id="hint-text-logo">Chào mừng đến với Shop của chúng tôi!!!</span>
				</div>
				<div>
					<p><span>Luôn cập nhật xu hướng thời trang mới</span></p>
					<p><span>Giảm hơn 50% các mặt hàng cho khách VIP</span></p>
					<p><span>Tận tình tư vấn cho phong cách của bạn</span></p>
				</div>
			
			</div>
			
			<div id="container-login-right">
			
				<div id="header-top-right" class="header-login">
					<span style="cursor: pointer;" id="trangdangnhap">Đăng nhập</span> / <span  style="cursor: pointer;"  class="actived" id="trangdangky">Đăng ký</span>
				</div>
				
				<div id="container-center-login-right">
					<div class="container-login-form" id="container-center-login-right">
						<input id="email" name="email" class="meterial-textinput input-icon-email" placeholder="Email" type="text"/><br/>
						<input id="matkhau" name="matkhau" class="meterial-textinput input-icon-pass" placeholder="Mật khẩu" type="password"/><br/>
						<input id="btnDangnhap" class="meterial-primary-button" type="submit" value="ĐĂNG NHẬP"/><br/>
						
					</div>
					
					<div style="display: none;" class="container-signup-form" id="container-center-login-right">
						<form action="" method="post">
							<input id="email" name="email" class="meterial-textinput input-icon-email" placeholder="Email" type="text"/><br/>
							<input id="matkhau" name="matkhau" class="meterial-textinput input-icon-pass" placeholder="Mật khẩu" type="password"/><br/>
							<input id="nhaplaimatkhau" name="nhaplaimatkhau" class="meterial-textinput input-icon-pass" placeholder="Nhập lại mật khẩu" type="password"/><br/>
							<input id="btnDangnhap" class="meterial-primary-button" type="submit" value="ĐĂNG KÝ"/><br/>
						</form>	
					</div>
						<span id="btnketqua" style="color: red;"></span>
						<span style="color: red;">${kiemtradangnhap }</span>
				
				</div>
				
				<div id="container-social-login">
				<a href="#"><img alt="facebook" src="<c:url value='resources/img/facebook.png'/>"></a>	
					<a href="#"><img alt="google" src="<c:url value='resources/img/google.png'/>"></a>
				
				</div>
			
			</div>
		</div>
	
	</div>



</body>

</html>