package shop.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class MainServletLog
 */
@WebServlet("/MainServletLog")
public class MainServletLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DiscountDbUtil discountDbUtil;
	@Resource(name="jdbc/sklep")
	private DataSource  dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			discountDbUtil = new DiscountDbUtil(dataSource);
			
		}
		catch (Exception e){
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			log(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void log(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession sesja = request.getSession();
		Integer licznik = 0;
		sesja.setAttribute("licznik", licznik);
		
		Object data = sesja.getAttribute("login");
		String result = String.valueOf(data);
		if(result.equals("null")){
			
			String login = request.getParameter("login");
			String haslo = request.getParameter("haslo");
			
			if(login.equals("admin") && haslo.equals("admin")){
				AdminPanel(request, response);
			}else {
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				try{
					conn = dataSource.getConnection();
					String sql = "CALL `sklep`.`check`(?, ?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, login);
					stmt.setString(2, haslo);
					rs = stmt.executeQuery();
					if(rs.next()){
						String wynik = rs.getString("Wynik");
						if(wynik.equals("true")){
							sesja.setAttribute("login", login);
							sesja.setAttribute("licznik", 0);
							listDiscountLog(request, response);
						}else listDiscount(request, response);
					}
				}
					
				finally{
					conn.close();
					stmt.close();
					rs.close();
				}
			}
		
		}else listDiscountLog(request, response);
	}
			
	private void listDiscount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<Discount> discounts = discountDbUtil.getDiscounts();
		request.setAttribute("DiscountList", discounts);
		RequestDispatcher dispacher = request.getRequestDispatcher("/Main.jsp");
		dispacher.forward(request, response);
	}
	
	private void listDiscountLog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<Discount> discounts = discountDbUtil.getDiscounts();
		request.setAttribute("DiscountList", discounts);
		RequestDispatcher dispacher = request.getRequestDispatcher("/MainLog.jsp");
		dispacher.forward(request, response);
	}
	private void AdminPanel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/Admin_Main.jsp");
		dispacher.forward(request, response);
	}
}

