import java.util.Scanner;
public class Range
{
	public static void main(Strings []args)
	
	{
		Scanner keyboard = new Scanner();
		System.out.print("Enter a number ");
		
		int input =  keyboard.nextInt();
		int smallest = input;
		int largest = 0;
		while(input != 0)
		{
			if(input < smallest)
				smallest = input;
			else if(input > largest && input != 0)
				largest = input;
			System.out.print("Enter a number ");
			input = keyboard.nextInt();
		}
	}
}

			