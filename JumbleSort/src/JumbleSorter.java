import java.util.ArrayList;
import java.util.Hashtable;

/**
 * A class to sort a sequence of entries of different types (Integer and String for now) separately, and
 * return them in the same order of types.  i.e. 6, "c", 5, "b" will return 5, "b", 6, "c"
 * @author neilbasu
 *
 */
public class JumbleSorter {
	//Keeps track of sorted arraylists 
	@SuppressWarnings("rawtypes")
	private Hashtable<String, HeapList> dataHash;
	//Keeps track of datatype order, i.e. Integer Integer String Integer...
	private ArrayList<String> typeOrder;

	@SuppressWarnings("rawtypes")
	public JumbleSorter() {
		dataHash = new Hashtable<String, HeapList>();
		//Hardcoding types in here; in a generic case these would be added dynamically
		dataHash.put("Integer", new HeapList<Integer>());
		dataHash.put("String", new HeapList<String>());
		typeOrder = new ArrayList<String>();
	}
	
	/**
	 * Takes in a string and tries to cast it into an integer
	 * If successful, add that integer to Integer heaplist, else to string heaplist
	 * @param entry Any string to input into the sorter.  If string is numeric it will parse into an Integer
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(String entry)
	{
		try 
		{
			Integer newValue = Integer.parseInt(entry);
			((HeapList)dataHash.get("Integer")).insertSorted(newValue);
			typeOrder.add("Integer");
		}
		catch (NumberFormatException e)
		{
			((HeapList)dataHash.get("String")).insertSorted(entry);
			typeOrder.add("String");
		}
	}
	
	/**
	 * @return Checks order of integers and strings, and returns the sorted lists accordingly
	 */
	@SuppressWarnings("rawtypes")
	public String[] sort()
	{
		String[] sortedArray = new String[typeOrder.size()];
		
		for (int i = 0; i < sortedArray.length; i++)
		{
			sortedArray[i] = ((HeapList)dataHash.get(typeOrder.get(i))).pop().toString();
		}
		
		return sortedArray;
	}
	
	/**
	 * @return Returns a hash of the terms "Integer" and "String" with heaplists of the associated types
	 */
	@SuppressWarnings("rawtypes")
	public Hashtable getDataHash()
	{
		return dataHash;
	}
	
	/**
	 * @return A list of the terms "Integer" and "String", signifying the order of strings and integer in the input
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList getTypeOrder()
	{
		return typeOrder;
	}

}
