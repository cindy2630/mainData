
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import project.CampBean;

public class CampBeanDAO {
	private Connection conn;

	public CampBeanDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public CampBeanDAO() {
	}

	public boolean insertCamp(CampBean campData) {
		try {
			String sqlString = "insert into campinf values('" + campData.getId() + "','" + campData.getName() + "','"
					+ campData.getCity() + "','" + campData.getAdress() + "','" + campData.getTel() + "','"
					+ campData.getOprice() + "','" + campData.getWprice() + "','" + campData.getTentnum() + "','"
					+ campData.getElevation() + "','" + campData.getFeature() + "','" + campData.getFacility() + "','"
					+ campData.getPet() + "','" + campData.getService() + "','" + campData.getParking() + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("新增資料時發生錯誤:" + e);
			return false;
		}
	}
	
	public List<CampBean>getcampsById(int id){
		List<CampBean> list1 = new ArrayList<CampBean>();
		String sql = "select * from campinf where id like '%"+id+"%'";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		list1.add(new CampBean(rs.getInt("id"),rs.getString("name"),
		rs.getString("city"),rs.getString("adress"),rs.getString("tel"),
		rs.getInt("oprice"),rs.getInt("wprice"),rs.getInt("tentnum"),rs.getString("elevation"),
		rs.getString("feature"),rs.getString("facility"),rs.getString("pet"),
		rs.getString("service"),rs.getString("parking")));
		}
		} catch (Exception e) {
		e.printStackTrace();
		}

		return list1;
		}
	


	public List<CampBean>getcampsByCity(String city) {
		String sql = "select * from campinf where city like '%"+city+"%' ";
		List<CampBean> list2 = new ArrayList<CampBean>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				list2.add(new CampBean(rs.getInt("id"),rs.getString("name"),
				rs.getString("city"),rs.getString("adress"),rs.getString("tel"),
				rs.getInt("oprice"),rs.getInt("wprice"),rs.getInt("tentnum"),rs.getString("elevation"),
				rs.getString("feature"),rs.getString("facility"),rs.getString("pet"),
				rs.getString("service"),rs.getString("parking")));
				}
		} catch (Exception e) {
		e.printStackTrace();
		}
	
		return list2;
		}

//	public List<CampBean> getcampsByName(String name) {
//		String sql = "select * from campinf where name like '%"+name+"%' ";
//		List<CampBean> list3 = new ArrayList<CampBean>();
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()){
//				list3.add(new CampBean(rs.getInt("id"),rs.getString("name"),
//				rs.getString("city"),rs.getString("adress"),rs.getString("tel"),
//				rs.getInt("oprice"),rs.getInt("wprice"),rs.getInt("tentnum"),rs.getString("elevation"),
//				rs.getString("feature"),rs.getString("facility"),rs.getString("pet"),
//				rs.getString("service"),rs.getString("parking")));
//				}
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//	
//		return list3;
//		}
	

	
//	public void Mcheck(int id, CampBean campData) {
//		
//		if (campData.getCampBean() <= 0 ) {
//			return;
//		}
//		
//	}
	
	  public boolean deleteCamp(int id) {
		    try {
		    	String sqlString = "DELETE FROM campinf " +
		    			"WHERE id ="+id;
//		    	System.out.println(conn);
//		      String sql= "DELETE from campinf WHERE id = ?";
//		      PreparedStatement stmt = conn.prepareStatement(sql);
//                stmt.setInt(1, id);
//				 int deletecount = stmt.executeUpdate(sql);
//		    	System.out.println(sqlString);
		    	Statement stmt = conn.prepareStatement(sqlString);
	           int deletecount = stmt.executeUpdate(sqlString);
				  stmt.close();
				  if (deletecount >= 1)
						return true;
					else
						return false;              
			  } catch (Exception e) {
			    System.err.println("刪除時發生錯誤: "+ e);
			    e.printStackTrace();
				  return false;
			  }
		  }

		  public boolean updateCamp(CampBean campData) {
		    try {
		      String sqlString = "UPDATE campinf set name =?, city=?, adress=?, tel=?, oprice=?, wprice=?,"
		      		+ " tentnum=?, elevation=?, feature=?, facility=?, pet=?, service=?,parking=? WHERE id = ?";

		      PreparedStatement stmt = conn.prepareStatement(sqlString);
			    stmt.setInt(14, campData.getId());
			    stmt.setString(1, campData.getName());
			    stmt.setString(2, campData.getCity());
			    stmt.setString(3, campData.getAdress());
			    stmt.setString(4, campData.getTel());
			    stmt.setInt(5, campData.getOprice());
			    stmt.setInt(6, campData.getWprice());
			    stmt.setInt(7, campData.getTentnum());
			    stmt.setString(8, campData.getElevation());
			    stmt.setString(9, campData.getFeature());
			    stmt.setString(10, campData.getFacility());
			    stmt.setString(11, campData.getPet());
			    stmt.setString(12, campData.getService());
			    stmt.setString(13, campData.getParking());
			    int updatecount = stmt.executeUpdate();
			    
		      stmt.close();
		      if (updatecount >= 1) return true;
		      else                  return false;
			  } catch (Exception e) {
			    System.err.println("更新資料時發生錯誤:" + e);
			    e.printStackTrace();
				  return false;
		    }
		  }
		  
		

		
	


}