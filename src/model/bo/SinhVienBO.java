package model.bo;

import java.util.ArrayList;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO sinhVienDAO=new SinhVienDAO();
	public ArrayList<SinhVien> getListSinhVien() {
		return sinhVienDAO.getListSinhVien();
	}

	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
		return sinhVienDAO.getListSinhVien(maKhoa);
	}

	public SinhVien getThongTinSinhVien(String msv) {
		return sinhVienDAO.getThongTinSinhVien(msv);
	}

	public boolean suaSinhVien(String msv, String tensv, String gioitinh, String makhoa) {
	if(msv.equals("")||tensv.equals("")||gioitinh.equals("")||makhoa.equals(""))
		return false;
	return sinhVienDAO.suaSinhVien(msv,tensv,gioitinh,makhoa);
	}

	public String getMaSvTuTang() {
	return sinhVienDAO.getMaSvTuTang();
	}

	public boolean themSinhVien(String msv, String tensv, String gioitinh, String makhoa) {
	if(msv.equals("")||tensv.equals("")||gioitinh.equals("")||makhoa.equals(""))
			return false;
	return sinhVienDAO.themSinhVien(msv, tensv, gioitinh, makhoa);
	}

	public boolean xoaSinhVien(String msv) {
	if(msv.equals("")) return false;
	return sinhVienDAO.xoaSinhVien(msv);
	}

}
