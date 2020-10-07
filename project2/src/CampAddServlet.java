
import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import java.io.*;

import java.sql.*;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import project.CampBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class CampAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		if (request.getParameter("submit") != null)
			gotoSubmitProcess(request, response);
		else if (request.getParameter("confirm") != null)
			gotoConfirmProcess(request, response);
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		String name;
		String city;
		String adress;
		String tel;
		int oprice= 0;
		int wprice= 0;
		int tentnum= 0;
		String elevation;
		String feature;
		String facility;
		String pet;
		String service;
		String parking;
		

		id=Integer.parseInt(request.getParameter("id").trim());
		name = request.getParameter("name").trim();
		city = request.getParameter("city").trim();
		adress = request.getParameter("adress").trim();
		tel = request.getParameter("tel").trim();
		oprice=Integer.parseInt(request.getParameter("oprice").trim());
		wprice=Integer.parseInt(request.getParameter("wprice").trim());
		tentnum=Integer.parseInt(request.getParameter("tentnum").trim());
		elevation = request.getParameter("elevation").trim();
		feature = request.getParameter("feature").trim();
		facility = request.getParameter("facility").trim();
		pet = request.getParameter("pet").trim();
		service = request.getParameter("service").trim();
		parking = request.getParameter("parking").trim();
		CampBean dao = new CampBean( id, name, city, adress, tel, oprice, wprice, tentnum, 
				elevation, feature, facility, pet, service, parking);
		request.getSession(true).setAttribute("dao", dao);
		request.getRequestDispatcher("/Displaycamp.jsp").forward(request, response);
	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {

			ctxt = new InitialContext();

			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");

			conn = ds.getConnection();

			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
			CampBean campData = (CampBean) request.getSession(true).getAttribute("dao");
			if (campBeanDAO.insertCamp(campData)) {
				System.out.println("Get some SQL commands done!");
				request.getSession(true).invalidate();
				request.getRequestDispatcher("/Thanks.jsp").forward(request, response);
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		}  catch(NumberFormatException nbe) {
            nbe.printStackTrace();
        }finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}

}
