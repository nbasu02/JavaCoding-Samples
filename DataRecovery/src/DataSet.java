import java.util.ArrayList;


/**
 * The way this is set up is that we find one datacenter that has a certain piece of data
 * and copy it over to whichever ones don't have that data.  Alternate solutions include 
 * @author neilbasu
 *
 */
public class DataSet {
	private int dataId;
	//Go through each data center that has this data for better efficiency
	//This is an index, not an id
	private int currentCenter;
	//Array of data centers with this data
	private ArrayList<Integer> dataCenters;
	
	/**
	 * @param DataId Id for this data set
	 */
	public DataSet(int DataId)
	{
		dataId = DataId;
		currentCenter = 0;
		dataCenters = new ArrayList<Integer>();
	}
	
	/**
	 * Adds a data center with this data set to data set's list of data centers 
	 * @param datacenter Data center's id
	 */
	public void foundDataCenter(int datacenter)
	{
		dataCenters.add(datacenter);
	}

	/**
	 * @return An integer representing a data center id that this data set has.  Will return the next entry in the list next time it is called
	 */
	public int copyFrom()
	{
		int copyFrom = dataCenters.get(currentCenter);
		//Goes to next data center, since in real life the data copy would take time
		//so we want to stagger it
		currentCenter = (currentCenter + 1) % dataCenters.size();
		return copyFrom;
	}
	
	/**
	 * @return　This data set's id
	 */
	public int getId()
	{
		return dataId;
	}
	
	/**
	 * @return The counter for which data center in the dataCenters arraylist we will return next.
	 */
	public int getCurrentCenter()
	{
		return currentCenter;
	}
	
	/**
	 * @return Get the int array list of data center ids that have this data set
	 */
	public ArrayList<Integer> getDataCenters()
	{
		return dataCenters;
	}
}
