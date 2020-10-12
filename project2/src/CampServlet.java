
import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import java.io.*;

import java.sql.*;
import java.util.List;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import project.CampBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		if (request.getParameter("submit") != null)//新增資料
			gotoSubmitProcess(request, response);
		else if (request.getParameter("confirm") != null)
			gotoConfirmProcess(request, response);
		
		if (request.getParameter("submitshow") != null)//模糊查詢
			CampSelec(request, response);
		
		if (request.getParameter("submitfind") != null) //管理者
			ManagerFind(request, response);
		else if (request.getParameter("confirmdelet") != null)
			ManagerDelet(request, response);
		else if (request.getParameter("submitupdate") != null)
			ManagerUpdate(request, response);
		else if (request.getParameter("confirmupdate") != null)
			Updateconfirm(request, response);
		else if (request.getParameter("confirmshow") != null)
			ManagerConfirm(request, response);
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name").trim();
		String city = request.getParameter("city").trim();
		String adress = request.getParameter("adress").trim();
		String tel = request.getParameter("tel").trim();
		int oprice = Integer.parseInt(request.getParameter("oprice").trim());
		int wprice = Integer.parseInt(request.getParameter("wprice").trim());
		int tentnum = Integer.parseInt(request.getParameter("tentnum").trim());
		String elevation = request.getParameter("elevation").trim();
		String feature = request.getParameter("feature").trim();
		String facility = request.getParameter("facility").trim();
		String pet = request.getParameter("pet").trim();
		String service = request.getParameter("service").trim();
		String parking = request.getParameter("parking").trim();
		CampBean dao = new CampBean(id, name, city, adress, tel, oprice, wprice, tentnum, elevation, feature, facility,
				pet, service, parking);
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
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}

	public void CampSelec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();

//			int id = Integer.parseInt(request.getParameter("id").trim());
			String city = request.getParameter("city");
//			String name = request.getParameter("name");
			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			List<CampBean> list1 = campBeanDAO.getcampsById(id);
			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);
//			List<CampBean> list3 = campBeanDAO.getcampsByName(name);

//			request.getSession(true).setAttribute("list1", list1);
			request.getSession(true).setAttribute("list2", list2);
//			request.getSession(true).setAttribute("list3", list3);
			request.getRequestDispatcher("/DisplaySelec.jsp").forward(request, response);
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	
	public void ManagerFind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();


			String city = request.getParameter("city");
			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);


			request.getSession(true).setAttribute("list2", list2);
			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	

	public void ManagerDelet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();

//			 String idStr = request.getParameter("id"); //刪除數據的ID，根據ID刪除
//			 int id = Integer.valueOf(idStr);
//			 CampBean dao = new CampBean();
//			 dao.deleteAdmin(id)

			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			CampBeanDAO service = new CampBeanDAO();
//			boolean n = service.deleteCamp(id);
//			if (n == 1) {
//				session.setAttribute("BookDeleteMsg", "書籍(" + id + ")刪除成功");
//			} else {
//				session.setAttribute("BookDeleteMsg", "書籍(" + id + ")刪除失敗");
//			}
//			response.sendRedirect("DisplayPageProducts");
//			
//			CampBean campData = (CampBean) request.getSession(true).getAttribute("dao");
			if (service.deleteCamp(id)) {
					session.setAttribute("CampDeleteMsg", "露營地編號(" + id + ")刪除成功");
					System.out.println("Get delete SQL commands done!");
				} else {
					session.setAttribute("CampDeleteMsg", "露營地編號(" + id + ")刪除失敗");
				}
				request.getSession(true).invalidate();
//				request.getRequestDispatcher("/Delete.jsp").forward(request, response);
				response.sendRedirect("Mfind");
			


//			String city = request.getParameter("city");
//			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);
//			request.getSession(true).setAttribute("list2", list2);
//			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);
			
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	
	public void ManagerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();
			
			
//			request.getSession(true).setAttribute("list2", list2);
//			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);


//			String city = request.getParameter("city");
//			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);
//			request.getSession(true).setAttribute("list2", list2);
//			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);
			
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	
	public void Updateconfirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();


//			String city = request.getParameter("city");
//			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);
//			request.getSession(true).setAttribute("list2", list2);
//			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);
			
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	
	public void ManagerConfirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/Oracle");
			conn = ds.getConnection();


//			String city = request.getParameter("city");
//			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			List<CampBean> list2 = campBeanDAO.getcampsByCity(city);
//			request.getSession(true).setAttribute("list2", list2);
//			request.getRequestDispatcher("/Mfind.jsp").forward(request, response);
			
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
			ne.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		} catch (NumberFormatException nbe) {
			nbe.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
}
