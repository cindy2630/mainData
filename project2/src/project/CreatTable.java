package project;

import java.sql.*;


public class CreatTable {

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "hr",
				"hr");) {
			Statement stmt = conn.createStatement();
			
			String sql = "  CREATE TABLE CAMPINF" + 
					"(ID NUMBER NOT NULL ," + 
					"NAME VARCHAR2(300 BYTE)," + 
					"CITY VARCHAR2(300 BYTE)," + 
					"ADRESS VARCHAR2(300 BYTE)," + 
					"TEL VARCHAR2(300 BYTE)," + 
					"OPRICE NUMBER," + 
					"WPRICE NUMBER," + 
					"TENTNUM NUMBER," + 
					"ELEVATION VARCHAR2(300 BYTE)," + 
					"FEATURE VARCHAR2(300 BYTE)," + 
					"FACILITY VARCHAR2(300 BYTE)," + 
					"PET VARCHAR2(300 BYTE)," + 
					"SERVICE VARCHAR2(300 BYTE)," + 
					"PARKING VARCHAR2(300 BYTE)," + 
					" PRIMARY KEY ( id ))";
			
			stmt.executeUpdate(sql);
		    System.out.println("露營表格已建立");

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

