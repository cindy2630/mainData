package project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.I2D;
import com.sun.org.glassfish.gmbal.ParameterNames;

public class CampingDAO {
	private Connection conn;
	  public CampingDAO(Connection conn) {
			this.conn = conn;
	  }

	  public boolean insertCamp(Camping camping) {
		    try {
		      String sqlString = "insert into campinf values('"
			                  	   	+camping.getId()+"','"
				                    +camping.getName()+"','"
		                            + camping.getCity()+"','"
		                            + camping.getAdress()+"','"
		                            + camping.getTel()+"','" 
		                            + camping.getOprice()+"','"
		                            + camping.getWprice()+"','"
		                            + camping.getTentnum()+"','"
		                            + camping.getElevation()+ "','" 
		                            + camping.getFeature()+"','" 
		                            + camping.getFacility()+"','"
		                            + camping.getPet()+"','"
		                            + camping.getService()+"','"
		                            + camping.getParking()+ "')";
		                           
		      Statement stmt = conn.createStatement();
		      System.out.println(sqlString);
			    int updatecount = stmt.executeUpdate(sqlString);
		      stmt.close();
		      if (updatecount >= 1) return true;
		      else                  return false;
			  } catch (Exception e) {
			    System.err.println("新增資料時發生錯誤:" + e);
				  return false;
		    }
		  }

	  public boolean deleteCamp(int id) {
	    try {
	      String sqlString = "DELETE FROM campinf " +
				                   "WHERE id = " + id;
		    Statement stmt = conn.createStatement();
			  int deletecount = stmt.executeUpdate(sqlString);
			  stmt.close();
	      if (deletecount >= 1) return true;
			  else                  return false;
		  } catch (Exception e) {
		    System.err.println("刪除時發生錯誤: "+ e);
			  return false;
		  }
	  }

	  public boolean updateCamp(Camping camping) {
	    try {
	      String sqlString = "UPDATE campinf " +
		                  	   	 "SET name = '" + camping.getName() +"' "+ 
	                    			 "WHERE id = " + camping.getId();

	      Statement stmt = conn.createStatement();
		    int updatecount = stmt.executeUpdate(sqlString);
	      stmt.close();
	      if (updatecount >= 1) return true;
	      else                  return false;
		  } catch (Exception e) {
		    System.err.println("更新資料時發生錯誤:" + e);
			  return false;
	    }
	  }

	  public void selectCamping(Camping camping){
		
		  
	    try {

	    	
	      String sqlString = "SELECT * FROM CAMPINF WHERE CITY=?";
	      
	      PreparedStatement stmt = conn.prepareStatement(sqlString);
	    	
	      stmt.setString(1,"%"+camping.getCity()+"%");
//	    	Statement stmt = conn.createStatement();
//	        String sqlString = "SELECT * FROM CAMPINF WHERE 1=1 ";

//	      List<String> list = new ArrayList<String>();
//	      if(camping.getCity() != "") {
//	    	 sqlString +="city like ? ";
//	    	list.add("%" +camping.getCity()+"%");
//	      }
	      
	      ResultSet rs = stmt.executeQuery();
	      
		  while(rs.next()){
			  int id = rs.getInt("id");
			  String name = rs.getString("name");
			  String city = rs.getString("city");
			  String adress = rs.getString("adress");
			  String tel = rs.getString("tel");
			  int oprice = rs.getInt("oprice");
			  int wprice = rs.getInt("wprice");
			  int tentnum = rs.getInt("tentnum");
			  String elevation = rs.getString("elevation");
			  String feature = rs.getString("feature");
			  String facility = rs.getString("facility");
			  String pet = rs.getString("pet");
			  String service = rs.getString("service");
			  String parking = rs.getString("parking");
			  System.out.println(id+name+city+adress+tel+oprice+wprice+tentnum
					  +elevation+feature+facility+pet+service+parking);
		  }
		  System.out.println("查詢完成");
          stmt.clearParameters();
//		  while(rs.next()){
//			  String s = new String(); 			  
//			  camping.setId(rs.getInt("id"));
//			  camping.setName(rs.getString("name"));
//			  camping.setCity(rs.getString("city"));
//			  camping.setAdress(rs.getString("adress"));
//			  camping.setTel(rs.getString("tel"));
//			  camping.setOprice(rs.getInt("oprice"));
//			  camping.setWprice(rs.getInt("wprice"));
//			  camping.setTentnum(rs.getInt("tentnum"));
//			  camping.setElevation(rs.getString("elevation"));
//			  camping.setFeature(rs.getString("feature"));
//			  camping.setFacility(rs.getString("facility"));
//			  camping.setPet(rs.getString("pet"));
//			  camping.setService(rs.getString("service"));
//			  camping.setParking(rs.getString("parking"));
//			  list.add(s);
//			  System.out.println("id"+"name"+"city"+"adress"+"tel"+"oprice"+"wprice"+"tentnum"
//					  +"elevation"+"feature"+"facility"+"pet"+"service"+"parking");
//		  }

		  
		  
	    } catch (Exception e) {
		    System.err.println("尋找資料時發生錯誤:" + e);
	    }
		}


}
