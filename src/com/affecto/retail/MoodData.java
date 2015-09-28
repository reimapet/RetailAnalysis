package com.affecto.retail;

public class MoodData {

	public long timestamp;
	
	public double happyMale;
	public double nothappyMale;
	public double happyFemale;
	public double nothappyFemale;
	
	public MoodData()
	{
		timestamp = 0;
		happyMale = 0;
		nothappyMale = 0;
		happyFemale = 0;
		nothappyFemale = 0;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getHappyMale() {
		return happyMale;
	}
	public void setHappyMale(double happyMale) {
		this.happyMale = happyMale;
	}
	public double getNothappyMale() {
		return nothappyMale;
	}
	public void setNothappyMale(double nothappyMale) {
		this.nothappyMale = nothappyMale;
	}
	public double getHappyFemale() {
		return happyFemale;
	}
	public void setHappyFemale(double happyFemale) {
		this.happyFemale = happyFemale;
	}
	public double getNothappyFemale() {
		return nothappyFemale;
	}
	public void setNothappyFemale(double nothappyFemale) {
		this.nothappyFemale = nothappyFemale;
	}
	
	/**
	 * Converts the object to JSON
	 * @return
	 */
	public String toJSON()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("{");
		sb.append( "\"timestamp\" :");
		sb.append( "\""+ this.timestamp + "\",");
		sb.append( "\"happyMale\" :");
		sb.append( "\""+this.happyMale+ "\",");
		sb.append( "\"nothappyMale\" :");
		sb.append( "\""+this.nothappyMale + "\",");
		sb.append( "\"happyFemale\" :");
		sb.append( "\""+this.happyFemale + "\",");
		sb.append( "\"nothappyFemale\" :");
		sb.append( "\""+this.nothappyFemale + "\"");
		sb.append("}");
		return sb.toString();
	}
}
