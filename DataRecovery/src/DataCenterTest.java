import static org.junit.Assert.*;

import org.junit.Test;


public class DataCenterTest {

	public void testDataCenter()
	{
		DataCenter testCenter = new DataCenter(0, null);
		
		assert(testCenter instanceof DataCenter && testCenter.getId() == 1);
		
	}
	
	@Test
	public void testReadData() {
		int testData[] = {3};
		DataCenter testCenter = new DataCenter(0, testData);
		
		assert(testCenter.getHasData()[3]);
	}
	
	@Test
	public void testRetrieveData() {
		int testData[] = {0, 1, 2, 3};
		DataCenter testCenter = new DataCenter(0, testData);
		
		testCenter.retrieveData();
		
		assert(DataManagement.getData(3) == 1);
	}
}
