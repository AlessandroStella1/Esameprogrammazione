package it.univpm.ProgOggettiUnivpm.models;

public class StatPeriodTempResponse extends StatPeriodResponse {

	private float temperatureMin;
	private float temperatureMax;
	private float temperatureVar;
	private float temperatureReal;
	private float temperaturePerceived;

	public float getTemperatureMin() {
		return temperatureMin;
	}
	
	public void setTemperatureMin(float temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	
	public float getTemperatureMax() {
		return temperatureMax;
	}
	
	public void setTemperatureMax(float temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	
	public float getTemperatureVar() {
		return temperatureVar;
	}
	
	public void setTemperatureVar(float temperatureVar) {
		this.temperatureVar = temperatureVar;
	}
	
	public float getTemperatureReal() {
		return temperatureReal;
	}
	
	public void setTemperatureReal(float temperatureReal) {
		this.temperatureReal = temperatureReal;
	}
	
	public float getTemperaturePerceived() {
		return temperaturePerceived;
	}
	
	public void setTemperaturePerceived(float temperaturePerceived) {
		this.temperaturePerceived = temperaturePerceived;
	}

}
