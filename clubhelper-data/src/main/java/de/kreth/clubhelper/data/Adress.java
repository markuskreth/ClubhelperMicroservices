package de.kreth.clubhelper.data;

import java.io.Serializable;

/**
 * The persistent class for the adress database table.
 * 
 */
public class Adress extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8216273166570667412L;

    private String adress1;

    private String adress2;

    private String city;

    private String plz;

    public String getAdress1() {
	return adress1;
    }

    public void setAdress1(String adress1) {
	this.adress1 = adress1;
    }

    public String getAdress2() {
	return adress2;
    }

    public void setAdress2(String adress2) {
	this.adress2 = adress2;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getPlz() {
	return plz;
    }

    public void setPlz(String plz) {
	this.plz = plz;
    }

    @Override
    public String toString() {
	return "Adress [adress1=" + adress1 + ", adress2=" + adress2 + ", plz=" + plz + ", city=" + city + "]";
    }

}
