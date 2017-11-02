package shop.product;

import java.sql.*;
import java.util.*;
import javax.sql.*;

public class UsersDbUtil {
	
	private DataSource dataSource;
	
	public UsersDbUtil(DataSource theData) {
		
		dataSource = theData;
	}

	public List<User> getUsers() throws Exception{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn2 = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		List<User> users = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM logowanie join uzytkownik using(login)";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			conn2 = dataSource.getConnection();
			String sql2 = "SELECT * FROM uzytkownik join adres using(id_adres)";
			stmt2 = conn2.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			
			while(rs.next() && rs2.next()){
				String login = rs.getString("login");
				String haslo = rs.getString("haslo");
				int user_id = rs.getInt("id");
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				String nr_tel = rs.getString("nr_telefonu");
				String email = rs.getString("email");
				String id_log = login;
				int id_adres = rs2.getInt("id_adres");
				String nazwa_ulicy = rs2.getString("nazwa_ulicy");
				int nr_domu = rs2.getInt("nr_domu");
				int nr_mieszkania = rs2.getInt("nr_mieszkania");
				String kod_pocztowy = rs2.getString("kod_pocztowy");
				String miasto = rs2.getString("miasto");
				
				User tempUser = new User(login, haslo, user_id, imie, nazwisko, nr_tel, email, id_log, id_adres, nazwa_ulicy, nr_domu,
						nr_mieszkania, kod_pocztowy, miasto);
				
				users.add(tempUser);
			}
			return users;
			
		}finally{
			conn.close();
			stmt.close();
			rs.close();
			
			conn2.close();
			stmt2.close();
			rs2.close();
			
			
		}
	}

	public void addUser(User theUser) throws Exception {
		
		Connection conn1 = null;
		PreparedStatement pStmt1 = null;
		Connection conn2 = null;
		PreparedStatement pStmt2 = null;
		Connection conn3 = null;
		PreparedStatement pStmt3 = null;
		
		try{
			conn1 = dataSource.getConnection();
			conn2 = dataSource.getConnection();
			conn3 = dataSource.getConnection();
			
			String sql1 = "insert into uzytkownik (id, imie, nazwisko, nr_telefonu, email, login, id_adres)" +" values(?, ?, ?, ?, ?,?,?)";
			String sql2 = "insert into adres (id_adres, nazwa_ulicy, nr_domu, nr_mieszkania, kod_pocztowy, miasto)" +" values(?, ?, ?, ?, ?,?)";
			String sql3 = "insert into logowanie (login, haslo) values(?, ?)";
			
			pStmt1 = conn1.prepareStatement(sql1);
			pStmt2 = conn2.prepareStatement(sql2);
			pStmt3 = conn3.prepareStatement(sql3);
			
			pStmt3.setString(1, theUser.getId_log());
			pStmt3.setString(2, theUser.getHaslo());
			
			pStmt2.setInt(1, theUser.getId_adres());
			pStmt2.setString(2, theUser.getNazwa_ulicy());
			pStmt2.setInt(3, theUser.getNr_domu());
			pStmt2.setInt(4, theUser.getNr_mieszkania());
			pStmt2.setString(5, theUser.getKod_pocztowy());
			pStmt2.setString(6, theUser.getMiasto());
			
			pStmt1.setInt(1, theUser.getUser_id());
			pStmt1.setString(2, theUser.getImie());
			pStmt1.setString(3, theUser.getNazwisko());
			pStmt1.setString(4, theUser.getNr_tel());
			pStmt1.setString(5, theUser.getEmail());
			pStmt1.setString(6, theUser.getId_log());
			pStmt1.setInt(7, theUser.getId_adres());
			
			pStmt3.execute();
			pStmt2.execute();
			pStmt1.execute();
			
			
		}finally{
			conn1.close();
			pStmt1.close();
			conn2.close();
			pStmt2.close();
			conn3.close();
			pStmt3.close();
			
		}
	}
	/*
	public Product getProduct(String theUserId) throws Exception {
	
		User tempUser = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		int UserId;
		
		try {
			UserId = Integer.parseInt(theUserId);
	
			conn = dataSource.getConnection();
			
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
	*/
}
