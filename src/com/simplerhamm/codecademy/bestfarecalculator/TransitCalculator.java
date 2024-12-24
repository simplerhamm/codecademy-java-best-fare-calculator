package com.simplerhamm.codecademy.bestfarecalculator;

public class TransitCalculator {
	
	int days;	// # of days a person will be using the transit system (0-30)
	int rides;	// # of rides the person expects to take in that time
	
	double[] fareRates = { 2.75, 33.00, 127.00 };	// Price of each fare option
	// Pay-per-ride (single ride): $2.75
	// 7-day Unlimited Rides: $33.00
	// 30-day Unlimited Rides: $127.00
	
	
	/**
	 * Constructor
	 * @param days # of days a person will be using the transit system (0-30);
	 * @param rides # of rides the person expects to take in that time
	 */
	public TransitCalculator(int days, int rides) {
		this.days = days;
		this.rides = rides;
	}
	
	public double payPerRidePrice() {
		double costPerRide = fareRates[0];	// The cost for each ride the person takes
		return costPerRide;
	}
	
	/**
	 * Determines the cost per ride for the person when using only the 7-day unlimited
	 * fare option.
	 * @return the cost per ride rounded to 2 decimal points
	 */
	public double unlimited7Price() {
		int periods = (int) Math.ceil(days / 7.0);	// How many times the rate is paid.
		double price = fareRates[1];	// This price of this fare option ($33.00)
		double totalCost = price * periods;	// The total cost in USD
		double costPerRide = totalCost / rides;	// The cost for each ride the person takes
		return Math.round(costPerRide * 100) / 100.0;
	}
	
	/**
	 * Determines the cost per ride for the person when using only the 30-day unlimited
	 * fare option.
	 * @return the cost per ride rounded to 2 decimal points
	 */
	public double unlimited30Price() {
		int periods = (int) Math.ceil(days / 30.0);	// How many times the rate is paid.
		double price = fareRates[2];	// This price of this fare option ($127.00)
		double totalCost = price * periods;	// The total cost in USD
		double costPerRide = totalCost / rides;	// The cost for each ride the person takes
		return Math.round(costPerRide * 100) / 100.0;
	}
	
	/**
	 * Get the cost per ride for each fare rate.
	 * @return the array of costs for one ride of each fare.
	 */
	public double[] getRidePrices() {
		double[] ridePrices = new double[fareRates.length];	// An empty array to hold the cost
		ridePrices[0] = payPerRidePrice();	// Fill the array
		ridePrices[1] = unlimited7Price();
		ridePrices[2] = unlimited30Price();
		return ridePrices;
	}
	
	/**
	 * Get a description of the best fare for the person.
	 * @return the String description of the best fare for the person.
	 */
	public String getBestFare() {
		double lowestPrice = 0.0;	// Holds the lowest found cost per ride
		String fareOption = "";	// Will hold the name of the fare option with the lowest cost per ride
		int fareOptionIndex = 0;	// Holds the index of the fare option in the array of costs per ride
		
		/* Iterate through ride prices
		 * Find the lowest price
		 * Keep track of the index of that price
		 */
		for (int i = 0; i < getRidePrices().length; i++) {
			double price = getRidePrices()[i];
			if (lowestPrice == 0.0 || lowestPrice > price) {
				lowestPrice = price;
				fareOptionIndex = i;
			}
		}
		
		// Connect the previously found index with the correct fare option
		if (fareOptionIndex == 0) {
			fareOption = "Pay-per-ride";
		}
		else if (fareOptionIndex == 1) {
			fareOption = "7-day Unlimited";
		}
		else if (fareOptionIndex == 2) {
			fareOption = "30-day Unlimited";
		}
		else {
			fareOption = "Invalid Fare";
		}
		
		// Output String
		return "You should get the " + fareOption + " option at $" + lowestPrice + " per ride.";
	}
	
	public static void main(String[] args) {
		TransitCalculator tc = new TransitCalculator(5, 12);
		System.out.println(tc.payPerRidePrice());
		System.out.println(tc.unlimited7Price());
		System.out.println(tc.unlimited30Price());
		System.out.println(tc.getBestFare());
	}
	
}