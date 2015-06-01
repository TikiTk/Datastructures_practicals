public class Heap
{
	int A[];
	//int heapSize;
	
	public Heap()
	{
		
		//System.out.println(A.length);
	}
	
	public void makeHeap(int temp[])
	{
			
			int heapSize = temp.length;
			for(int i = heapSize; i >=0;i--)
				heapify(temp,i);
			for(int i = 0;i < heapSize;i++)
				System.out.print(temp[i]+" ");

	}
	private void heapify(int []arr, int i)
	{
		int heapSize = arr.length;
		int left = i*2;
		int right = left+1;
		int top = i;
		
		if( left< heapSize && arr[left] > arr[top])
			top = left;
	
		if (right < heapSize && arr[right] > arr[top])
			top = right;
		if(top != i)
		{
			int temp = arr[i];
			arr[i] = arr[top];
			arr[top] = temp;
			
			heapify(arr,top);
		}
		
	}
	private int[] swap(int[]arr, int i, int j)
	{
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = arr[temp];
		return A;
	}
	
	public static void main (String[] args)
	{
		Heap obj = new Heap();
		int B[] = {12,3,5,7,10,11,23};
		obj.makeHeap(B);
	}
}


		
			