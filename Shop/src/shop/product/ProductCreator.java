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
 * Servlet implementation class ProductCreator
 */
@WebServlet("/ProductCreator")
public class ProductCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductsDbUtil productsDbUtil;
	@Resource(name="jdbc/sklep")
	private DataSource  dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			productsDbUtil = new ProductsDbUtil(dataSource);
			
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
			case "ADD":
				addProduct(request, response);
				break;
			case "LOAD":
				loadProduct(request, response);
				break;
			case "UPDATE":
				updateProduct(request, response);
				break;
			case "DELETE":
				deleteProduct(request, response);
				break;
			default:
				ListProducts(request, response);
			}
			
			}
			catch (Exception e){
				throw new ServletException(e);
			}
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String data = request.getParameter("p");
		int id = Integer.parseInt(data);
		productsDbUtil.deleteProduct(id);
		
		ListProducts(request, response);
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String data = request.getParameter("productId");
		String ProductName = request.getParameter("ProductName");
		String Brand = request.getParameter("Brand");
		String Category = request.getParameter("Category");
		String data1 = request.getParameter("Amount");
		String data2 = request.getParameter("Price");
		
		String data3= request.getParameter("Ilosc");
		String data4 = request.getParameter("Bialko");
		String data5 = request.getParameter("Tluszcze");
		String data6 = request.getParameter("Weglowodany");
		
		int id = Integer.parseInt(data);
		int Amount = Integer.parseInt(data1);
		double Price = Double.parseDouble(data2);
		int Ilosc = Integer.parseInt(data3);
		int Bialko = Integer.parseInt(data4);
		int Tluszcze = Integer.parseInt(data5);
		int Weglowodany = Integer.parseInt(data6);
		int id_sklad = id;
		
		Product theProduct = new Product(id, ProductName, Brand, Category, Amount, Price, id_sklad, Ilosc, Bialko, Tluszcze, Weglowodany);
		
		productsDbUtil.updateProduct(theProduct);
		
		ListProducts(request, response);
		
	}

	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theProductID = request.getParameter("productId");
		Product theProduct = productsDbUtil.getProduct(theProductID);
		request.setAttribute("theProduct", theProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-product-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> products = productsDbUtil.getProducts();
		
		int id= products.size()+1;
		String ProductName = request.getParameter("ProductName");
		String Brand = request.getParameter("Brand");
		String Category = request.getParameter("Category");
		String data1 = request.getParameter("Amount");
		String data2 = request.getParameter("Price");
		
		int id_sklad = products.size()+1;
		String data3= request.getParameter("Ilosc");
		String data4 = request.getParameter("Bialko");
		String data5 = request.getParameter("Tluszcze");
		String data6 = request.getParameter("Weglowodany");
		
		int Amount = Integer.parseInt(data1);
		double Price = Double.parseDouble(data2);
		int Ilosc = Integer.parseInt(data3);
		int Bialko = Integer.parseInt(data4);
		int Tluszcze = Integer.parseInt(data5);
		int Weglowodany = Integer.parseInt(data6);
		
		Product theProduct = new Product(id, ProductName, Brand, Category, Amount, Price, id_sklad, Ilosc, Bialko, Tluszcze, Weglowodany);
		
		productsDbUtil.addProduct(theProduct);
		
		ListProducts(request, response);
	}

	private void ListProducts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Product> products = productsDbUtil.getProducts();
		request.setAttribute("ProductList", products);
		RequestDispatcher dispacher = request.getRequestDispatcher("/Admin_ProductCreator.jsp");
		dispacher.forward(request, response);
	}

}
