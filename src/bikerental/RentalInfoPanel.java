package bikerental;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

/**
 * The RentalInfoPanel class creates Rental Info GUI panel.
 */

public class RentalInfoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel; //name label
	private JLabel startDateLabel; //start date label
	private JLabel numberOfDaysLabel; //number of days label
	
	public JTextField nameTextField; //name text field
	public JTextField startDateTextField; //start date text field
	public JTextField numberOfDaysTextField; //number of days text field
	
	/**
	 * The RentalInfoPanel method construct GUI of Rental Info section.
	 */
	
	public RentalInfoPanel()
	{
		//create labels and text fields
		nameLabel = new JLabel("Name");
		startDateLabel = new JLabel("Start Date (YYYY-MM-DD)");
		numberOfDaysLabel = new JLabel("Number of Days");
		nameTextField = new JTextField(20);
		startDateTextField = new JTextField(20);
		numberOfDaysTextField = new JTextField(20);

		//create a GridLayout manager
		setLayout(new GridLayout(3, 1));

		//create a border
		setBorder(BorderFactory.createTitledBorder("Rental Info"));

		//add labels and text fields to the panel
		add(nameLabel);
		add(nameTextField);
		add(startDateLabel);
		add(startDateTextField);
		add(numberOfDaysLabel);
		add(numberOfDaysTextField);
	}
	
	/**
	 * The getCustomerName method takes customer name.
	 * @return input Customer name.
	 */

	public String getCustomerName()
	{
		String input; //to hold the user's input
		
		//get the customer name
		input = nameTextField.getText();
		
		return input;
	}	
	
	/**
	 * The getStartDate method takes start rental date.
	 * @return startDate Start rental date.
	 */

	public LocalDate getStartDate()
	{
		String input; //to hold the user's input
		
		//get the start date
		input = startDateTextField.getText();
		LocalDate startDate = LocalDate.parse(input);
		
		return startDate;
	}	
	
	/**
	 * The getEndDate method calculates end rental date.
	 * @return endDate End rental date.
	 */

	public LocalDate getEndDate()
	{
		int numberOfDays; //takes number of days
		String input; //to hold the user's input
		
		//get the amount of rental days
		input = numberOfDaysTextField.getText();
		
		//convert the amount of rental days to integer
		numberOfDays = Integer.parseInt(input);
		
		//get the start date
		input = startDateTextField.getText();
		LocalDate startDate = LocalDate.parse(input);
		
		//calculates the end date
		LocalDate endDate = startDate.plusDays(numberOfDays);
		
		return endDate;
	}	
	
	/**
	 * The getNumberOfDays method calculates takes the number of days.
	 * @return numberOfDays The number of days.
	 */

	public int getNumberOfDays()
	{
		int numberOfDays; //takes number of days
		String input; //to hold the user's input
		
		//get the amount of rental days
		input = numberOfDaysTextField.getText();
		
		//convert the amount of rental days to integer
		numberOfDays = Integer.parseInt(input);
		
		return numberOfDays;
	}
}