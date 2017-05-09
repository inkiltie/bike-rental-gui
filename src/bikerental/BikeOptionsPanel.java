package bikerental;

import java.awt.*;
import javax.swing.*;

/**
 * The BikeOptionsPanel class creates Bike Options GUI panel.
 */

public class BikeOptionsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	public final double DELIVERY = 70.00; //delivery price
	public final double HELMET = 11.50; //helmet price
	public final double BIKE_LOCK = 20.00; //bike lock price
	public final double REPAIR_KIT = 5.75; //repair kit price
	
	//create booleans
	private boolean deliveryToken = false;
	private boolean helmetToken = false;
	private boolean bikeLockToken = false;
	private boolean repairKitToken = false;

	public JCheckBox delivery; //check box for delivery
	public JCheckBox helmet; //check box for helmet
	public JCheckBox bikeLock; //check box for bike lock
	public JCheckBox repairKit; //check box for repair kit
	
	/**
	 * The getDeliveryToken method returns deliveryToken
	 * @return deliveryToken Delivery Token.
	 */
	
	public boolean getDeliveryToken() {return deliveryToken;}
	
	/**
	 * The getHelmetToken method returns helmetToken
	 * @return helmetToken Helmet Token.
	 */
	
	public boolean getHelmetToken() {return helmetToken;}
	
	/**
	 * The getBikeLockToken method returns bikeLockToken
	 * @return bikeLockToken Bike Lock Token.
	 */
	
	public boolean getBikeLockToken() {return bikeLockToken;}
	
	/**
	 * The getRepairKitToken method return deliveryToken
	 * @return repairKitToken Repair Kit Token.
	 */
	
	public boolean getRepairKitToken() {return repairKitToken;}
	
	/**
	 * The BikeOptionsPanel method construct GUI panel with bike options
	 */
	
	public BikeOptionsPanel()
	{
		//create the check boxes
		delivery = new JCheckBox("Delivery");
		helmet = new JCheckBox("Helmet");
		bikeLock = new JCheckBox("Bike Lock");
		repairKit = new JCheckBox("Repair Kit");

		//create a GridLayout manager
		setLayout(new GridLayout(4, 1));

		//create a border
		setBorder(BorderFactory.createTitledBorder("Options"));

		//add the check boxes to the panel
		add(delivery);
		add(helmet);
		add(bikeLock);
		add(repairKit);
	}
	
	/**
	 * The setOptionsTokens set boolean to true if check box is checked
	 */

	public void setOptionsTokens()
	{
		if (delivery.isSelected()) {deliveryToken = true;}
	
		if (helmet.isSelected()) {helmetToken = true;}
		
		if (bikeLock.isSelected()) {bikeLockToken = true;}
		
		if (repairKit.isSelected()) {repairKitToken = true;}
	}
	
	/**
	 * The resetOptionsTokens method set all tokens to false.
	 */
	
	public void resetOptionsTokens()
	{
		deliveryToken = false;
		helmetToken = false;
		bikeLockToken = false;
		repairKitToken = false;
	}

	/**
	 * The getOptions method calculates the options charges.
	 * @return optionsPrice The amount of options charges.
	 */

	public double getOptionsPrice()
	{
		double optionsPrice = 0;

		if (delivery.isSelected()){ 
			optionsPrice += DELIVERY;}
		if (helmet.isSelected()) {
			optionsPrice += HELMET;}
		if (bikeLock.isSelected()) {
			optionsPrice += BIKE_LOCK;}
		if (repairKit.isSelected()) {
			optionsPrice += REPAIR_KIT;}

		return optionsPrice;
	}
}