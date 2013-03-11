import java.util.Scanner;

public class DataRecoveryDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the number of data centers you have, followed by the data ids each center has:");
		
		int numCenters = scan.nextInt();
		
		//Represents each data center and the data it has
		int remainingData[][] = new int[numCenters][];
		
		for (int i = 0; i < numCenters; i++)
		{
			//Get all data ids from std in and then make a new int array for that data center
			scan = new Scanner(System.in);
			String dataIds = scan.nextLine();
			if (dataIds.compareTo("") != 0)
			{
				String[] dataIdsArray = dataIds.split(" ");
				remainingData[i] = new int[dataIdsArray.length];
				for (int j = 0; j < dataIdsArray.length; j++)
				{
					remainingData[i][j] = Integer.parseInt(dataIdsArray[j]);
				}
			}
			else
				remainingData[i] = new int[0];
			
		}
		
//		int remainingData[][] = {{1, 3, 5, 4}, {1, 2, 3}, {1, 3, 7, 8}, {1, 6, 4, 2}};
		DataCenter dataCenters[] = new DataCenter[remainingData.length];
		
		for (int i = 0; i < remainingData.length; i++)
		{
			dataCenters[i] = new DataCenter(i, remainingData[i]);
		}
		
		for (int i = 0; i < dataCenters.length; i++)
		{
			dataCenters[i].retrieveData();
		}
	
		System.out.println("done");
	}
}
