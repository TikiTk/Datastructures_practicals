public class MergeSort1{

	int maxHeap;
	int A[] = null;

	public void sort(int[]a){
		if(a.length >=2){
			int middle = a.length/2;
			int[] left = new int[middle];
			
			int[] right = new int[a.length-middle];
			
			divide(a,left,right);
			sort(left);
			sort(right);
			merge(a,left,right);}}
	
	private void divide(int []a, int[] left, int[] right){
			
			for(int i = 0;i <  left.length ;i++)
				
				left[i] = a[i];
				
		
			for(int i = 0; i < right.length;i++)
				right[i] =a[i+left.length];
				
				
				}
	
	private void merge(int[]a, int[]left, int[]right){
		int i = 0,j = 0,k = 0;
		while((i < left.length) && (j < right.length)){
			if(left[i] < right[j]){
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
			
	public boolean checkOrder(int[] H, int sizeH, int[] M, int sizeM){
			
			boolean flag = false;
			for(int i =0; i < sizeH-1;i++){
				if(H[i] < H[i+1])
					flag = true;
				else
					flag = false;}
			
			for(int i = 0; i < sizeM-1;i++){
				if(M[i] < M[i+1])
					flag = true;
				else
					flag = false;}
			
			return flag;}
			
	
	public void makeHeap(int temp[]){
			
			A = temp;
			maxHeap -=1;
			for(int i = maxHeap/2; i >=0;i--)
				heapify(i);
			{
	
	private void heapify(int i){
		
		int left = i*2;
		int right = left+1;
		int top = i;
		
		if( left< maxHeap && A[left] > A[top])
			top = left;
	
		if (right < maxHeap && A[right] > A[top])
			top = right;
		if(top != i){
			int temp = A[i];
			A[i] = A[top];
			A[top] = temp;
			
			heapify(top);}}
	
	public void heapSort(int[]A){
		int temp;
		makeHeap(A);
		for(int i = maxHeap; i>0; i--){
			 temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			maxHeap-=1;
			heapify(1);
			}
		}
		

	
	public static void main(String[] args){
		
		MergeSort1 obj = new MergeSort1();
		int[]B ={12,23,9,7,2,6,34,13,11};
		int[]C ={12,23,9,7,2,6,34,13,11,0};
		obj.sort(B);
		//obj.heapSort(C);
		
		System.out.println(obj.checkOrder(B,B.length,C,C.length));
		/**for (int i =0;i < B.length;i++){
			System.out.print(B[i]+" ");
			}*/
		obj.makeHeap(C);
		System.out.println();
		//for (int i =0;i < C.length;i++){
		
		//	System.out.print(C[i]+" ");}
	
	}
}	
				
									
