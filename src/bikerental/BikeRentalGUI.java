package bikerental;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 * The BikeRentalGUI class creates GUI of Bike Rental Application
 */

public class BikeRentalGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	public int orderCounter = 0; //order counter
	private BikePanel bike; //BikePanel class
	private RentalInfoPanel rentalInfo; //RentalInfoPanel class
	private BikeOptionsPanel bikeOptions; //BikeOptionsPanel class
	final int WINDOW_WIDTH = 800; //window width in pixels
	final int WINDOW_HEIGHT = 460; //window height in pixels
	private JTextArea outputTextBox; //output box
	private JButton orderButton; //calculates and shows single order
	private JButton reportButton; //shows report(s)
	private JButton exitButton; //exits the application
	
	//main ArrayList which will hold objects of type CustomerOrder
	ArrayList<CustomerOrder> orderDatabase = new ArrayList<CustomerOrder>();
	
	/**
	 * The BikeRentalGUI method construct GUI of of Bike Rental Application
	 */
	
	public BikeRentalGUI()
	{
		//set this window's title
		setTitle("Bike Rental Shop");

		//set the size of this window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		//specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a BikePanel object
		bike = new BikePanel();
		
		//create a RentalInfoPanel object
		rentalInfo = new RentalInfoPanel();
		
		//create a BikeOptionsPanel object
		bikeOptions = new BikeOptionsPanel();
		
		//add a BorderLayout manager to the content pane
		setLayout(new BorderLayout());
		
		//create three panels: header, output and button
		JPanel headerPanel = new JPanel();
		JPanel outputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//create a button to calculate and show single order
		orderButton = new JButton("Enter order");

		//add an action listener to the button
		orderButton.addActionListener(new OrderButtonListener());
		
		//create a button to show report(s)
		reportButton = new JButton("Report");

		//add an action listener to the button
		reportButton.addActionListener(new ReportButtonListener());
		
		//create a button to exit the application
		exitButton = new JButton("Exit");

		//add an action listener to the button
		exitButton.addActionListener(new ExitButtonListener());
	    
	    //create output text area
	    outputTextBox = new JTextArea(10,5);
	    
	    //use fixed width font
		outputTextBox.setFont(new Font("monospaced", Font.PLAIN, 12));
		
		//no input allowed in the text area
		outputTextBox.setEditable(false);
		
		//make output box scrolls
		JScrollPane reportScrollPane = new JScrollPane(outputTextBox);
		
		//add header label to the header panel
		headerPanel.add(new JLabel("Bike Rental Order"));
		
		//create a new layout for the output panel	
		outputPanel.setLayout(new BorderLayout());
		
		//add buttons to the button panel
		buttonPanel.add(orderButton);
		buttonPanel.add(reportButton);
		buttonPanel.add(exitButton);
		
		//add six panels to the content pane
		add(headerPanel, BorderLayout.NORTH);
		add(bike, BorderLayout.WEST);
		add(rentalInfo, BorderLayout.CENTER);
		add(bikeOptions, BorderLayout.EAST);
		add(outputPanel, BorderLayout.SOUTH);
		outputPanel.add(buttonPanel, BorderLayout.NORTH);
		
		//add output box to the output panel
		outputPanel.add(new JLabel("Output"), BorderLayout.CENTER);
		
		//add scroll bar box to the output panel
		outputPanel.add(reportScrollPane, BorderLayout.SOUTH);

		//pack and display the window
		pack();
		setVisible(true);
	}
	
	/**
	 * The showOrder method calculates and show a single order.
	 */

	public void showOrder() 
	{
		//creates CustomerOrder object which extends the Bike object
		CustomerOrder currentOrder = new CustomerOrder();
		
		double allRentalCost; //rental price for entire period
		double total; //total charges with add ons
		
		//calculates rental price for entire period
		allRentalCost = bike.getBikePrice() * rentalInfo.getNumberOfDays();
		
		//calculate the total charges
		total = bike.getBikePrice() * rentalInfo.getNumberOfDays() + bikeOptions.getOptionsPrice();
		
		//set all the tokens, almost like switches for add ons to be treated independently
		bikeOptions.setOptionsTokens();
		
		currentOrder.setCustomerName(rentalInfo.getCustomerName());
		currentOrder.setNumberOfDays(rentalInfo.getNumberOfDays());
		currentOrder.setStartDate(rentalInfo.getStartDate());
		currentOrder.setEndDate(rentalInfo.getEndDate());
		currentOrder.setBikeType(bike.getBikeChoice());
		currentOrder.setBikePrice(bike.getBikePrice());
		currentOrder.setOrderTotalCost(total);
		currentOrder.setOptionsCost(bikeOptions.getOptionsPrice());
		
		if(bikeOptions.getBikeLockToken() == true) 
		{
			currentOrder.setBikeLock(bikeOptions.BIKE_LOCK);
		}
		else 
		{
			currentOrder.setBikeLock(0.00);
		}
		
		if(bikeOptions.getDeliveryToken() == true) 
		{
			currentOrder.setDelivery(bikeOptions.DELIVERY);
		}
		else
		{
			currentOrder.setDelivery(0.00);
		}
		
		if (bikeOptions.getHelmetToken() == true)
		{
			currentOrder.setHelmet(bikeOptions.HELMET);
		}
		else
		{
			currentOrder.setHelmet(0.00);
		}
		
		if(bikeOptions.getRepairKitToken() == true)
		{
			currentOrder.setRepairKit(bikeOptions.REPAIR_KIT);
		}
		else
		{
			currentOrder.setRepairKit(0.00);
		}

		//store the output in an ArrayList
		orderDatabase.add(currentOrder);
		
		//display the output
		//first clear all the data
		
		//clear the text box
		outputTextBox.setText(null);
		
		//clear the radio buttons
		bike.clearButtons();
		
		//clear the check boxes
		bikeOptions.delivery.setSelected(false);
		bikeOptions.helmet.setSelected(false);
		bikeOptions.bikeLock.setSelected(false);
		bikeOptions.repairKit.setSelected(false);
		
		//clear the text boxes
		rentalInfo.nameTextField.setText("");
		rentalInfo.numberOfDaysTextField.setText("");
		rentalInfo.startDateTextField.setText("");

		//begin output
		outputTextBox.append("ORDER RECEIPT");
		outputTextBox.append("\nCustomer: " + currentOrder.getCustomerName());
		outputTextBox.append("\nRental starts: " + currentOrder.getStartDate() + " ends: " + currentOrder.getEndDate());
		outputTextBox.append("\n" + String.format("%14s Bike Daily Rate: $ %7.2f", currentOrder.getBikeType(), currentOrder.getbikePrice()));
		outputTextBox.append("\n" + String.format("%22s %s days: $ %7.2f", "Bike Rental for", currentOrder.getNumberOfDays(), allRentalCost));
		
		if(bikeOptions.getBikeLockToken() == true)
		{
			outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Bike Lock:", currentOrder.getBikeLock()));
		}
		if(bikeOptions.getRepairKitToken() == true)
		{
			outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Repair Kit:", currentOrder.getRepairKit()));
		}
		if(bikeOptions.getHelmetToken() == true)
		{
			outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Helmet:", currentOrder.getHelmet()));
		}
		if(bikeOptions.getDeliveryToken() == true)
		{
			outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Delivery:", currentOrder.getDelivery()));
		}
		
		outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Order Total Cost:", currentOrder.getOrderTotalCost()));
		
		//reset tokens
		bikeOptions.resetOptionsTokens();
	}
	
	/**
	 * OrderButtonListener is an action listener class for the orderButton component.
	 */

	private class OrderButtonListener implements ActionListener {
		
		/**
		 * actionPerformed method
		 * @param e An ActionEvent object.
		 */

		public void actionPerformed(ActionEvent e) 
		{
			showOrder();
		}
	}
	
	/**
	 * The printReport method shows list of all orders with summary.
	 */
	
	public void printReport()
	{
		//couple variables for final output
		double totalRentalSales = 0.00;
		double totalOptionSales = 0.00;
		
		//clear the text box
		outputTextBox.setText(null);
		
		//begin output
		outputTextBox.append("Sales Report - Number of Orders: " + orderDatabase.size());
		
		for (int x=0; x<orderDatabase.size(); x++) {
			outputTextBox.append("\nOrder #" + (x + 1));
			outputTextBox.append("\nCustomer: " + orderDatabase.get(x).getCustomerName());
			outputTextBox.append("\nRental starts: " + orderDatabase.get(x).getStartDate() + " ends: " + orderDatabase.get(x).getEndDate());
			outputTextBox.append("\n" + String.format("%14s Bike Daily Rate: $ %7.2f", orderDatabase.get(x).getBikeType(), orderDatabase.get(x).getbikePrice()));
			outputTextBox.append("\n" + String.format("%22s %s days: $ %7.2f", "Bike Rental for", orderDatabase.get(x).getNumberOfDays(), orderDatabase.get(x).getbikePrice() * orderDatabase.get(x).getNumberOfDays()));
			
			if (orderDatabase.get(x).getBikeLock() > 0)
		    {
				outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Bike Lock:", orderDatabase.get(x).getBikeLock()));
		    }
			if (orderDatabase.get(x).getRepairKit() > 0)
		    {
				outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Repair Kit:", orderDatabase.get(x).getRepairKit()));
		    }
			if (orderDatabase.get(x).getHelmet() > 0)
		    {
				outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Helmet:", orderDatabase.get(x).getHelmet()));
		    }
			if (orderDatabase.get(x).getDelivery() > 0)
		    {
				outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Delivery:", orderDatabase.get(x).getDelivery()));
		    }
			
			outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Order Total Cost:", orderDatabase.get(x).getOrderTotalCost()));
		
			totalRentalSales += orderDatabase.get(x).getOrderTotalCost();
			totalOptionSales += orderDatabase.get(x).getOptionsCost();
		}
		
		outputTextBox.append("\n\nSales Summary");
		outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Total Rental Sales:", totalRentalSales));
		outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Total Options Sales:", totalOptionSales));
		outputTextBox.append("\n" + String.format("%31s $ %7.2f", "Total Sales:", totalOptionSales + totalRentalSales));		
	}
	
	/**
	 * ReportButtonListener is an action listener class for the orderButton component.
	 */

	private class ReportButtonListener implements ActionListener {
		
		/**
		 * actionPerformed method
		 * @param e An ActionEvent object.
		 */

		public void actionPerformed(ActionEvent e) 
		{
			printReport();
		}
	}

	/**
	 * ExitButtonListener is an action listener class for the exitButton component.
	 */

	private class ExitButtonListener implements ActionListener {
		
		/**
		 * actionPerformed method
		 * @param e An ActionEvent object.
		 */

		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}
}