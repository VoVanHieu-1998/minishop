$(document).ready(function(){
	$("#cot1").click(function(){
		alert("hello");
	});
	
	$("#btnDangnhap").click(function(){
		var email=$("#email").val();
		var password=$("#matkhau").val();
		$.ajax ({
//			function (value) kết quả trả về của bên controller url
// email,matkhau là các biến của hàm @RequestParam trong controller
			url:"/minishop/api/kiemtradangnhap",
			type :"GET",
			data:{
				email:email,
				matkhau:password
			},
			success: function (value) {
				if(value=="true"){
					$("#btnketqua").text()
					duongDanHienTai=window.location.href; /*lấy đường dẫn hiện tại*/
					duongDan = duongDanHienTai.replace("dangnhap/",""); /*thay thế đường dẫn hienj tại bằng home*/
					window.location = duongDan; /*chuyển page qua trang home*/
				}else{
					$("#btnketqua").text("Sai Email hoặc mật khẩu?")
				}
			}
		})
	});
	
});
