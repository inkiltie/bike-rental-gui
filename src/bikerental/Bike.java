package bikerental;

/**
 * This class contains 2 get and set methods for bike models and their daily rates.
 */

public class Bike {
		
		private String bikeType; //bike model
		private double bikeDailyRate; //bike price
		
		/**
		 * The getBikeType method returns Bike Type.
		 * @return bikeType Bike Type.
		 */
		
		public String getBikeType() {return bikeType;}
		
		/**
		 * The getbikePrice method returns Bike Price.
		 * @return bikeDailyRate Bike Price.
		 */
		
		public double getbikePrice() {return bikeDailyRate;}
		
		/**
		 * The setBikeType method sets Bike Type.
		 */
		
		public void setBikeType(String x) {bikeType = x;}
		
		/**
		 * The setBikePrice method sets Bike Price.
		 */
		
		public void setBikePrice(double x) {bikeDailyRate = x;} 
}