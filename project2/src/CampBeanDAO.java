
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
//	public List<CampBean>getcampsById(int id){
//		List<CampBean> list1 = new ArrayList<CampBean>();
//		String sql = "select * from campinf where city like '%"+id+"%'";
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//		while(rs.next()){
//		list1.add(new CampBean(rs.getInt("id"),rs.getString("name"),
//		rs.getString("city"),rs.getString("adress"),rs.getString("tel"),
//		rs.getInt("oprice"),rs.getInt("wprice"),rs.getInt("tentnum"),rs.getString("elevation"),
//		rs.getString("feature"),rs.getString("facility"),rs.getString("pet"),
//		rs.getString("service"),rs.getString("parking")));
//		}
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//
//		return list1;
//		}
	


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
		      String sql= "DELETE * from campinf WHERE `id` = ?";
		      PreparedStatement stmt = conn.prepareStatement(sql);
				  int deletecount = stmt.executeUpdate(sql);
				  stmt.close();
		      if (deletecount >= 1) return true;
				  else                  return false;
			  } catch (Exception e) {
			    System.err.println("刪除時發生錯誤: "+ e);
				  return false;
			  }
		  }

		  public boolean updateCamp(CampBean camping) {
		    try {
		      String sqlString = "UPDATE `id` name ` city` adress` tel `oprice ` wprice `"
		      		+ " tentnum `elevation` feature `facility` pet` service`=?,`parking`=? WHERE `id` = ?";

		      PreparedStatement stmt = conn.prepareStatement(sqlString);
			    stmt.setInt(1, camping.getId());
			    stmt.setString(2, camping.getCity());
			    stmt.setString(3, camping.getName());
			    stmt.setString(4, camping.getAdress());
			    stmt.setString(5, camping.getTel());
			    stmt.setInt(6, camping.getOprice());
			    stmt.setInt(7, camping.getWprice());
			    stmt.setInt(8, camping.getTentnum());
			    stmt.setString(9, camping.getElevation());
			    stmt.setString(10, camping.getFeature());
			    stmt.setString(11, camping.getFacility());
			    stmt.setString(12, camping.getPet());
			    stmt.setString(13, camping.getService());
			    stmt.setString(14, camping.getParking());
			    int updatecount = stmt.executeUpdate(sqlString);
		      stmt.close();
		      if (updatecount >= 1) return true;
		      else                  return false;
			  } catch (Exception e) {
			    System.err.println("更新資料時發生錯誤:" + e);
				  return false;
		    }
		  }
		  
		

		
	


}