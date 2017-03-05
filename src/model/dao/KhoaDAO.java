package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Khoa;

public class KhoaDAO extends DataProvider {

	public ArrayList<Khoa> getListKhoa() {
	String query="select * from khoa";
	ArrayList<Khoa> list=new ArrayList<Khoa>();
	try {
		ResultSet rs=exQ(query);
		Khoa khoa;
		while(rs.next())
		{
			khoa=new Khoa();
			khoa.setMaKhoa(rs.getString("MaKhoa"));
			khoa.setTenKhoa(rs.getString("TenKhoa"));
			list.add(khoa);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;
	}

}
