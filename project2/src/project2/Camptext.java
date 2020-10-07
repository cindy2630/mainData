package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Camptext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "hr",
					"hr");
			CampingDAO ca = new CampingDAO(conn);
			Camping camping=new Camping();
			camping.setCity("¥_");	
			ca.selectCamping(camping);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
