import java.util.Hashtable;


/**
 * Makes combinations of coins given input monetary values, and keeps track of all combinations of
 * coins we have already seen via a hashtable
 * @author neilbasu
 *
 */
public class Change {
	private static Hashtable<String, Boolean> allChangeCombos = new Hashtable<String, Boolean>();
	public static final double PENNY = .01;
	public static final double NICKEL = .05;
	public static final double DIME = .1;
	public static final double QUARTER = .25;
	public static final double COINS[] = {Change.QUARTER, Change.DIME, Change.NICKEL, Change.PENNY};
	public static final int COINTYPES = 4;
	
	/**
	 * Gets the amount of change in an optimal scenario, with the most quarters/dimes/etc possible.
	 * We are using this as a starting state
	 * @param amount Double representing dollars and cents
	 * @return An int array of quarters, dimes, nickels, pennies, for the smallest number of total coins
	 */
	public static int[] makeBestChange(double amount)
	{
		//Using ints to avoid rounding problems
		int amountToInt = (int) (100*amount);
		
		//Number of quarters, then dimes, then nickels, then pennies
		int numCoins[] = new int[Change.COINTYPES];
		
		//Figuring out the optimal change as a starting point
		for (int i = 0; i < numCoins.length; i++)
		{
			numCoins[i] = (int) (amountToInt/(Change.COINS[i] * 100));
			amountToInt -= numCoins[i] * (Change.COINS[i] * 100);
		}
						
		return numCoins;
	}
	
	/**
	 * @param node A tree node representing a combination of coins
	 * @return Whether a combination of coins in a ChangeNode has already been seen
	 */
	public static boolean changeComboExists(ChangeNode node)
	{
		if (allChangeCombos.containsKey(node.toString()))
			return true;
		else
		{
			return false;
		}
	}
	
	/**
	 * @param node Adds a new combination of coins to the hashtable
	 */
	public static void addCombo(ChangeNode node)
	{
		allChangeCombos.put(node.toString(), true);
	}
	
	/**
	 *Reset hash table
	 */
	public static void reset()
	{
		allChangeCombos = new Hashtable<String, Boolean>();
	}
	
	/**
	 * @return Number of combinations of coins we have seen so far
	 */
	public static int numCombos()
	{
		return allChangeCombos.size();
	}
}
