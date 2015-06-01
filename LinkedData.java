
public class LinkedData {

	Data top;
	
	public LinkedData()
	{
		top = null;
	}
	
	public void displayList()
	{
		Data position = top;
		while(position!= null)
		{
			System.out.println("{ "+position.key+ " }");
			position = position.getNext();
			
		}
	}
	
	public void insert(Data newD)
	{
		if(isEmpty())
		{
			top = newD;
		}
		else
		{
			Data position = top;
			while(position!=null)
			{
				if(position.next == null)
				{
					position.next = newD;
					break;
					
				}
				position = position.next;
			}
		}
	}
	public int search(String k)
	{
		Data position = top;
		int count = 0;
		while(position!=null)
		{
			count++;
			if(position.key.equals(k))
			{
				break;
				
			}
			position = position.next;
			
		}
		System.out.println(" link number "+count);
		return count;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
	
}
