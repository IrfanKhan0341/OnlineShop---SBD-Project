package shop.product;

import java.sql.*;
import java.util.*;
import javax.sql.*;

public class ProductsDbUtil {
	
	private DataSource dataSource;
	
	public ProductsDbUtil(DataSource theData) {
		
		dataSource = theData;
	}
	
	public List<Product> getProducts() throws Exception{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
		List<Product> products = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM produkt join sklad using(id_sklad)";
			stmt = conn.createStatement();
			
			result = stmt.executeQuery(sql);
			
			while(result.next()){
				
				int id = result.getInt("id_produkt");
				String name = result.getString("nazwa");
				String brand = result.getString("marka");
				String category = result.getString("kategoria");
				int sztuki = result.getInt("sztuki");
				double price = result.getInt("cena");
				int id_sklad = result.getInt("id_sklad");
				int ilosc = result.getInt("ilosc");
				int bialko = result.getInt("bialko");
				int tluszcz = result.getInt("tluszcze");
				int weglowodany = result.getInt("weglowodany");
				
				Product tempProduct = new Product(id, name, brand, category, sztuki, price, id_sklad, ilosc, bialko,
						tluszcz, weglowodany);
				
				products.add(tempProduct);
			}
			
			return products;
			
		}finally{
			conn.close();
			stmt.close();
			result.close();
		}
		
		
	}

	public void addProduct(Product theProduct) throws Exception {
		
		Connection conn1 = null;
		PreparedStatement pStmt1 = null;
		Connection conn2 = null;
		PreparedStatement pStmt2 = null;
		
		try{
			conn1 = dataSource.getConnection();
			conn2 = dataSource.getConnection();
			
			String sql1 = "insert into sklad (id_sklad, ilosc, bialko, tluszcze, weglowodany) values(?, ?, ?, ?, ?)";
			String sql2 = "insert into produkt (id_produkt, nazwa, marka, kategoria, sztuki, cena, id_sklad)"
					+" values(?, ?, ?, ?, ?,?,?)";
			
			pStmt1 = conn1.prepareStatement(sql1);
			pStmt2 = conn2.prepareStatement(sql2);
			
			pStmt1.setInt(1, theProduct.getId_sklad());
			pStmt1.setInt(2, theProduct.getIlosc());
			pStmt1.setInt(3, theProduct.getBialko());
			pStmt1.setInt(4, theProduct.getTluszcz());
			pStmt1.setInt(5, theProduct.getWeglowodany());
			
			pStmt2.setInt(1, theProduct.getId());
			pStmt2.setString(2, theProduct.getProductName());
			pStmt2.setString(3, theProduct.getBrand());
			pStmt2.setString(4, theProduct.getCategory());
			pStmt2.setInt(5, theProduct.getSztuki());
			pStmt2.setDouble(6, theProduct.getPrice());
			pStmt2.setInt(7, theProduct.getId_sklad());
			
			pStmt1.execute();
			pStmt2.execute();
			
		}finally{
			conn1.close();
			pStmt1.close();
			conn2.close();
			pStmt2.close();
			
		}
	}
	
	public Product getProduct(String theProductId) throws Exception {
	
		Product theProduct = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int ProductId;
		
		try {
			ProductId = Integer.parseInt(theProductId);
	
			myConn = dataSource.getConnection();
			
			String sql = "select * from produkt join sklad using (id_sklad) where id_sklad=?";
	
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, ProductId);
			
			myRs = myStmt.executeQuery();
			
			if (myRs.next()) {
				String productName = myRs.getString("nazwa");
				String Brand = myRs.getString("marka");
				String Category = myRs.getString("kategoria");
				int Amount = myRs.getInt("sztuki");
				double Price = myRs.getDouble("cena");
				int Ilosc = myRs.getInt("ilosc");
				int Bialko = myRs.getInt("bialko");
				int Tluszcz = myRs.getInt("tluszcze");
				int Weglowodany = myRs.getInt("weglowodany");
				int id_sklad = ProductId;
				
				// use the studentId during construction
				theProduct = new Product(ProductId, productName, Brand, Category, Amount, Price, id_sklad, Ilosc, Bialko, Tluszcz, Weglowodany);
			}
			else {
				throw new Exception("Could not find product id: " + ProductId);
			}				
			
			return theProduct;
		}
		finally {
			// clean up JDBC objects
			myConn.close();
			myStmt.close();
			myRs.close();
		}
	}
	
	public void updateProduct(Product theProduct) throws Exception {
		
		Connection myConn = null;
		Connection myConn1 = null;
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();
			myConn1 = dataSource.getConnection();
			
			// create SQL update statement
			String sql1 = "update produkt set id_produkt=?, nazwa=?, marka=?, kategoria=?, sztuki=?, cena=?, id_sklad=? where id_sklad=?";
			String sql2 = "update sklad set id_sklad=?, ilosc=?, bialko=?, tluszcze=?, weglowodany=? where id_sklad=?";
		
			// prepare statement
			myStmt = myConn.prepareStatement(sql1);
			myStmt1 = myConn.prepareStatement(sql2);
			
			// set params
			myStmt.setInt(1, theProduct.getId());
			myStmt.setString(2, theProduct.getProductName());
			myStmt.setString(3, theProduct.getBrand());
			myStmt.setString(4, theProduct.getCategory());
			myStmt.setInt(5, theProduct.getSztuki());
			myStmt.setDouble(6, theProduct.getPrice());
			myStmt.setInt(7, theProduct.getId_sklad());
			myStmt.setInt(8, theProduct.getId());
			
			myStmt1.setInt(1, theProduct.getId_sklad());
			myStmt1.setInt(2, theProduct.getIlosc());
			myStmt1.setInt(3, theProduct.getBialko());
			myStmt1.setInt(4, theProduct.getTluszcz());
			myStmt1.setInt(5, theProduct.getWeglowodany());
			myStmt1.setInt(6, theProduct.getId_sklad());
			
			// execute SQL statement
			myStmt.execute();
			myStmt1.execute();
		}
		finally {
			// clean up JDBC objects
			myConn.close();
			myStmt.close();
			myConn1.close();
			myStmt1.close();
		}
	}
	
	public void deleteProduct(int theProductId) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Connection myConn1 = null;
		PreparedStatement myStmt1 = null;
		
		try {
			myConn = dataSource.getConnection();
	
			String sql1 = "delete from produkt where id_produkt=?";
			String sql = "delete from sklad where id_sklad=?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt1 = myConn.prepareStatement(sql1);
			
			myStmt.setInt(1, theProductId);
			myStmt1.setInt(1, theProductId);
			
			myStmt1.execute();
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			myConn.close();
			myStmt.close();
			myConn1.close();
			myStmt1.close();
		}	
	}
}
