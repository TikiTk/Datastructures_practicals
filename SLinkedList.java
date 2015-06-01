import javax.swing.text.Position;


public class SLinkedList {

	Node head;
	int size;
	public SLinkedList()
	{
		head = new Node("","",0);
		size =+1;
	}
	public  void addToTail(Node p)
	{
		Node position = head;
		while(position != null)
		{
			if(position.getNext()==null)
			{
				position.setNext(p);
				size+=1;
				break;
			}
			position = position.getNext();
		}
	}
	
	public Node removeHead()
	{
		Node temp = head;
		if(head.getNext() == null)
		{
			head = null;
			size-=1;
			
		}
		else
		{
			
			head = head.getNext();
			size-=1;
		}
		return temp;
	}
	public int getSize()
	{
		return size;
	}
	
	}


