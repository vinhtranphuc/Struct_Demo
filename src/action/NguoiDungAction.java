package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NguoiDungForm;
import model.bo.NguoiDungBO;

public class NguoiDungAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NguoiDungForm nguoiDungForm=(NguoiDungForm) form;
		NguoiDungBO nguoiDungBO=new NguoiDungBO();
		
		String tenDangNhap=nguoiDungForm.getTenDangNhap();
		String matKhau=nguoiDungForm.getMatKhau();
		
		if(nguoiDungBO.checkLogin(tenDangNhap,matKhau))
				return mapping.findForward("thanhCong");
		else
		{
		nguoiDungForm.setThongBao("Đăng nhập đéo thanh công!");
		return mapping.findForward("thatBai");	
		}
	}
}
