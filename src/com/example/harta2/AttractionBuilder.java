package com.example.harta2;
import com.example.harta2.Attraction;

import interfete.IAttractionBuilder;

public class AttractionBuilder implements IAttractionBuilder {

	private String denumire;
	private String descriere;
	private float lat;
	private float lng;
	private int vechime;
	private int popular;// 1 = popular; 0 = nepopular

	// set-eri pentru Builder
	public AttractionBuilder(){
		
	}
	public AttractionBuilder setDenumire(String denumire) {
		this.denumire = denumire;
		return this;
	}
	public AttractionBuilder setDescriere(String descriere) {
		this.descriere = descriere;
		return this;
	}
	public AttractionBuilder setLat(float lat) {
		this.lat = lat;
		return this;
	}
	public AttractionBuilder setLng(float lng) {
		this.lng = lng;
		return this;
	}
	public AttractionBuilder setVechime(int vechime) {
		this.vechime = vechime;
		return this;
	}
	public AttractionBuilder setPopular(int popular) {
		this.popular = popular;
		return this;
	}
	@Override
	public Attraction build() throws Exception{
		return new Attraction(denumire, descriere, lat, lng, vechime, popular);
	}
}
