package model.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
public class DataProvider {
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio= new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	public String ngayHt=ngay.format(cal.getTime());
	public String gioHt=gio.
	format(cal.getTime());
	
    private Connection con=null;
    private Statement stmt = null;
    private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    private String url;
	private String serverName="localhost:1433";
	private String user="";
	private String pass="";
	private String dbName="JavaEE_Example";
    public DataProvider() {
    }
    
  // lấy kết nối
    public Connection getCon() throws SQLException {
        url = "jdbc:sqlserver://"+serverName+";databaseName="+dbName+";integratedSecurity=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
  
   // lấy Statement
    public Statement getSta() throws SQLException {
      stmt = getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return stmt;
    }
   // lấy Rs
    public ResultSet exQ(String query) throws SQLException {
    rs=getSta().executeQuery(query);
    return rs;
     }
  // xoa, dk
    public void PreSta(String query) throws SQLException{
    pstmt=getCon().prepareStatement(query);
    pstmt.executeUpdate();	
    }
    // chèn, sửa, đk
    public void exU(String query) throws SQLException {
    	getSta().executeUpdate(query);
     }
     
    // lấy dữ liệu bảng   
	public DefaultTableModel getTb(String query,String[] tieude,String[] field)
	{
	DefaultTableModel tb=new DefaultTableModel();
	try {
	String _query=query;
	ResultSet rs = exQ(_query);
	ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		while(rs.next())
		{
			String[] dong = new String[tieude.length];
			for(int i=0;i<=tieude.length-1;i++)
			dong[i]=rs.getString(field[i]);
			dulieubang.add(dong);
		}
	String[][] data = new String[dulieubang.size()][tieude.length];
	for(int i=0; i<dulieubang.size(); i++)
	{
		data[i]=dulieubang.get(i);
	}
	tb.setDataVector(data,tieude);
	return tb;
	    }
	catch(Exception ex){
    System.out.println("Loi: "+ex);
    return null;
	}		
	}
	
//	//lấy danh sách Experience
//	public ArrayList<ExperienceCandidate> getListExp(){
//		ArrayList<ExperienceCandidate> listexp = new ArrayList<ExperienceCandidate>();
//		try {
//			String _query="select * from Candidate";
//			ResultSet rs = exQ(_query);
//			ExperienceCandidate exp = null;
//			while(rs.next()){
//				exp = new ExperienceCandidate();
//				exp.setId_candidate(rs.getInt("IDCandidate"));
//				exp.setFirstame(rs.getString("FirstName"));
//				exp.setLastname(rs.getString("LastName"));
//				exp.setBirthdate(rs.getInt("BirthDate"));
//				exp.setAddress(rs.getString("Address"));
//				exp.setPhone(rs.getInt("Phone"));
//				exp.setEmail(rs.getString("Email"));
//				exp.setCandidate_type(rs.getInt("Candidate_type"));
//				listexp.add(exp);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listexp;
//	}
	
    // lấy dữ liệu comboBox
	public DefaultComboBoxModel<String> getCmb(String query,String element,String field)
	{ 
	DefaultComboBoxModel<String> cmbModel=new DefaultComboBoxModel<String>();
	cmbModel.addElement(element);
	try {
	exQ(query);
	while(rs.next()){
	cmbModel.addElement(rs.getString(field));
	}
	return cmbModel;
	}
	catch(Exception e)
	{
	System.out.println("Loi: "+e);
	return null;
	}

	}
	// Id tự tăng
	int Ai(String tb,String ma)
	{
	    int id1=0,id2=0;
		String id = null;
		try {
			exQ("select * from "+tb+"");
				while(rs.next())
				{
					id = new String();
					id = rs.getString(ma);
					id1=Integer.parseInt(id);
					if(id1>=id2)
					{
						id2=id1;
					}
				}
				return id2+1;
			}
			catch(Exception ex){
		    System.out.println("Lỗi tăng Id - DAL/Connect/Id");
		    ex.printStackTrace();
			return id2;
			}
	}
	
	// Đếm số dòng 
	public String demDong(String query)
	{
		String soDong="";
		int countRow=0;
		try {
	        exQ(query);
				while(rs.next())
				{
					countRow++;
				}
				soDong=""+countRow;
				return soDong;
			}
			catch(Exception ex){
				System.out.println("Lỗi đếm dòng - DAL/Connect: "+ex);
				return null;
			}
	}
	
	// lấy ô Table
	public String getCell(String query,String col)
	{
		String cell="null";
		try {
			exQ(""+query+"");
				while(rs.next())
				{
					cell = rs.getString(col);;
				}
				return cell;
			}
			catch(SQLException ex){
		System.out.println("Lỗi: "+ex);
				return "Lỗi";
			}
	}

}

