package project2;

import java.io.Serializable;
import java.math.BigDecimal;

public class Camping implements Serializable{
	
	private int id;
	private String name;
	private String city;
	private String adress;
	private String tel;
	private BigDecimal oprice;
	private BigDecimal wprice;
	private int tentnum;
	private String elevation;
	private String feature;
	private String facility;
	private String pet;
	private String service;
	private String parking;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public BigDecimal getOprice() {
		return oprice;
	}
	
	public void setOprice(BigDecimal oprice) {
		this.oprice = oprice;
	}
	
	public BigDecimal getWprice() {
		return wprice;
	}
	
	public void setWprice(BigDecimal wprice) {
		this.wprice = wprice;
	}
	
	public int getTentnum() {
		return tentnum;
	}
	
	public void setTentnum(int tentnum) {
		this.tentnum = tentnum;
	}
	
	public String getElevation() {
		return elevation;
	}
	
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	
	public String getFeature() {
		return feature;
	}
	
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	public String getFacility() {
		return facility;
	}
	
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	public String getPet() {
		return pet;
	}
	
	public void setPet(String pet) {
		this.pet = pet;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public String getParking() {
		return parking;
	}
	
	public void setParking(String parking) {
		this.parking = parking;
	}

	public void setOprice(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setWprice(int int1) {
		// TODO Auto-generated method stub
		
	}

}

