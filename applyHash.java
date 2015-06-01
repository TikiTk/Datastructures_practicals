import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;


public class applyHash {
	
	
	

	public static void main(String []args) throws FileNotFoundException
	{
		Hashtable table = new Hashtable();
		table.put("123".hashCode(), "123");
		
		String entireFile = new Scanner(new File("ulysses.text")).useDelimiter("\\Z").next();
		String temp[] = entireFile.split(" ");
		
		
		
		int frequency [] = new int[temp.length];
		int [] count = new int[frequency.length];
		for(int i = 0; i < temp.length;i++)
		{
			frequency[count[i]]++;
		}
		
		for(int i = 0; i < count.length;i++)
			System.out.println(count[i]);
			
		
		
		
	}
	

}
