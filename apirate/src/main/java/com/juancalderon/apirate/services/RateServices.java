package com.juancalderon.apirate.services;

import org.springframework.stereotype.Service;

import com.juancalderon.apirate.models.RateInterest;

@Service
public class RateServices {
	
	/**
	 * Allows to make a convert of interest rate, depending on the user request
	 * @param rate object containing the user request for convert rate
	 * @return Double with the converted rate
	 */
	public double transformRate(RateInterest rate) {
		//defining some variables to be used ahead during convert
		String annuityStart = rate.getAnnuity();
		String annuityToGo = rate.getAnnuityToGo();
		Double periods = rate.getPeriods()*1.0;
		Double periodsToGo = rate.getPeriodsToGo()* 1.0;
		Double periodRate = 0.0;
		Double effectiveRate = 0.0;
		Double currRate = rate.getRate()/100.0;
		//values needed for convert
		if (annuityStart.equals(annuityToGo)) {
			return currRate;
		}
		if (annuityStart.contains("EA")) {
			periodRate = Math.pow(1+currRate , 1/periodsToGo)-1;
		}
		if (annuityStart.contains("N")) {
			periodRate = currRate /periods;
			effectiveRate = Math.pow(1+periodRate, periods) - 1;
		}
		if (annuityStart.contains("PV")) {
			periodRate = currRate ;
			effectiveRate = Math.pow(1+periodRate, periods) - 1;
		}
		
		//According to the request the rate is changed.
		if (annuityToGo.equals("EA")) {
			return effectiveRate;
		}else if(annuityToGo.equals("N")) {
			return periodRate * periodsToGo;
		}else {
			return periodRate;
			//return periodRate;
		}

		
	}
}
