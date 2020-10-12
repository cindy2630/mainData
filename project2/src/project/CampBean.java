package project;



public class CampBean {
	int id;
	String name;
	String city;
	String adress;
	String tel;
	int oprice;
	int wprice;
	int tentnum;
	String elevation;
	String feature;
	String facility;
	String pet;
	String service;
	String parking;
	
	

	
	public CampBean() {
	}


public CampBean (int cId,String cName,String cCity,String cAdress,
		String cTel,int cOprice,int cWprice,int cTentnum,String cElevation,String cFeature,String cFacility,
		String cPet,String cService,String cParking){
	
	this.id=cId;
	this.name=cName;
	this.city=cCity;
	this.adress=cAdress;
	this.tel=cTel;
	this.oprice=cOprice;
	this.wprice=cWprice;
	this.tentnum=cTentnum;
	this.elevation=cElevation;
	this.feature=cFeature;
	this.facility=cFacility;
	this.pet=cPet;
	this.service=cService;
	this.parking=cParking;
}

public int getId() {
	return id;
}

public void setId(int cId) {
	this.id = cId;
}


public String getCity() {
	return city;
}

public void setCity(String cCity) {
	this.city = cCity;
}
public String getName() {
	return name;
}

public void setName(String cName) {
	this.name = cName;
}

public String getAdress() {
	return adress;
}

public void setAdress(String cAdress) {
	this.adress = cAdress;
}

public String getTel() {
	return tel;
}

public void setTel(String cTel) {
	this.tel = cTel;
}

public int getOprice() {
	return oprice;
}

public void setOprice(int cOprice) {
	this.oprice = cOprice;
}

public int getWprice() {
	return wprice;
}

public void setWprice(int cWprice) {
	this.wprice = cWprice;
}

public int getTentnum() {
	return tentnum;
}

public void setTentnum(int cTentnum) {
	this.tentnum = cTentnum;
}

public String getElevation() {
	return elevation;
}

public void setElevation(String cElevation) {
	this.elevation = cElevation;
}

public String getFeature() {
	return feature;
}

public void setFeature(String cFeature) {
	this.feature = cFeature;
}

public String getFacility() {
	return facility;
}

public void setFacility(String cFacility) {
	this.facility = cFacility;
}

public String getPet() {
	return pet;
}

public void setPet(String cPet) {
	this.pet = cPet;
}

public String getService() {
	return service;
}

public void setService(String cService) {
	this.service = cService;
}

public String getParking() {
	return parking;
}

public void setParking(String cParking) {
	this.parking = cParking;
}



}