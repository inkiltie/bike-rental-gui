package bikerental;

import java.awt.*;
import javax.swing.*;

/**
 * The BikePanel class creates Bike GUI panel.
 */

public class BikePanel extends JPanel
{	
	private static final long serialVersionUID = 1L;
	private final double ROAD = 80.00; //delivery price
	private final double MOUNTAIN = 51.25; //helmet price
	private final double CRUISER = 35.50; //bike lock price
	private final double KIDS = 20.00; //repair kit price

	public JRadioButton road; //check box for delivery
	public JRadioButton mountain; //check box for helmet
	public JRadioButton cruiser; //check box for bike lock
	public JRadioButton kids; //check box for repair kit
	
	private ButtonGroup radioButtonGroup; //group radio buttons

	/**
	 * The BikePanel method construct GUI of Bike section.
	 */	
	
	public BikePanel()
	{
		//create the radio buttons
		road = new JRadioButton("Road"); 
		mountain = new JRadioButton("Mountain");
		cruiser = new JRadioButton("Cruiser");
		kids = new JRadioButton("Kids");

		//create a GridLayout manager
		setLayout(new GridLayout(4, 1));

		//create a border
		setBorder(BorderFactory.createTitledBorder("Bikes"));
		
		//group the radio buttons
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(road);
		radioButtonGroup.add(mountain);
		radioButtonGroup.add(cruiser);
		radioButtonGroup.add(kids);

		//add the radio buttons to the panel
		add(road);
		add(mountain);
		add(cruiser);
		add(kids);
	}
	
	/**
	 * The clearButtons method clear selection of radio buttons.
	 */
	
	public void clearButtons() {radioButtonGroup.clearSelection();}
	
	/**
	* The getBikeChoice method shows chosen bike.
	* @return bikeChoice Chosen bike name.
	*/

	public String getBikeChoice()
	{
		String bikeChoice = "";

		if (road.isSelected())
			bikeChoice = "Road";
		else if (mountain.isSelected())
			bikeChoice = "Mountain";
		else if (cruiser.isSelected())
			bikeChoice = "Cruiser";
		else if (kids.isSelected())
			bikeChoice = "Kids";

		return bikeChoice;
	}
	
	/**
	* The getBikePrice method calculates the price of chosen bike.
	* @return bikePrice The price of chosen bike.
	*/

	public double getBikePrice()
	{
		double bikePrice = 0;

		if (road.isSelected())
			bikePrice = ROAD;
		else if (mountain.isSelected())
			bikePrice = MOUNTAIN;
		else if (cruiser.isSelected())
			bikePrice = CRUISER;
		else if (kids.isSelected())
			bikePrice = KIDS;

		return bikePrice;
	}
}