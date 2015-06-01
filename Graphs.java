
public class Graphs {

	LinkedEdge [] arr = new LinkedEdge[11];
	
	int collision = 0;

	int load = 0;

	public Graphs()
	{
		for(int i = 0;i<arr.length;i++)
		{
			arr[i] = new LinkedEdge();
		}
	}
	public int hash(String k, String direction)
	{
		
		
		int hashValue = (1562381 * intify(k) + 8394223) % arr.length;
		
		
		
		//insert();
		return hashValue;
	
		
	}
	public boolean lookUp(String k)
	{
		int hashValue = (1562381 * intify(k) + 8394223) % arr.length;
		if(arr[hashValue].isEmpty())
			return false;
		else
		{
			System.out.print("Row "+hashValue);
			arr[hashValue].search(k);
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
	
	public void insert(Edge node)
	{
		int value = hash(node.vertex, node.direction);
		
		if(arr[value].isEmpty())
		{
			
			arr[value].insert(new Edge(node.vertex));
			arr[value].insert(new Edge(node.direction,node.weight));
		
			
				
		}
		else
		{
			
			arr[value].insert(new Edge(node.direction,node.weight));
		}
		
	
		
	
	}
	
	public void print()
	{
		
		for(int i= 0; i < arr.length;i++)
		{
				System.out.println("Index "+i);
				arr[i].displayList();
				
				
		}

	}
	public static void main(String[] args)
	{
		Graphs obj = new Graphs();
		Edge A = new Edge(8, "LAX", "MIami");
		
		Edge B = new Edge(9, "SOH", "cpt");
		Edge C = new Edge(7, "SOH", "jhb");
	
		Edge D = new Edge(8,"SOH","BJK");
		obj.insert(A);
		obj.insert(B);
		obj.insert(C);
		obj.insert(D);
		obj.print();
		
		
	}
	
	
}
