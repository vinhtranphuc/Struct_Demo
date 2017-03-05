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
<h1>Danh Sách Sinh Viên</h1>
<html:form action="/danh-sach" method="get"> 
	 <html:select style="width: 165px" property="maKhoa">
		<option value="">Chọn Khoa </option>
		<html:optionsCollection name="danhSachSinhVienForm" property="listKhoa" label="tenKhoa" value="maKhoa"/>  
	</html:select>
	     <script type="text/javascript">
            	$("[name='maKhoa']").val('<bean:write name="danhSachSinhVienForm" property="maKhoa"/>');
          </script>
	<html:submit>Xem</html:submit>
	<div>
	<html:link action="/themSV"
	style="display: block;
	margin-top: 10px;
    display: block;
    width: 78px;
    height: 16px;
    background: #c4cdd0;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-bottom: -6px;
    font-weight: bold;">Thêm</html:link>
	</div>
</html:form>
<form>
	<table border="1"
	style=" border-spacing: 10px;
	    margin-top: 20px;">
	<thead>
		<tr>
			<th>Mã SV</th>
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>Khoa</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate id="sv" name="danhSachSinhVienForm" property="listSinhVien">
			<tr>
				<td>	
					<bean:write name="sv" property="msv"/>
				</td>
				<td>	
					<bean:write name="sv" property="hoTen"/>
				</td>
				<td>	
					<bean:write name="sv" property="gioiTinh"/>
				</td>
				<td>	
					<bean:write name="sv" property="tenKhoa"/>
				</td>
				<td>
				<bean:define name="sv" id="msv" property="msv"></bean:define>
					<html:link action="/suaSV?msv=${msv}">Sửa</html:link>
					<html:link action="/xoaSV?msv=${msv}">Xóa</html:link>
				</td>
			</tr>
		</logic:iterate>
	</tbody>
	</table>
</form>
</body>
</html>