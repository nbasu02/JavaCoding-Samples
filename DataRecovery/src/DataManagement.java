/**
 * Static class to keep track of all of the data centers in our system
 * and how many data sets we have
 * @author Neil Basu
 */

public class DataManagement {
	static private DataSet dataSets[] = new DataSet[999999];
	static private int maxId;

	public DataManagement()
	{
		//Each of these data source indices are a data id
		//The value is the data center it can be found in
	}
	
	/**
	 * @param newmax Keeps track of maximum data set id
	 */
	static void setMaxId(int newmax)
	{
		maxId = newmax;
	}

	/**
	 * @return　Largest data set id
	 */
	static int getMaxId()
	{
		return maxId;
	}
	

	/**
	 * When a data source object is created, i.e. we found a center with a piece of data
	 * we didn't previously have, we add it to the master list
	 * @param newDataSet New data set to be added to our collection
	 */
	static void addDataId(DataSet newDataSet)
	{
		dataSets[newDataSet.getId()] = newDataSet;
	}
	
	/**
	 * @param center Data center id
	 * @param dataId Data set id, corresponding to array dataSets.  If it is null, addDataId gets called
	 */
	static void addDataCenter(int center, int dataId)
	{
		if (dataSets[dataId] == null)
			DataManagement.addDataId(new DataSet(dataId));

		dataSets[dataId].foundDataCenter(center);
		
	}
	
	/**
	 * Find the datacenter we can copy from
	 * @param dataId Dataset id
	 * @return A data center with that data set
	 */
	static public int getData(int dataId)
	{
		return dataSets[dataId].copyFrom();
	}
}
