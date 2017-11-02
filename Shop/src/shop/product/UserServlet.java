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
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersDbUtil userDbUtil;
	@Resource(name="jdbc/sklep")
	private DataSource  dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			userDbUtil = new UsersDbUtil(dataSource);
			
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				try {
					addUser(request, response);
				} catch (Exception e) {
					throw new ServletException(e);
				}
	}


/*	
private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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

	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theProductID = request.getParameter("productId");
		Product theProduct = productsDbUtil.getProduct(theProductID);
		request.setAttribute("theProduct", theProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-product-form.jsp");
		dispatcher.forward(request, response);
	}
*/
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = 0;
		List<User> users = userDbUtil.getUsers();
		
		String login = request.getParameter("Login");
		String haslo = request.getParameter("Haslo");
		
		id= users.size()+1;
		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("Nazwisko");
		String nr_tel = request.getParameter("Tel");
		String email = request.getParameter("Email");
		
		String nazwa_ulicy= request.getParameter("Ulica");
		int nr_domu = Integer.parseInt(request.getParameter("Nr_domu"));
		int nr_mieszkania = Integer.parseInt(request.getParameter("Nr_mieszkania"));
		String post_code = request.getParameter("Post_code");
		String city = request.getParameter("City");
		
		User tempUser = new User(login, haslo, id, imie, nazwisko, nr_tel, email, login, id, nazwa_ulicy, nr_domu, nr_mieszkania,
				post_code, city);
		
		userDbUtil.addUser(tempUser);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/MainServlet");
		dispacher.forward(request, response);
	}
}