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
@WebServlet("/ProductListBeginLog")
public class ProductListBeginLog extends HttpServlet {
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
		sesja.setAttribute("licznik", 1);
		List<Product> products = productDbUtil.getProducts();
		
		Integer size=null;
		if((products.size()%3) == 0){
			size = products.size()/3;
		}else if ( ((products.size()%3) == 1) || ((products.size()%3) == 2)) {
			size = products.size()/3+1;
		}
		
		request.setAttribute("ProductList", products);
		request.setAttribute("start", 0);
		request.setAttribute("end", 3);
		request.setAttribute("size", size);
		RequestDispatcher dispacher = request.getRequestDispatcher("/ProduktyLog.jsp");
		dispacher.forward(request, response);
	}

}
