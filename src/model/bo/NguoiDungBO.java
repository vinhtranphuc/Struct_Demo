package model.bo;

import model.dao.NguoiDungDAO;

public class NguoiDungBO {

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
		if(tenDangNhap.equals("")||matKhau.equals(""))
		return false;
		else return nguoiDungDAO.checkLogin(tenDangNhap,matKhau);
	}
}
