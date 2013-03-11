import static org.junit.Assert.*;

import org.junit.Test;


public class DataSetTest {

	@Test
	public void testDataSet() {
		DataSet dataSet = new DataSet(0);
		assert(dataSet instanceof DataSet && dataSet.getId() == 0);
	}

	//Tests that finding a new data center adds it to the array list
	@Test
	public void testFoundDataCenter() {
		DataSet dataSet = new DataSet(0);
		dataSet.foundDataCenter(1);
		
		assert(dataSet.getDataCenters().get(0) == 1);
	}

	//Tests that copyFrom returns a datacenter associated with the data set
	@Test
	public void testCopyFrom() {
		DataSet dataSet = new DataSet(0);
		dataSet.foundDataCenter(1);
		
		assert(dataSet.copyFrom() == 1);
	}

}
