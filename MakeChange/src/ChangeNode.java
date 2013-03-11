
/**
 * To best find the combinations of coins, we first get the optimal amount of coins, i.e. the fewest coins
 * needed to make change (ex. 4 quarters for $1 instead of 10 dimes).  From there, we create a tree
 * by making change for each quarter/dime/nickel until we are left with only pennies
 * @author Neil Basu
 *
 */
public class ChangeNode {
	//Array of #quarters, #dimes, #nickels, #pennies in that order
	private int change[];

	/**
	 * @param coins An int array representing the number of quarters, dimes, nickels, and pennies
	 */
	public ChangeNode(int coins[]) {
		change = new int[Change.COINTYPES];
		for (int i = 0; i < change.length; i++)
			{
			change[i] = coins[i];
			}
	}
	
	/**
	 * @return A string showing the combination of coins for this node, and all nodes below it in the tree
	 */
	public String makeChange()
	{
		if (!Change.changeComboExists(this))
		{
			
			Change.addCombo(this);
			
			String outputString = toString() + "\n";
			
			//Nickels
			if (change[2] > 0)
			{
			//Make change for the quarter
			int breakNickel[] = {change[0], change[1], change[2]-1, change[3]+5};
			outputString += new ChangeNode(breakNickel).makeChange();
			}
			
			//Dimes
			if (change[1] > 0)
			{
			//Make change for the quarter
			int breakDime[] = {change[0], change[1]-1, change[2]+2, change[3]};
			outputString += new ChangeNode(breakDime).makeChange();
			}

			
			//If we have any quarters
			if (change[0] > 0)
				{
				//Make change for the quarter
				int breakQuarter[] = {change[0]-1, change[1]+2, change[2]+1, change[3]};
				outputString += new ChangeNode(breakQuarter).makeChange();
				}
			
		return outputString;
		}
		else
			return "";
	}
	
	/** 
	 * @return The number of each type of coin.  Used for both output and hashing
	 */
	public String toString()
	{
		String returnString = "";
		
		if (change[0] > 0)
			returnString += "QUARTERS: " + change[0] + " ";		

		if (change[1] > 0)
			returnString += "DIMES: " + change[1] + " ";		
		
		if (change[2] > 0)
			returnString += "NICKELS: " + change[2] + " ";		
		
		if (change[3] > 0)
			returnString += "PENNIES: " + change[3];
		
		return returnString;
	}

}
