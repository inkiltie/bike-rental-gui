package bikerental;

import java.time.LocalDate;

/**
 * This class contains methods which get and set customer name, start and end rental date, number of days and options.
 */

public class CustomerOrder extends Bike {

	private String customerName; //customer name
	private LocalDate startDate; // start rental date
	private LocalDate endDate; //end rental date
	private int numberOfDays; //number of days
	private double bikeLock; //bike lock option
	private double helmet; //helmet option
	private double delivery; //delivery option
	private double repairKit; //repair kit option
	private double orderTotalCost; //order total cost
	private double optionsCost; //options cost
	
	/**
	 * The setCustomerName method sets Customer Name.
	 * @param x Customer Name.
	 */
	
	public void setCustomerName(String x) {customerName = x;}
	
	/**
	 * The setStartDate method sets Start Rental Date.
	 * @param x Start Rental Date.
	 */
	
	public void setStartDate(LocalDate x) {startDate = x;}
	
	/**
	 * The setEndDate method sets End Rental Date.
	 * @param x End Rental Date.
	 */
	
	public void setEndDate(LocalDate x) {endDate = x;}
	
	/**
	 * The setNumberOfDays method sets Number of Rental Days.
	 * @param x Number of Rental Days.
	 */
	
	public void setNumberOfDays(int x) {numberOfDays = x;}
	
	/**
	 * The setBikeLock method sets a Bike Lock.
	 * @param x Bike Lock.
	 */
	
	public void setBikeLock(double x) {bikeLock = x;}
	
	/**
	 * The setHelmet method sets a Helmet.
	 * @param x Helmet.
	 */
	
	public void setHelmet(double x) {helmet = x;}
	
	/**
	 * The setDelivery method sets a Delivery.
	 * @param x Delivery.
	 */
	
	public void setDelivery(double x) {delivery = x;}
	
	/**
	 * The setRepairKit method sets a Repair Kit.
	 * @param x Repair Kit.
	 */
	
	public void setRepairKit(double x) {repairKit = x;}
	
	/**
	 * The setOptionsCost method sets an Options Cost.
	 * @param x Options Cost.
	 */
	
	public void setOptionsCost(double x) {optionsCost = x;}
	
	/**
	 * The setOrderTotalCost method sets an Order Total Cost.
	 * @param x Order Total Cost.
	 */
	
	public void setOrderTotalCost(double x) {orderTotalCost = x;}
	
	/**
	 * The getCustomerName method returns Customer Name
	 * @return customerName Customer Name.
	 */
	
	public String getCustomerName() {return customerName;}
	
	/**
	 * The getStartDate method returns Start Rental Date.
	 * @return startDate Start Rental Date.
	 */
	
	public LocalDate getStartDate() {return startDate;}
	
	/**
	 * The getEndDate method returns End Rental Date.
	 * @return endDate End Rental Date.
	 */
	
	public LocalDate getEndDate() {return endDate;}
	
	/**
	 * The getNumberOfDays method returns Number of Rental Days.
	 * @return numberOfDays Number of Rental Days.
	 */
	
	public int getNumberOfDays() {return numberOfDays;}
	
	/**
	 * The getBikeLock method returns Bike Lock.
	 * @return bikeLock Bike Lock.
	 */
	
	public double getBikeLock() {return bikeLock;}
	
	/**
	 * The getHelmet method returns Helmet.
	 * @return helmet Helmet.
	 */
	
	public double getHelmet() {return helmet;}
	
	/**
	 * The getRepairKit method returns Repair Kit.
	 * @return repairKit Repair Kit.
	 */
	
	public double getRepairKit() {return repairKit;}
	
	/**
	 * The getDelivery method returns Delivery.
	 * @return delivery Delivery.
	 */
	
	public double getDelivery() {return delivery;}
	
	/**
	 * The getOptionsCost method returns Options Cost.
	 * @return ptionsCost Options Cost.
	 */

	public double getOptionsCost() {return optionsCost;}
	
	/**
	 * The getOrderTotalCost method returns Order Total Cost.
	 * @return orderTotalCost Order Total Cost.
	 */
	
	public double getOrderTotalCost() {return orderTotalCost;}
}