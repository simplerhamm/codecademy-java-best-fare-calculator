package com.simplerhamm.codecademy.bestfarecalculator.extension;

/**
 * Represents a fare service for public transit services
 */
public class Fare {

	private String serviceName;	// The name of the fare option/service/subscription
	private String transitSystem;	// The name of the transit system utilizing this fare
	private String location;	// The name of the location of the transit system
	private double rate;	// The price of the fare service
	private double reducedRate;	// The reduced price of the fare service
	
	/**
	 * Default constructor
	 */
	public Fare() {
		this.serviceName = "";
		this.transitSystem = "";
		this.location = "";
		this.rate = 0.0;
		this.reducedRate = 0.0;
	}
	
	/**
	 * Constructor with rate
	 * @param rate the price of the fare service
	 */
	public Fare(double rate) {
		this();
		
		// Check validity of rate
		if (rate >= 0.0) { this.rate = rate; }
		this.reducedRate = this.rate;
	}
	
	/**
	 * Constructor with rate and reducedRate
	 * @param rate the price of the fare service
	 * @param reducedRate the reduced price of the fare service
	 */
	public Fare(double rate, double reducedRate) {
		this(rate);
		if (reducedRate >= 0.0 && reducedRate < this.rate) { this.reducedRate = reducedRate; }
	}
	
	/**
	 * Constructor with rate and serviceName
	 * @param rate the price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 */
	public Fare(double rate, String serviceName) {
		this(rate);
		this.serviceName = serviceName;
	}
	
	/**
	 * Constructor with rate, reducedRate, and serviceName
	 * @param rate the price of the fare service
	 * @param reducedRate the reduced price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 */
	public Fare(double rate, double reducedRate, String serviceName) {
		this(rate, reducedRate);
		this.serviceName = serviceName;
	}
	
	/**
	 * Constructor with rate, serviceName, and transitSystem
	 * @param rate the price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 * @param transitSystem the name of the transit system utilizing this fare
	 */
	public Fare(double rate, String serviceName, String transitSystem) {
		this(rate, serviceName);
		this.transitSystem = transitSystem;
	}
	
	/**
	 * Constructor with rate, reducedRate, serviceName, and transitSystem
	 * @param rate the price of the fare service
	 * @param reducedRate the reduced price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 * @param transitSystem the name of the transit system utilizing this fare
	 */
	public Fare(double rate, double reducedRate, String serviceName, String transitSystem) {
		this(rate, reducedRate, serviceName);
		this.transitSystem = transitSystem;
	}
	
	/**
	 * Constructor with rate, serviceName, transitSystem, and location
	 * @param rate the price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 * @param transitSystem the name of the transit system utilizing this fare
	 * @param location the name of the location of the transit system
	 */
	public Fare(double rate, String serviceName, String transitSystem, String location) {
		this(rate, serviceName, transitSystem);
		this.location = location;
	}
	
	/**
	 * Constructor with rate, serviceName, transitSystem, and location
	 * @param rate the price of the fare service
	 * @param reducedRate the reduced price of the fare service
	 * @param serviceName the name of the fare option/service/subscription
	 * @param transitSystem the name of the transit system utilizing this fare
	 * @param location the name of the location of the transit system
	 */
	public Fare(double rate, double reducedRate, String serviceName, String transitSystem, String location) {
		this(rate, reducedRate, serviceName, transitSystem);
		this.location = location;
	}

	/**
	 * Gets serviceName
	 * @return serviceName, the name of the fare option/service/subscription
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Sets serviceName
	 * @param serviceName the name of the fare option/service/subscription
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Gets transitSystem
	 * @return transitSystem, the name of the transit system utilizing this fare
	 */
	public String getTransitSystem() {
		return transitSystem;
	}

	/**
	 * Sets transitSystem
	 * @param transitSystem the name of the transit system utilizing this fare
	 */
	public void setTransitSystem(String transitSystem) {
		this.transitSystem = transitSystem;
	}

	/**
	 * Gets location
	 * @return location, the name of the location of the transit system
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets location
	 * @param location the name of the location of the transit system
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets rate
	 * @return rate, the price of the fare service
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Sets rate
	 * @param rate the price of the fare service
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * Gets reducedRate
	 * @return reducedRate, the reduced price of the fare service
	 */
	public double getReducedRate() {
		return reducedRate;
	}

	/**
	 * Sets reducedRate
	 * @param reducedRate the reduced price of the fare service
	 */
	public void setReducedRate(double reducedRate) {
		this.reducedRate = reducedRate;
	}
	
}
