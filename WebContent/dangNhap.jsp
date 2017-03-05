<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h3>Đăng Nhập</h3>
		<br>
		<html:form action="/dang-nhap" method="post">
		UserName: <html:text property="tenDangNhap"></html:text> <br/>
		PassWord: <html:password property="matKhau"></html:password><br/>
		<html:submit value="Đăng nhập"></html:submit>
		<button type="reset">làm mới</button>
			<p><bean:write name="nguoiDungForm" property="thongBao"/></p>
		</html:form>
	</div>
</body>
</html>