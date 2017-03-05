package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.SinhVien;

public class SinhVienDAO extends DataProvider {

	public ArrayList<SinhVien> getListSinhVien() {
		ArrayList<SinhVien> list=new ArrayList<SinhVien>();
		try{
		String query="select sv.MSV,sv.HoTen,case gioitinh when 1 then 'Nam' else 'Nu' end as GioiTinh,sv.HoTen,kh.TenKhoa from SinhVien as sv, Khoa as kh where sv.MaKhoa=kh.MaKhoa order by MSV asc";
		ResultSet rs=exQ(query);
		SinhVien sv;
			while(rs.next())
			{
				sv=new SinhVien();
				sv.setMsv(rs.getString("MSV"));
				sv.setHoTen(rs.getString("HoTen"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setTenKhoa(rs.getString("TenKhoa"));
				list.add(sv);
			}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
	ArrayList<SinhVien> list=new ArrayList<SinhVien>();
	try{
String query="select sv.MSV,sv.HoTen,case GioiTinh when 1 then 'Nam' else 'Nu' end as GioiTinh,sv.HoTen,kh.TenKhoa from SinhVien as sv, Khoa as kh where sv.MaKhoa=kh.MaKhoa and kh.MaKhoa=N'"+maKhoa+"'";
	ResultSet rs=exQ(query);
	SinhVien sv;
			while(rs.next())
			{
				sv=new SinhVien();
				sv.setMsv(rs.getString("MSV"));
				sv.setHoTen(rs.getString("HoTen"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setTenKhoa(rs.getString("TenKhoa"));
				list.add(sv);
			}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return list;
	}

	public SinhVien getThongTinSinhVien(String msv) {
		String query="Select * from sinhvien where msv="+msv;
		SinhVien sinhVien=new SinhVien();
		try {
			ResultSet rs=exQ(query);
			while(rs.next())
			{System.out.println("SinhVienDAO>getThongTinhSinhVien: masv:"+rs.getString("HoTen"));
				sinhVien.setMsv(msv);
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setMaKhoa("MaKhoa");
			}
		} catch (SQLException e) {
			System.out.println("Lỗi SinhVienDAO/getThongTinSinhVien(): "+e);
		}
		return sinhVien;
	}

	public boolean suaSinhVien(String msv, String tensv, String gioitinh, String makhoa) {
	String query="update SinhVien set HoTen=N'"+tensv+"',GioiTinh=N'"+gioitinh+"',MaKhoa=N'"+makhoa+"'where MSV='"+msv+"'";
	try {
	exU(query);
	return true;
	} catch (SQLException e) {
	System.out.println("Lỗi SinhVienDAO/suaSinhVien: "+e);
	}
	return false;
	}
	
	public boolean themSinhVien(String msv,String tensv,String gioitinh,String makhoa)
	{
	System.out.println("SinhVienDAO - MSV: "+msv);
	String query="insert into SinhVien values(N'"+msv+"',N'"+tensv+"',N'"+gioitinh+"',N'"+makhoa+"')";
	try {
	exU(query);
	return true;
	} catch (SQLException e) {
	System.out.println("Lỗi SinhVienDAO/themSinhVien cmnr!"+e);
	e.printStackTrace();
	}
	return false;	
	}

	public String getMaSvTuTang() {
	return String.valueOf(Ai("SinhVien","MSV"));
	}

	public boolean xoaSinhVien(String msv) {
	String query="DELETE SINHVIEN WHERE MSV='"+msv+"'";
	try {
		PreSta(query);
		return true;
	} catch (SQLException e) {
	System.out.println("Lỗi SinhVienDAO/xoaSinhVien");
		e.printStackTrace();
		return false;
		}
	}	
}
