
public class HuffmanQueue {

	
	HuffmanNode head;
	int size;
	public HuffmanQueue()
	{
		head = null;
		size = 0;
	}
	
	public void addToQueue(HuffmanNode p)
	{
		HuffmanNode position = head;
		if (position == null)
		{
			head = p;
			size+=1;
		}
		else{
		while(position != null)
		{
				if(position.getNext() == null){
					position.setNext(p);
					size+=1;
					break;
				}
				
				position = position.getNext();
				
		}
		}
		
	}
	protected char[] charArray(String T)
	{
		int size = T.length();
		char characters[] = new char[size];
		for(int i =  0; i < size; i++)
			characters[i] = T.charAt(i);
		return characters;
	}
	
	public int[] compress(String T){
		int frequency [] = new int[256];
		char tmp[] = charArray(T);
		for(int i = 0; i < tmp.length;i++)
		{
			frequency[tmp[i]]++;
		}
	
		return frequency;
	}
	
	public HuffmanQueue makeQueue(int[] freq)
	{
		
		
		
		HuffmanQueue theQueue = new HuffmanQueue();
		for(char i = 0; i <256;i++)
		{
			//System.out.print(tmpFre[i]);
			if(freq[i] > 0){
				theQueue.addToQueue((new HuffmanNode(i+"",freq[i])));
				size+=1;
				
			}
		}
		theQueue.printout();
		return theQueue;
	}
	
	public  HuffmanQueue sortQueue(HuffmanQueue p)
	{
		if(p.isEmpty())
			return p;
		else
		{
			HuffmanNode tmp[] = new HuffmanNode[p.getSize()];
			HuffmanNode position = head;
			int count = 0;
			
			while(position!= null)
			{
				tmp[count] = position;
				System.out.println(tmp[count]+" This is the current value at count");
				count++;
				position = position.getNext();
				
				
			}
			sort(tmp);
			for(int i = 0; i < tmp.length;i++)
				System.out.print(tmp[i].getText()+" "+tmp[i].getFrequency());
			
		}
		return null;
		
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
	public HuffmanNode delete()
	{
		HuffmanNode temp = head;
		
		head = head.getNext();
		size-=1;
		return temp;
		
		
	}
	public int getSize()
	{
			return size;
	}
	
	public HuffmanNode getHead(HuffmanQueue p)
	{
		return head;
	}
	public void printout()
	{
		HuffmanNode position = head;
		
		while(position != null)
		{
		
			System.out.println(position.getText()+" "+position.getFrequency());
		
			position = position.getNext();
		}
		
	}
//====================================Sorting==================================
	public void sort(HuffmanNode [] a){
		
	
		if(a.length >=2){
			int middle = a.length/2;
			HuffmanNode[] left = new HuffmanNode[middle];
			
			HuffmanNode[] right = new HuffmanNode[a.length-middle];
			
			divide(a,left,right);
			sort(left);
			sort(right);
			merge(a,left,right);}}
	
	
	private void divide(HuffmanNode []a, HuffmanNode[] left, HuffmanNode[] right){
			
			for(int i = 0;i <  left.length ;i++)
				
				left[i] = a[i];
				
		
			for(int i = 0; i < right.length;i++)
				right[i] =a[i+left.length];
				
				
				}
	
	private void merge(HuffmanNode[]a, HuffmanNode[]left, HuffmanNode[]right){
		int i = 0,j = 0,k = 0;
		while((i < left.length) && (j < right.length)){
			if(left[i].getFrequency() < right[j].getFrequency()){
				a[k] = left[i];
				i++;
				k++;
				}
			else{
				a[k] = right[j];
				j++;
				k++;
				}}
		
		while(i < left.length){
			a[k] = left[i];
			i++;
			k++;}
		while( j < right.length){
			a[k] = right[j];
			j++;
			k++;}}
	
//==============================================================================
	
	
	public static void main (String []args)
	{
		HuffmanQueue obj = new HuffmanQueue();
		int [] freq  = obj.compress("feed me more food");
	
	   HuffmanQueue	tmp = obj.makeQueue(freq);
		System.out.println(tmp.getSize());
		tmp = obj.sortQueue(tmp);
		System.out.println(obj.getHead(tmp));
		//obj.printout();
		
		//System.out.println(obj.isEmpty());
	}
	
}
