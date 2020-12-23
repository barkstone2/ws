package db;

public class HumanDTO {
	private String aptId;
	private String security;
	private String light;
	private String airConditioner;
	private String television;
	private String cucu;
	
	public HumanDTO(String aptId, String security, String light, String airConditioner, String television, String cucu) {
		this.aptId = aptId;
		this.security = security;
		this.light = light;
		this.airConditioner = airConditioner;
		this.television = television;
		this.cucu = cucu;
	}

	public HumanDTO() {
	}

	public String getAptId() {
		return aptId;
	}

	public void setAptId(String aptId) {
		this.aptId = aptId;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}

	public String getTelevision() {
		return television;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public String getCucu() {
		return cucu;
	}

	public void setCucu(String cucu) {
		this.cucu = cucu;
	}

	
	
}
