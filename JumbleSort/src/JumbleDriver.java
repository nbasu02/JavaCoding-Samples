import java.util.Scanner;


public class JumbleDriver {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a sequence of integers and words separated by spaces:");
		
		String input = scan.nextLine();
		
		String[] inputSeparated = input.split(" ");
		JumbleSorter jumbler = new JumbleSorter();
		for (int i = 0; i < inputSeparated.length; i++)
		{
			jumbler.insert(inputSeparated[i]);
		}
		
		String[] output = jumbler.sort();
		
		for (int i = 0; i < output.length; i++)
			System.out.println(output[i]);
	}
}
