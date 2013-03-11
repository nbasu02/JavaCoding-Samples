/**
 * @author neilbasu
 *
 */
public class DataCenter {
	private boolean hasData[];
	private int id;
	
	/**
	 * @param centerId　Since center ids are >= 1, increments center's id by 1
	 * @param remainingData All of the ids of the datasets this data center has.  Does not get stored, only used for hasData[]
	 */
	public DataCenter(int centerId, int[] remainingData) {
		hasData = new boolean[999999];
		id = centerId + 1;
		readData(remainingData);
	}
	
	/**
	 * Return a string of all copy statements done to fill the gaps of data for this center
	 */
	public void retrieveData()
	{
		for (int i = 1; i < DataManagement.getMaxId(); i++)
		{
			if (!hasData[i])
			{
				System.out.println(i + " " + DataManagement.getData(i) + " " + id);
				DataManagement.addDataCenter(id, i);
			}
		}
	}
	
	/**
	 * Add a true in hasData for each data id it has
	 * @param remainingData An array of ints representing data set ids
	 */
	public void readData(int[] remainingData)
	{
		for (int i = 0; i < remainingData.length; i++)
		{
			//Keep track of how many data ids are in our set
			if (remainingData[i] > DataManagement.getMaxId())
				DataManagement.setMaxId(remainingData[i]);
			
			//Mark that this datacenter has this data
			hasData[remainingData[i]] = true;
			DataManagement.addDataCenter(id, remainingData[i]);
		}
	}
	
	/**
	 * @return The id of the data center
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * @return　Array of booleans representing which data sets the data center has
	 */
	public boolean[] getHasData()
	{
		return hasData;
	}

}
