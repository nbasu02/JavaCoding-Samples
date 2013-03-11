import java.util.Scanner;


public class MakeChangeDriver {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a dollar and cents amount:");
		
		double money = scan.nextDouble();
		
		String output = new ChangeNode(Change.makeBestChange(money)).makeChange();
		System.out.println(Change.numCombos());
		
		if (!(args.length > 0 && args[0].compareTo("-n") == 0))
			System.out.println(output);
	}

}
