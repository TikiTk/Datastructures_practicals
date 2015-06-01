public class TM
{
	String arr[] = new String[4];
	static int pointer = 0;
	String text = "pointer#pointer ";
	static String []temp = {"1","#","1"," "};
	private void state1(String array[])
	{
		
		if(temp[pointer].equals("0"))
		{
			arr[pointer] = "x";
			pointer++;
			state2(arr);
			
			
		}
		else if( temp[pointer].equals("1"))
		{
			arr[pointer] = "1";
			pointer++;
			state3(arr);
			
		}
		else if( temp[pointer].equals("x"))
			System.out.println("Reject");
		else if( temp[pointer].equals( "#"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state8(arr);
		}
		else if(temp[pointer].equals(" "))
			
			System.out.println("Reject");
	}

	private void state2(String array[])
	{
		
		
		if(temp[pointer].equals( "0"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state2(arr);
			
		}
		else if( temp[pointer].equals( "1"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state2(arr);
		}
		else if( temp[pointer].equals( "x"))
			System.out.println("Reject");
		else if( temp[pointer].equals( "#"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state4(arr);
		}
		else if(temp[pointer].equals(" "))
			
			System.out.println("Reject");
	}
	private void state3(String array[])
	{
		
		if(temp[pointer].equals( "0"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state3(arr);
			
		}
		else if( temp[pointer].equals( "1"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state3(arr);
		}
		else if( temp[pointer].equals( "x"))
			System.out.println("Reject");
		else if( temp[pointer].equals( "#"))
		{
			arr[pointer] = ""+temp[pointer];
			pointer++;
			state5(arr);
		}
		else if(temp[pointer].equals(" "))
			
			System.out.println("Reject");
	}
	private void state4(String array[])
	{
		
		if(temp[pointer].equals( "0"))
		{
			arr[pointer] = "L";
			pointer--;
			state6(arr);
			
		}
		else if( temp[pointer].equals( "1"))
		{
			
			System.out.println("Reject");
			
		}
		else if( temp[pointer].equals( "x"))
		{
			arr[pointer] = "x";
			pointer++;
			state4(arr);
		}
		else if( temp[pointer].equals( "#"))
		{
		
			System.out.println("Reject");
			
		}
		else if(temp[pointer].equals(" "))
			
			System.out.println("Reject");
	}
	private void state5(String []array)
	{
		
		if(temp[pointer].equals( "0"))
		{
			
			System.out.println("Reject");
			
			
		}
		else if( temp[pointer].equals( "1"))
		{
			
			
			arr[pointer] = "x";
			pointer--;
			state6(arr);
			
		}
		else if( temp[pointer].equals( "x"))
		{
			arr[pointer] = "x";
			pointer++;
			state5(arr);
		}
		else if( temp[pointer].equals( "#"))
		{
		
			System.out.println("Reject");
			
		}
		else if(temp[pointer].equals(" "))
			
			System.out.println("Reject");
	}
	private void state6(String []array)
	{
		
		
		if(temp[pointer].equals("0"))
		{
			
			arr[pointer] = "0";
			pointer--;
			state6(arr);
			
			
		}
		else if( temp[pointer].equals( "1"))
		{
			
			
			arr[pointer] = temp[pointer];
			pointer--;
			state6(arr);
			
		}
		else if( temp[pointer].equals( "x"))
		{
			arr[pointer] = "x";
			pointer--;
			state5(arr);
		}
		else if( temp[pointer].equals( "#"))
		{
		
			arr[pointer] = "#";
			pointer--;
			state7(arr);
			
		}
		else if(temp[pointer].equals(" "))
			System.out.println("Reject");
		
	}
	private void state7(String array[])
	{
		
		if(temp[pointer].equals( "0"))
		{
			
			arr[pointer] = "0";
			pointer--;
			state7(arr);
			
			
		}
		else if( temp[pointer].equals( "1"))
		{
			
			
			arr[pointer] = temp[pointer];
			pointer--;
			state7(arr);
			
		}
		else if( temp[pointer].equals( "x"))
		{
			arr[pointer] = "x";
			pointer++;
			state1(arr);
		}
		else if( temp[pointer].equals( "#"))
		{
		
			
		System.out.println("Reject");
	
			
		}
		else if(temp[pointer].equals(" "))
			System.out.println("Accept");
		else
			System.out.println("Not accepted");
	}
	private void state8(String []array)
	{
		
		
		if(temp[pointer].equals( "0"))
		{
			
			
			pointer++;
			
			
			
		}
		else if(temp[pointer].equals( "1"))
		{
			
			
		
			pointer++;
			
			
		}
		else if(temp[pointer].equals("x"))
		{
			arr[pointer] = "x";
			pointer++;
			state8(arr);
		}
		else if( temp[pointer].equals( "#"))
		{
		
			
			pointer++;
			
			
		}
		else if(temp[pointer].equals(" "))
			System.out.println("Accept");
	}
	public void run(String[] arr)
	{
		while(pointer < arr.length)
		{
			state1(arr);
			System.out.println(pointer);
		}
	}
	public static void main(String[]args)
	{
		TM obj = new TM();
		obj.run(temp);
	}
}
	
