package shop.product;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DiscountDbUtil discountDbUtil;
       
	private ProductsDbUtil productDbUtil;
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
		
		
		Integer licznik = 0;
		HttpSession sesja = request.getSession();
		sesja.setAttribute("licznik", licznik);
		sesja.removeAttribute("login");
		
		try{
			
			listDiscount(request, response);
			
		}catch (Exception e){
				throw new ServletException(e);
			}
	}
				


	private void listDiscount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<Discount> discounts = discountDbUtil.getDiscounts();
		request.setAttribute("DiscountList", discounts);
		RequestDispatcher dispacher = request.getRequestDispatcher("/Main.jsp");
		dispacher.forward(request, response);
	}
	
}