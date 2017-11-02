package shop.product;

public class User {

	private String login;
	private String haslo;
	private int user_id;
	private String Imie;
	private String Nazwisko;
	private String nr_tel;
	private String email;
	private String id_log;
	private int id_adres;
	private String nazwa_ulicy;
	private int nr_domu;
	private int nr_mieszkania;
	private String kod_pocztowy;
	private String miasto;
	
	public User(String login, String haslo, int user_id, String imie, String nazwisko, String nr_tel, String email,
			String id_log, int id_adres, String nazwa_ulicy, int nr_domu, int nr_mieszkania, String kod_pocztowy,
			String miasto) {
		this.login = login;
		this.haslo = haslo;
		this.user_id = user_id;
		this.Imie = imie;
		this.Nazwisko = nazwisko;
		this.nr_tel = nr_tel;
		this.email = email;
		this.id_log = id_log;
		this.id_adres = id_adres;
		this.nazwa_ulicy = nazwa_ulicy;
		this.nr_domu = nr_domu;
		this.nr_mieszkania = nr_mieszkania;
		this.kod_pocztowy = kod_pocztowy;
		this.miasto = miasto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		Imie = imie;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}

	public String getNr_tel() {
		return nr_tel;
	}

	public void setNr_tel(String nr_tel) {
		this.nr_tel = nr_tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId_log() {
		return id_log;
	}

	public void setId_log(String id_log) {
		this.id_log = id_log;
	}

	public int getId_adres() {
		return id_adres;
	}

	public void setId_adres(int id_adres) {
		this.id_adres = id_adres;
	}

	public String getNazwa_ulicy() {
		return nazwa_ulicy;
	}

	public void setNazwa_ulicy(String nazwa_ulicy) {
		this.nazwa_ulicy = nazwa_ulicy;
	}

	public int getNr_domu() {
		return nr_domu;
	}

	public void setNr_domu(int nr_domu) {
		this.nr_domu = nr_domu;
	}

	public int getNr_mieszkania() {
		return nr_mieszkania;
	}

	public void setNr_mieszkania(int nr_mieszkania) {
		this.nr_mieszkania = nr_mieszkania;
	}

	public String getKod_pocztowy() {
		return kod_pocztowy;
	}

	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
	
}
