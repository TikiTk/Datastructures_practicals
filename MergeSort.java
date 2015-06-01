import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MergeSort{
	int [] C;
	int n;
	
	public void sort(int[]a){
		C = a;
		n = C.length;
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
			
	
	private void makeHeap(int temp[]){
			C = temp;
			n = C.length-1;
			for(int i = n/2; i >=0;i--)
				heapify(i);}
		
	
	private void heapify(int i){
		
		int left = i*2;
		int right = left+1;
		int top = i;
		
		if( left<= n && C[left] > C[top])
			top = left;
	
		if (right <= n && C[right] >C[top])
			top = right;
		if(top != i){
			int temp = C[i];
			C[i] = C[top];
			C[top] = temp;
			
			heapify(top);}}
	
	public void heapSort(int[]A){
		C = A;
		makeHeap(A);
		int temp;
		for (int i = n; i >= 0;i--){
			temp = A[0];			
			A[0] = A[i];
			A[i] = temp;
			n -=1;
			heapify(0);}}
	public void run(String filename){
		
		
		Scanner inputStream = null;
		String line;
		String temp[] = new String[7];
		int [] intArray = null;
		
		try{
			inputStream = new Scanner(new File(filename));
			while( inputStream.hasNextLine()){
			line = inputStream.nextLine();
			temp = line.split(" "); 
			intArray = new int[temp.length];
			
			for(int i = 0; i < temp.length;i++)
				intArray[i] = Integer.parseInt(temp[i]);

			int intTemp[] = intArray;

			
			
			heapSort(intTemp);
			for(int i = 0; i < intTemp.length;i++)
				System.out.print(intTemp[i]+" ");
			System.out.println();
				
				
			sort(intArray);
			for(int i = 0; i < intArray.length;i++)
				System.out.print(intArray[i]+" ");
			System.out.println();}
			

			
			
		
			System.out.println();
			
		
			
			
		inputStream.close();}
		catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);}}
		

		

	
	public static void main(String[] args){

		
		MergeSort obj = new MergeSort();
		
		obj.run("fourlines.text");
		
	
	}
}	
				
									
