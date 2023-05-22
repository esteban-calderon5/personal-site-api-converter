package com.juancalderon.apirate.models;


public class RateInterest {
	
	private Double rate;
	
	private String annuity;
	
	private int periods;
	
	private String annuityToGo;
	
	private int periodsToGo;
	
	

	public RateInterest(Double rate,String annuity, int periods, String annuityToGo, 
			int periodsToGo) {
		this.rate = rate;
		this.annuity = annuity;
		this.periods = periods;
		this.annuityToGo = annuityToGo;
		this.periodsToGo = periodsToGo;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getAnnuity() {
		return annuity;
	}

	public void setAnnuity(String annuity) {
		this.annuity = annuity;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public String getAnnuityToGo() {
		return annuityToGo;
	}

	public void setAnnuityToGo(String annuityToGo) {
		this.annuityToGo = annuityToGo;
	}

	public int getPeriodsToGo() {
		return periodsToGo;
	}

	public void setPeriodsToGo(int periodsToGo) {
		this.periodsToGo = periodsToGo;
	}
}
