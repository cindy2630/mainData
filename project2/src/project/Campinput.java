package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class Campinput {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "hr",
				"hr");) {
			PreparedStatement pstmt = null;
			File file = new File("C:\\Users\\Student\\Desktop\\project2\\campinf.csv");
			InputStreamReader ips = new InputStreamReader(new FileInputStream(file), "BIG5");
			BufferedReader bf = new BufferedReader(ips);

			String jdbc_insert_sql = "INSERT INTO CAMPINF" + "(ID,NAME,CITY,ADRESS,TEL,OPRICE,WPRICE,TENTNUM,ELEVATION,FEATURE,FACILITY,PET,SERVICE,PARKING) VALUES" 
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(jdbc_insert_sql);

			String lineText = null;
			while ((lineText = bf.readLine()) != null) {
				String[] data = lineText.split(",");
				String idd = data[0];
				String name = data[1];
				String city = data[2];
				String adress = data[3];
				String tel = data[4];
				String opprice = data[5];
				String wpprice = data[6];
				String ttentnum = data[7];
				String elevation = data[8];
				String feature = data[9];
				String facility = data[10];
				String pet = data[11];
				String service = data[12];
				String parking = data[13];				
				
				int id = Integer.parseInt(idd);
				int oprice = Integer.parseInt(opprice);
				int wprice = Integer.parseInt(wpprice);
				int tentnum = Integer.parseInt(ttentnum);
				
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, city);
				pstmt.setString(4, adress);
				pstmt.setString(5, tel);
				pstmt.setInt(6, oprice);
				pstmt.setInt(7, wprice);
				pstmt.setInt(8, tentnum);
				pstmt.setString(9, elevation);	
				pstmt.setString(10, feature);	
				pstmt.setString(11, facility);	
				pstmt.setString(12, pet);	
				pstmt.setString(13, service);	
				pstmt.setString(14, parking);	
				pstmt.addBatch();
				
				pstmt.executeBatch();
				pstmt.clearBatch();
				


				
				
				System.out.println(id+" "+name+" "+city+" "+adress+" "+tel+" "+oprice+" "+wprice+" "+tentnum+" "+elevation
						+" "+feature+" "+facility+" "+pet+" "+service+" "+parking);
				

				
			}
			bf.close();

			System.out.println("done");
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

