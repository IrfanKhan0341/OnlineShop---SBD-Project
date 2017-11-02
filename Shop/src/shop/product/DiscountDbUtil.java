package shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DiscountDbUtil {

	
	private DataSource dataSource;
	
	public DiscountDbUtil(DataSource theData) {
		
		dataSource = theData;
	}
	
	public List<Discount> getDiscounts() throws Exception{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
		List<Discount> discounts = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM promocja";
			stmt = conn.createStatement();
			
			result = stmt.executeQuery(sql);
			
			while(result.next()){
				
				int id = result.getInt("id");
				String name = result.getString("nazwa");
				int ilosc = result.getInt("ilosc");
				Double stara_cena = result.getDouble("stara_cena");
				Double nowa_cena = result.getDouble("nowa_cena");
				
				Discount tempDiscount = new Discount(id, name, ilosc, stara_cena, nowa_cena);
				
				discounts.add(tempDiscount);
			}
			
			return discounts;
			
		}finally{
			conn.close();
			stmt.close();
			result.close();
		}
		
		
	}
	
	public Discount getDiscount(String theProductId) throws Exception {
		
		Discount theDiscount = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int ProductId;
		
		try {
			int DiscountId = Integer.parseInt(theProductId);
	
			myConn = dataSource.getConnection();
			
			String sql = "select * from promocja where id=?";
	
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, DiscountId);
			
			myRs = myStmt.executeQuery();
			
			if (myRs.next()) {
				String Name = myRs.getString("nazwa");
				int Amount = myRs.getInt("ilosc");
				Double old_price = myRs.getDouble("stara_cena");
				double new_price = myRs.getDouble("nowa_cena");
				int id = DiscountId;
				
				// use the studentId during construction
				theDiscount = new Discount(id, Name, Amount, old_price, new_price);
			}
			else {
				throw new Exception("Could not find product id: " + DiscountId);
			}				
			
			return theDiscount;
		}
		finally {
			// clean up JDBC objects
			myConn.close();
			myStmt.close();
			myRs.close();
		}
	}
	
public void updateDiscount(Discount theDiscount) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update promocja set nazwa=?, ilosc=?, stara_cena=?, nowa_cena=? where id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theDiscount.getNazwa());
			myStmt.setInt(2, theDiscount.getIlosc());
			myStmt.setDouble(3, theDiscount.getStara_cena());
			myStmt.setDouble(4, theDiscount.getNowa_cena());
			myStmt.setInt(5, theDiscount.getId());

			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			myConn.close();
			myStmt.close();
		}
	}
}
