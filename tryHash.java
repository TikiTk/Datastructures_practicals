public class tryHash
{

	
	int collision = 0;
	Data [] table = new Data[11];
	int load = 0;
	public tryHash()
	{
		for(int i = 0;i<table.length;i++)
		{
			table[i] = new Data("",-1);
		}
	}
	public int hash(String k)
	{
		
		
		int hashValue = (1562381 * intify(k) + 8394223) % table.length;
		
		
		insert(hashValue,k);
		
		return hashValue;

		
	}

	private int intify(String word)
	{
		int value = 0;
		for(int i = 0; i<word.length();i++)
		{
			value = value + (int)(word.charAt(i));
		}
		return value;
	}
	
	public void insert(int value, String word)
	{
		int index = 0;
		if(table[value].key.equals(word))
		{
			
			System.out.println(word+" "+value);
		}
		else if(table[value].id == 0)
		{
			
			table[value] = new Data(word,value);
			
			
				
		}
		else if(table[value].id != 0)
		{
			collision++;
			
			while(!table[value].key.equals(""))
			{
				value = (value +  42589) % table.length;
			}
				
			table[value] = new Data(word,value);
		}
	
		
	
	}
	public int lookup(String text)
	{
		int count = 0;
		int value = hash(text);
		if(table[value].key.equals(text))
			return value;
		else
		{
			while(!table[value].key.equals(text))
			{
				value = (value +  42589) % table.length;
				
				
			}
			return value;
			
		}
		
	}
	public void run(String word)
	{
		String temp[] = word.split(" ");
		load = temp.length;
		for(int i = 0; i < temp.length;i++)
		{
			
			hash(temp[i]);
			
		
		}
	}

	public void print()
	{
		
		for(int i= 0; i < table.length;i++)
		{
				System.out.print(table[i].key+" ");
				
		}
		System.out.println();
		System.out.println("Number of collisions "+collision);
		System.out.println("The load factor is "+((float)load/(float)table.length));
		
	}
			

	public static void main(String [] args)
	{
		tryHash obj = new tryHash();
		obj.run("7 13 19 23 31 79 97 109 139");
		
		
		obj.print();
		System.out.println("Location of text "+obj.lookup("0"));
		
	}
}
		
