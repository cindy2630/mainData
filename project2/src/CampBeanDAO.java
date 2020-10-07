
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.CampBean;
import project2.Camping;

public class CampBeanDAO {
	private Connection conn;

	public CampBeanDAO(Connection conn) {
		super();
		this.conn = conn;
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

	public boolean selectCamping(CampBean campData) {

		try {

			String sqlString = "SELECT * FROM CAMPINF WHERE CITY=?";

			PreparedStatement stmt = conn.prepareStatement(sqlString);

			stmt.setString(1, "%" + campData.getCity() + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				System.out.println(id + name + city + adress + tel + oprice + wprice + tentnum + elevation + feature
						+ facility + pet + service + parking);
			}
			System.out.println("查詢完成");
			stmt.clearParameters();

		} catch (Exception e) {
			System.err.println("尋找資料時發生錯誤:" + e);
		}
		return false;
	}

}