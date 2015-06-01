public class Polynomial
{

	 static int contains(String args[], char plus, char minus, char multiply,char exponent)
		{
			int temp = 0;
			for(int i = 0; i < args.length; i++)
			{
				if(args[i].equals(plus+""))
					temp = i;
				else if(args[i].equals(minus+""))
					temp = i;
				else if(args[i].equals(multiply+""))
					temp = i;
				else if(args[i].equals(exponent+""))
					temp = i;
			}

			return temp;
		}
	static void print(String args[], int [] result)
	{
		System.out.print("polynomial ");
		int x  = contains(args,'*','-','^','+');
		for(int i = 0; i <= x;i++)
		{
			System.out.print(args[i]+" ");
		}
		System.out.println();
		System.out.print("polynomial ");
		
		for(int i = 0; i < args.length;i++)
		{
			if(i <= x)
				System.out.print("");
			else
				System.out.print(args[i]+" ");
		}
	

		System.out.println();
		System.out.println("------------------------------");
		System.out.print("polynomial ");
		for(int i = 0; i < result.length;i++){
			if(result[i] == 0)
				System.out.print("");
			else
				System.out.print(result[i]+" ");}
		System.out.println();
	}
	 static int[] add(int[] left, int[] right, int[] result)
	{
			
		for(int i = right.length-1; i >= 0; i--)
		{
			int value = right[i] + left[i];
			result[i] = value;
		}
	
		
		return result;
	}

	static int[] minus(int[] left, int[] right, int[] result)
	{
		for(int i = right.length-1; i >= 0; i--){
				
			int value = left[i] - right[i];

			result[i] = value;
					}
		
		return result;
	}
	static int[] multiply(int[] left, int[] right)
	{
		int index = 0;
		int multiIndex = 0;
		int multiArray[] = new int[(right.length-1)+(left.length)];
		int rightTemp[];
		while(index < left.length)
		{
			for(int i = 0; i < right.length;i++)
			{
				int tempValue = left[index] * right[i];
				if(multiArray[index+i] != 0 )
				{
					int indexTemp = multiArray[index+i];
					multiArray[index+i] = tempValue+indexTemp;
				}
				else
					multiArray[index+i] = tempValue;
			
			}
			index++;
		}
	
		
		return multiArray;
	}
	
	static int[] makeRight(String[] args, int x)
	{
		String concRight = "";
		
		int right[] = new int[x];
		for(int i = x+1; i < args.length;i++)
			concRight+=args[i]+ " ";

		
		String concRightA[] = concRight.split(" ");

				
		int rightIndex = right.length-1;
		for(int i = concRightA.length-1; i >=0; i--)
		{
			right[rightIndex] = Integer.parseInt(concRightA[i]);
			rightIndex--;
		}
		return right;

	}
	static int[] makeLeft(String[] args, int x)
	{
		String conc = "";
		int left[] = new int[x];
		for(int i = 0; i < x;i++)
			conc+=args[i]+ " ";
		String concTemp[] = conc.split(" ");
		
		
		for(int i = concTemp.length-1; i >= 0;i--)
			left[i] = Integer.parseInt(concTemp[i]);
		return left;
	}
	
	public static void main(String args[])
	{
		
		int x = contains(args,'+','-','*','^');
		int[] right = makeRight(args,x);
		int[] left = makeLeft(args,x);
		
		int result [] = new int[x];
		
	

	
		
		String temp = args[x];
		char operand = temp.charAt(0);
		
		switch(operand)
		{
			case'+':
			{	
				
				add(left,right,result);
				print(args,result);
				break;
			}
			
			case'-':
			{
				
				minus(left,right,left);
				print(args,result);
				break;
				
			}
			case'*':
			{
				
				int multiArray[] = multiply(left,right);
				
				print(args,multiArray);
				break;
			}
			case'^':
			{
				String expoTemp = "";
				for(int i = x+1; i < args.length;i++)
					expoTemp+=args[i];
				System.out.println(expoTemp);
				int expo = Integer.parseInt(expoTemp.trim());
				int count = 1;
				int Array[] = new int[(right.length-1)+(left.length)];
				for(int i = 0; i < left.length;i++)
					Array[i] = left[i];
				for(int i = count; i < expo; i++){
					
					Array = multiply(Array,left);
				}
				//print(left,right,multiArray);
				break;
			}	
				
	
		}
		
		
			
	}
}
