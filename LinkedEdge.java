
public class LinkedEdge {
	

		Edge top;
		
		public LinkedEdge()
		{
			top = null;
		}
		
		public void displayList()
		{
			Edge position = top;
			while(position!= null)
			{
				System.out.println("{ "+position.vertex+ " }");
				position = position.next;
				
			}
		}
		
		public void insert(Edge newD)
		{
			if(isEmpty())
			{
				top = newD;
			}
			else
			{
				Edge position = top;
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
			Edge position = top;
			int count = 0;
			while(position!=null)
			{
				count++;
				if(position.vertex.equals(k))
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
		public String getVertex()
		{
			return top.vertex;
		}
		
	}



