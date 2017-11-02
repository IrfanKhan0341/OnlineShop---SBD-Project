package shop.product;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DiscountCreator
 */
@WebServlet("/DiscountCreator")
public class DiscountCreator extends HttpServlet {
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
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String theCommand = request.getParameter("command");
			if(theCommand == null){
				theCommand = "LIST";
			}
			
			switch(theCommand){
			case "LIST":
				ListProducts(request, response);
				break;
			case "LOAD":
				loadProduct(request, response);
				break;
			case "UPDATE":
				updateProduct(request, response);
				break;
			default:
				ListProducts(request, response);
			}
			
			}
			catch (Exception e){
				throw new ServletException(e);
			}
	}
	

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String data = request.getParameter("productId");
		String ProductName = request.getParameter("ProductName");
		String data1 = request.getParameter("Amount");
		String data2 = request.getParameter("old_price");
		String data3 = request.getParameter("new_price");
		
		int id = Integer.parseInt(data);
		int Amount = Integer.parseInt(data1);
		double old_price = Double.parseDouble(data2);
		double new_price = Double.parseDouble(data3);
		
		Discount theProduct = new Discount(id, ProductName, Amount, old_price, new_price);
		
		discountDbUtil.updateDiscount(theProduct);
		
		ListProducts(request, response);
		
	}

	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theProductID = request.getParameter("productId");
		Discount theDiscount = discountDbUtil.getDiscount(theProductID);
		request.setAttribute("theDiscount", theDiscount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-discount-form.jsp");
		dispatcher.forward(request, response);
	}


	private void ListProducts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Discount> discounts = discountDbUtil.getDiscounts();
		request.setAttribute("DiscountList", discounts);
		RequestDispatcher dispacher = request.getRequestDispatcher("/Admin_DiscountCreator.jsp");
		dispacher.forward(request, response);
	}

}