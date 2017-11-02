// klasa dla danych promocyjnych

package shop.product;

public class Discount {

	private int id;
	private String nazwa;
	private int ilosc;
	private double stara_cena;
	private double nowa_cena;
	
	public Discount(int id, String nazwa, int ilosc, double stara_cena, double nowa_cena) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.ilosc = ilosc;
		this.stara_cena = stara_cena;
		this.nowa_cena = nowa_cena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public double getStara_cena() {
		return stara_cena;
	}

	public void setStara_cena(double stara_cena) {
		this.stara_cena = stara_cena;
	}

	public double getNowa_cena() {
		return nowa_cena;
	}

	public void setNowa_cena(double nowa_cena) {
		this.nowa_cena = nowa_cena;
	}
	
	
	
	
}
