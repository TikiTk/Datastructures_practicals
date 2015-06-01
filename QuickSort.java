import java.util.Random;
public class QuickSort{
	

public  int[] sort(int[] array, int lower, int higher ){

    if(lower<higher){
        int pivot=partition(array,lower,higher);
        if(pivot>1)
            sort(array, lower, pivot-1);

        if(pivot+1<higher)
            sort(array, pivot+1, higher);


    }

    return array;

}
	
//makes an A of integers and shuffles the position of the integers in the A	


	public int[] makeArray(int n){
		int arr[] = new int[n];
		Random gen = new Random();
		for(int i = 0; i < n; i++)
			arr[i] = i+1;
		
		for(int i = 0; i < n; i++){
			int randomInt =gen.nextInt((n-i+1));
			
			swap(arr,randomInt,i);}
		
		return arr;}
		
	
	public int partition(int A[], int from, int to){
		
	while(from < to){
		int pivot=A[from];

		while(A[from]<pivot)
			from++;

		while(A[to]>pivot)
			to--;


		if(from<to)   
			swap(A,to,from);
    
		
    
	}
		return to;
	}

	private void swap(int A[], int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;}

public static void main(String []args){
	
	
	QuickSort obj = new QuickSort();
	int [] B = obj.makeArray(21);
	obj.sort(B,0,B.length-1);
	for(int i = 0; i < B.length;i++)
		System.out.print(B[i]+ " ");
	System.out.print(B[(int)(B.length/2)]);
	}}
	


