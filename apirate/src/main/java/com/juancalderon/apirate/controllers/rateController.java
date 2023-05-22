package com.juancalderon.apirate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juancalderon.apirate.models.RateInterest;
import com.juancalderon.apirate.services.RateServices;

@RestController
@RequestMapping("rateconverter/api")
public class rateController {
	
	@Autowired
	private RateServices rateServices;
	
	/**
	 * Receives the user request and make the convert of the given rate
	 * @param rate1 is the interest rate to be convert
	 * @param annuity type of annuity annual effective, periodically or annual nominal
	 * @param periods number of periods to cast the rate, example monthly = 12
	 * @param annuityToGo type of annuity to go
	 * @param periodsToGo numbers of periods to go in case of nominal and periodically
	 * @return
	 */
	@GetMapping("/convert")
	public Double rateConverted(@RequestParam("rate") String rate1,
								@RequestParam("annuity") String annuity,
								@RequestParam("periods") String periods,
								@RequestParam("annuityToGo") String annuityToGo,
								@RequestParam("periodsToGo") String periodsToGo) {
		double rateTransformed = Double.parseDouble(rate1);
		int periodsTransformed = Integer.parseInt(periods);
		int periodsToGoTransformed = Integer.parseInt(periodsToGo);
		
		RateInterest rateToConvert = new RateInterest(rateTransformed,annuity, periodsTransformed,
														annuityToGo,periodsToGoTransformed);
		return rateServices.transformRate(rateToConvert);
	}

}
