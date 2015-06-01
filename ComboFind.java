/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combofind;

import java.util.Random;

public class ComboFind {

    private int[] a;
    private int n;
    
    int heapComp=0;
    int partComp=0;
    public ComboFind() {
    }

    public int getHeapComp() {
        return heapComp;
    }
    
    public void swap(int a[], int i, int k) {
        int tmp = a[i];
        a[i] = a[k];
        a[k] = tmp;
    }
//==============================================================================
    //brutal sort:
    public int[] linearS(int a[]) {
        int brutComp=0;
        int maxIndx = 0;
        int[] max = {0,0,0};
        for (int i = 0; i < a.length; i++) {
            brutComp++;
            if (max[0] < a[i]) {
                max[0] = a[i];
                maxIndx = i;
            }
        }
        for (int i = 0; i < a.length; i++) {
            brutComp++;
            if (max[1] < a[i] && i != maxIndx) {
                max[1] = a[i];

            }
        }
        max[2]=brutComp;
        return max;
    }

//==============================================================================
    //Heap section:
    public int[] buildHeap(int[] a0) {
        heapComp=0;
        a = a0;
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(i);
        }
    
        return a0;
    }

    public void maxHeap(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;
     
        heapComp++;
        if (left <= n && a[left] > a[largest]) {

            largest = left;
        }
        //tmpNum++;
        if (right <= n && a[right] > a[largest]) {

            largest = right;
        }
        //tmpNum++;
        if (largest != i) {
            swap(a, i, largest);
            maxHeap(largest);
        }
    }
//==============================================================================
    //setting up arrays:
    public void LargeArr(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
    }

    public void SmallArr(int a[]) {
        int count = a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = count;
            count--;
        }
    }


    public void shuff(int a[]) {
        for (int i = 1; i < a.length+1; i++) {
            a[i-1]=i;
        }
        shuffleArray(a);
    }
    public void shuffleArray(int[] ar) {
        Random rnd = new Random();
        
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
	
	
	
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
//==============================================================================

    public static void main(String[] args) {
        int Larger[] = new int[10000];
        int Smaller[] = new int[10000];
        int Shuffle[] = new int[10000];
        ComboFind cFind = new ComboFind();
        cFind.LargeArr(Larger);
        cFind.SmallArr(Smaller);
        cFind.shuff(Shuffle);
        
        System.out.println();
        int LinearLarger[] = cFind.linearS(Larger);
        int LinearSmaller[] = cFind.linearS(Smaller);
        int ShuffleArr[] = cFind.linearS(Shuffle);
                
        System.out.println("Brutal search:\n");
        System.out.println("- Larger");
        System.out.println("Largest:\t " + LinearLarger[0] + "\nSecond largest:\t " + LinearLarger[1]+"\nComparisons:\t "+LinearLarger[2]+"\n");
        System.out.println("- Smaller");
        System.out.println("Largest:\t " + LinearSmaller[0] + "\nSecond largest:\t " + LinearSmaller[1]+"\nComparisons:\t "+LinearSmaller[2]+"\n");
        System.out.println("- Shuffle");
        System.out.println("Largest:\t " + ShuffleArr[0] + "\nSecond largest:\t " + ShuffleArr[1]+"\nComparisons:\t "+ShuffleArr[2]);
        System.out.println();

//===================================================================================
        System.out.println("Heap search: \n");
        
        int largeHeap[] = cFind.buildHeap(Larger);
        int smallHeap[] = cFind.buildHeap(Smaller);
        int shuffleHeap[] = cFind.buildHeap(Smaller);
        
        
       if(largeHeap[1]>largeHeap[2]){
           System.out.println("- Larger");
           System.out.println("second largest:\t " + largeHeap[1]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }
       else{
           System.out.println("- Larger");
           System.out.println("second largest:\t " + largeHeap[2]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }
       if(smallHeap[1]>smallHeap[2]){
           System.out.println("- Smaller");
           System.out.println("Second largest:\t " + smallHeap[1]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }
       else{
           System.out.println("- Smaller");
           System.out.println("Second largest:\t " + smallHeap[2]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }
       if(shuffleHeap[1]>shuffleHeap[2]){
           System.out.println("- Shuffle");
           System.out.println("Second largest:\t " + shuffleHeap[1]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }
       else{
           System.out.println("- Shuffle");
           System.out.println("Second largest:\t " + shuffleHeap[2]+"\nComparisons:\t "+cFind.getHeapComp()+"\n");
       }

        System.out.println();

//====================================================================================
        System.out.println("partition: \n");
        System.out.println("- Larger");
    }
}
