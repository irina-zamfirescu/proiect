package com.example.harta2;

import android.location.Location;
import interfete.IAttractionBuilder;

public class Attraction{
	private String denumire;
	private String descriere;
	private float lat;
	private float lng;
	private int vechime;
	private int popular;//1 = popular; 0 = nepopular
	Location loc;

	public Attraction(String denumire, String descriere) {
		super();
		this.denumire = denumire;
		this.descriere = descriere;
	}
	public Attraction(){
		
	}
	public Attraction(String denumire, String descriere, float lat, float lng,
			int vechime, int popular) throws Exception{
		super();
		if (denumire != null){
			this.denumire = denumire;
		} else throw new Exception("Denumirea e null");
		
		
		if (descriere != null){
			this.descriere = descriere;
		} else throw new Exception("Descrierea e null");
		
		if (lat>0 && lat<91){
			this.lat = lat;
		} else throw new Exception("Incorect setat.");
		if (lng>0 && lng<91){
			this.lng = lng;
		} else throw new Exception("Incorect setat.");
		if (vechime!=0){
			this.vechime = vechime;
		} else throw new Exception("Incorect setat.");
		if (popular==0 || popular==1){
			this.popular = popular;
		} else throw new Exception("Incorect setat.");
	}
	
	public Attraction(String denumire) throws Exception{
		if (denumire != null){
		this.denumire = denumire;
		} else throw new Exception("Denumirea e null");
	}
	
	public Attraction(int vechime) throws Exception {
		if (vechime > 0){
			this.vechime = vechime;
		} else throw new Exception("Incorect definita");
	}
	public void setDenumire(String denumire) throws Exception {
		if (denumire!=null){
			this.denumire=denumire;
		}
		else throw new Exception("Null sau Nimic");
	}
	public void setLat(float lat) throws Exception {
		if (lat>0 && lat<91){
			this.lat=lat;
		}
		else throw new Exception("Incorect setat");
	}
	public void setLng(float lng) throws Exception {
		if (lng>0 && lng<181){
			this.lng=lng;
		}
		else throw new Exception("Incorect setat");
	}
	public void setDescriere(String descriere) throws Exception {
		if (descriere!=null){
			this.descriere=descriere;
		}
		else throw new Exception("Descriere vida");
	}
	public void setVechime(int vechime) throws Exception {
		if (vechime!=0){
			this.vechime=vechime;
		}
		else throw new Exception("Incorect setat");
	}
	public void setPopular(int popular) throws Exception {
		if (popular==0 || popular==1){
			this.popular=popular;
		}
		else throw new Exception("Incorect setat");
	}
	public float getLat() {
		return lat;
	}
	public float getLng() {
		return lng;
	}
	public String getDenumire() {
		return denumire;
	}
	public String getDescriere() {
		return descriere;
	}
	public Location getLoc() {
		return loc;
	}
	public int getVechime() {
		return vechime;
	}
	public int getPopular() {
		return popular;
	}
	public void setLoc(Location loc) throws Exception {
		if (loc.getLatitude()<90 || loc.getLongitude()<180){
		this.loc = loc;
		}
		else throw new Exception("Coordonate setate incorect");
	}
	public boolean checkCoordinates(){
		if (loc.getLatitude()>90 || loc.getLongitude()>180){
			return false;
		}else return true;
	}
}
