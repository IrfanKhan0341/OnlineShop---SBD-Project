package shop.product;

public class Product {
	
	private int id;
	private String productName;
	private String brand;
	private String category;
	private int sztuki;
	private double price;
	private int id_sklad;
	private int ilosc;
	private int bialko;
	private int tluszcz;
	private int weglowodany;
	
	
	public Product(int id, String productName, String brand, String category, int sztuki, double price, int id_sklad,
			int ilosc, int bialko, int tluszcz, int weglowodany) {
		this.id = id;
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.sztuki = sztuki;
		this.price = price;
		this.id_sklad = id_sklad;
		this.ilosc = ilosc;
		this.bialko = bialko;
		this.weglowodany = weglowodany;
		this.tluszcz = tluszcz;
	}
	
	public Product(String productName, String brand, String category, int sztuki, double price, int ilosc, int bialko,
			int weglowodany, int tluszcz) {
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.sztuki = sztuki;
		this.price = price;
		this.ilosc = ilosc;
		this.bialko = bialko;
		this.weglowodany = weglowodany;
		this.tluszcz = tluszcz;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getSztuki() {
		return sztuki;
	}


	public void setSztuki(int sztuki) {
		this.sztuki = sztuki;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getId_sklad() {
		return id_sklad;
	}


	public void setId_sklad(int id_sklad) {
		this.id_sklad = id_sklad;
	}


	public int getIlosc() {
		return ilosc;
	}


	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}


	public int getBialko() {
		return bialko;
	}


	public void setBialko(int bialko) {
		this.bialko = bialko;
	}


	public int getWeglowodany() {
		return weglowodany;
	}


	public void setWeglowodany(int weglowodany) {
		this.weglowodany = weglowodany;
	}


	public int getTluszcz() {
		return tluszcz;
	}


	public void setTluszcz(int tluszcz) {
		this.tluszcz = tluszcz;
	}
	
	
	
}
	
		
	