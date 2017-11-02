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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductControllerLog")
public class ProductControllerLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductsDbUtil productDbUtil;
	@Resource(name="jdbc/sklep")
	private DataSource  dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			productDbUtil = new ProductsDbUtil(dataSource);
			
		}
		catch (Exception e){
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			listProducts(request, response);
		}
		catch (Exception e){
			throw new ServletException(e);
		}
	}
	
	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession sesja = request.getSession(); 
		Integer Licznik = (Integer)sesja.getAttribute("licznik");
		
		Integer start = null, end = null, size=null;
		List<Product> products = productDbUtil.getProducts();
		
		if((products.size()%3) == 0){
			size = products.size()/3;
		}else if ( ((products.size()%3) == 1) || ((products.size()%3) == 2)) {
			size = products.size()/3+1;
		}
		
		if((products.size() - 3*Licznik) >2){
			Licznik++;
			sesja.setAttribute("licznik", Licznik);
			start = 3*Licznik-3;
			end = 3*Licznik;
			}
		else if((products.size() - 3*Licznik) <=2 && (products.size() - 3*Licznik) >0){
			start = 3*Licznik;
			end = products.size();
		}else if((products.size() - 3*Licznik) ==0){
			start = 0;
			end = 3;
			sesja.setAttribute("licznik", 1);
		}
		else if((products.size() ==0)) {
			start = 0;
			end = 0;
		}
		request.setAttribute("ProductList", products);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("size", size);
		RequestDispatcher dispacher = request.getRequestDispatcher("/ProduktyLog.jsp");
		dispacher.forward(request, response);
	}

}
