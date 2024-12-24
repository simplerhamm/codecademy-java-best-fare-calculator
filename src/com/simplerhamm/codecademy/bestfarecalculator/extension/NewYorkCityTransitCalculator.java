package com.simplerhamm.codecademy.bestfarecalculator.extension;

import java.util.ArrayList;

/**
 * Codecademy Java Practice Project: Best Fare Calculator, extended
 */
public class NewYorkCityTransitCalculator {
	
	private int days;	// # of days a person will be using the transit system (0-30)
	private int rides;	// # of rides the person expects to take in that time
	private int age;	// The age of the person
	private boolean accommodations;	// Whether or not the person has a disability
	private boolean reducedFare;	// Whether or not the person is applicable for reduced fare rates
	
	private static final int PAY_PER_RIDE = 0;
	private static final int UNLIMITED_7_DAYS = 1;
	private static final int UNLIMITED_30_DAYS = 2;
	
	// New York City fare options
	private Fare[] fareOptions = {
			new Fare(
					2.75,
					1.35,
					"Pay-per-ride (single ride)",
					"New York City Transit",
					"New York City, USA"),
			new Fare(
					33.00,
					16.50,
					"7-day Unlimited Rides",
					"New York City Transit",
					"New York City, USA"),
			new Fare(
					127.00,
					63.50,
					"30-day Unlimited Rides",
					"New York City Transit",
					"New York City, USA")
	};
	
	
	/**
	 * Most basic constructor
	 * @param rides # of rides the person expects to take
	 * @param days # of days a person will be using the transit system (0-30);
	 */
	public NewYorkCityTransitCalculator(int rides, int days) {
		
		// Check validity of rides parameter
		if (rides >= 0) { this.rides = rides; }
		else { this.rides = 0; }
		
		// Check validity of days parameter
		if (days >= 0 && days <= 30) { this.days = days; }
		else { this.days = 0; }
		
		// Other properties
		this.age = 0;
		this.accommodations = false;
		this.reducedFare = false;
		
	}
	
	/**
	 * Constructor using rides, days, and age
	 * @param rides # of rides the person expects to take
	 * @param days # of days a person will be using the transit system (0-30)
	 * @param age the age of the person
	 */
	public NewYorkCityTransitCalculator(int rides, int days, int age) {
		
		// Call simpler constructor
		this(rides, days);
		
		// Check validity of age
		if (age >= 0) { this.age = age; }
		
		// Determine if applicable for reduced fare prices
		if (this.age >= 65) { this.reducedFare = true; }
		
	}
	
	/**
	 * Constructor with rides, days, and accommodations
	 * @param rides # of rides the person expects to take
	 * @param days # of days a person will be using the transit system (0-30)
	 * @param accommodations whether or not the person has a disability
	 */
	public NewYorkCityTransitCalculator(int rides, int days, boolean accommodations) {
		
		// Call simpler constructor
		this(rides, days);
		
		this.accommodations = accommodations;
		
		// Determine if applicable for reduced fare prices
		if (this.accommodations) { this.reducedFare = true; }
	}
	
	/**
	 * Constructor with all parameters
	 * @param rides # of rides the person expects to take
	 * @param days # of days a person will be using the transit system (0-30)
	 * @param age the age of the person
	 * @param accommodations whether or not the person has a disability
	 */
	public NewYorkCityTransitCalculator(int rides, int days, int age, boolean accommodations) {
		
		// Call simpler constructor
		this(rides, days, age);
		
		this.accommodations = accommodations;
		
		// Determine if applicable for reduced fare prices due to a disability
		if (this.reducedFare == false && this.accommodations == true) {
			this.reducedFare = true;
		}
		
	}
	
	/**
	 * Determines the cost per ride for the person when using only the pay-per-ride
	 * fare option.
	 * @return the cost per ride rounded to 2 decimal points
	 */
	public double payPerRidePrice() {
		double costPerRide = fareOptions[PAY_PER_RIDE].getRate();	// The cost for each ride the person takes
		if (reducedFare) { costPerRide = fareOptions[PAY_PER_RIDE].getReducedRate(); }
		return Math.round(costPerRide * 100) / 100.0;
	}
	
	/**
	 * Determines the cost per ride for the person when using only the 7-day unlimited
	 * fare option.
	 * @return the cost per ride rounded to 2 decimal points
	 */
	public double unlimited7Price() {
		int periods = (int) Math.ceil(days / 7.0);	// How many times the rate is paid.
		double price = fareOptions[UNLIMITED_7_DAYS].getRate();	// This price of this fare option ($33.00)
		if (reducedFare) { price = fareOptions[UNLIMITED_7_DAYS].getReducedRate(); }
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
		double price = fareOptions[UNLIMITED_30_DAYS].getRate();	// This price of this fare option ($127.00)
		if (reducedFare) { price = fareOptions[UNLIMITED_30_DAYS].getReducedRate(); }
		double totalCost = price * periods;	// The total cost in USD
		double costPerRide = totalCost / rides;	// The cost for each ride the person takes
		return Math.round(costPerRide * 100) / 100.0;
	}
	
	/**
	 * Get the cost per ride for each fare rate.
	 * @return the array of costs for one ride of each fare.
	 */
	public double[] getRidePrices() {
		double[] ridePrices = new double[fareOptions.length];	// An empty array to hold the cost
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
		Fare fareOption = fareOptions[PAY_PER_RIDE];	// Will hold the fare option with the lowest cost per ride
		
		/* Iterate through ride prices
		 * Find the lowest price
		 * Keep track of the index of that price
		 */
		for (int i = 0; i < getRidePrices().length; i++) {
			double price = getRidePrices()[i];
			if (lowestPrice == 0.0 || lowestPrice > price) {
				lowestPrice = price;
				fareOption = fareOptions[i];
			}
		}
		
		// Output String
		return "You should get the " + fareOption.getServiceName() + " option at $"
			+ lowestPrice + " per ride.";
	}
	
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		NewYorkCityTransitCalculator tc = new NewYorkCityTransitCalculator(12, 5);
		System.out.println(tc.payPerRidePrice());
		System.out.println(tc.unlimited7Price());
		System.out.println(tc.unlimited30Price());
		System.out.println(tc.getBestFare());
		NewYorkCityTransitCalculator tc2 = new NewYorkCityTransitCalculator(12, 5, 66);
		System.out.println(tc2.payPerRidePrice());
		System.out.println(tc2.unlimited7Price());
		System.out.println(tc2.unlimited30Price());
		System.out.println(tc2.getBestFare());
		NewYorkCityTransitCalculator tc3 = new NewYorkCityTransitCalculator(54, 26, true);
		System.out.println(tc3.payPerRidePrice());
		System.out.println(tc3.unlimited7Price());
		System.out.println(tc3.unlimited30Price());
		System.out.println(tc3.getBestFare());
	}
	
}