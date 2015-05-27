package com.example.harta2;

public class City {
	private String denumire;
	private String descriere;
	public City(){
		
	}
	public City(String denumire, String descriere) throws Exception {
		super();
		if (denumire != null){
			this.denumire = denumire;
		} else throw new Exception("Denumirea e null");
		
		
		if (descriere != null){
			this.descriere = descriere;
		} else throw new Exception("Descrierea e null");
	}
	public City(String den) {
		this.denumire = den;
	}
	public String getDenumire() {
		return denumire;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDenumire(String denumire) throws Exception {
		if (denumire!=null){
			this.denumire=denumire;
		}
		else throw new Exception("Null sau Nimic");
	}
	public void setDescriere(String descriere) throws Exception {
		if (descriere!=null){
			this.descriere=descriere;
		}
		else throw new Exception("Descriere vida");
	}
}
