import java.util.Hashtable;


public class compareHash {
	
	
	int collision = 0;
	LinkedData [] table = new LinkedData[11];
	int load = 0;
	Data hashT[][] = new Data[11][11];
	public compareHash()
	{
		for(int i = 0;i<table.length;i++)
		{
			table[i] = new LinkedData();
		}
	}
	public void hash(String k)
	{
		
		
		int hashValue = (1562381 * intify(k) + 8394223) % table.length;
		
		
		insertHash(hashValue,k);
		insert(hashValue,k);
	
		
	}
	public boolean lookUp(String k)
	{
		int hashValue = (1562381 * intify(k) + 8394223) % table.length;
		if(table[hashValue].isEmpty())
			return false;
		else
		{
			System.out.print("Row "+hashValue);
			table[hashValue].search(k);
			return true;
			
		}
		
		
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
		
		if(table[value].isEmpty())
		{
			
			Data temp = new Data(word,value);
			table[value].insert(temp);
			
				
		}
		else
		{
			collision++;
			table[value].insert(new Data(word,value));
		}
	
		
	
	}
	public void insertHash(int value, String word)
	{
		int index = 0;
		if(hashT[value][index]== null)
		{
			hashT[value][index] = new Data(word,value);
			
		}
		else
		{
			collision++;
			for(int i = 0; i < hashT.length;i++)
			{
				if(hashT[value][i] == null){
					hashT[value][i] = new Data(word,value);
					break;
				}
			}
		}
	}
	
	public void printT()
	{
		for(int i = 0;i<hashT.length;i++)
		{
			for(int j = 0; j <hashT.length;j++)
			{
				if(hashT[i][j] == null)
				{
					System.out.print("");
				}
				else
					System.out.println("Index  "+i+" row "+j+" "+hashT[i][j].key);
			}
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
				System.out.println("Index "+i);
				table[i].displayList();
				
				
		}
		System.out.println();
		System.out.println("Number of collisions "+collision);
		System.out.println("The load factor is "+((float)load/(float)table.length));
		
	}
	public boolean locate(String word)
	{
		
			int hashValue = (1562381 * intify(word) + 8394223) % table.length;
			for(int i = 0; i < hashT.length;i++)
			{
				if(hashT[hashValue][i] == null)
					return false;
				else
				{
					for(int j = 0; j < hashT.length;j++)
					{
							if(hashT[hashValue][i].key.equals(word))
							{
								System.out.println("Row "+hashValue+" column "+i);
								return true;
							}
					}
						
					
				}
			
			}
			return false;
			
		
		
	}

	
	public static void main(String[] args)
	{
		compareHash obj = new compareHash();
		obj.run("peter went to visit craig in paris");
		System.out.println(obj.lookUp("peter"));
		obj.locate("in");
		obj.printT();
		obj.print();
		
	}
			
}
