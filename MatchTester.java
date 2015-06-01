import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.server.ObjID;
import java.util.Scanner;


public class MatchTester {
	
	public void BFMatch(String p, String T){
		
		BruteForce objBF = new BruteForce();
	    Scanner inputSteam = null;
        Scanner patternStream = null;
        String temp[];
		
		 try{
	        	inputSteam = new Scanner(new File(T));
	        	patternStream = new Scanner(new File(p));
	        }
	        catch(FileNotFoundException e)
	        {
	        	System.out.println("Error opening the file");
	        	System.exit(0);
	        }
		 	long endBF = 0;
			long startBF = System.currentTimeMillis();
			int countBF = 0;
			//========================================= Brute Force ================================================================
	        while(patternStream.hasNext() && (endBF - startBF)/1000.0 <= 1.0)
	        {
	        	String line = inputSteam.next();
	        	 String pattern = patternStream.next();
	        	temp = pattern.split(",");
	        	
	        	for(int i =0; i < temp.length;i++){
	        		String word = temp[i];
	        		if(objBF.matchBF(word, line) >= 0);
	        			countBF++;
	        	}
	        	
	        		
	        	
	        	endBF = System.currentTimeMillis();
	        	
	        
	        }
	        System.out.println("BF "+countBF+" "+(endBF-startBF) / 1000.0+" s");
	        inputSteam.close();
	        patternStream.close();
	      
	        
		
	}
	
	public void KMPMatch(String p, String T){
		

		KMP objKmp = new KMP();
	    Scanner inputSteam = null;
        Scanner patternStream = null;
        String temp[];
		
		 try{
	        	inputSteam = new Scanner(new File(T));
	        	patternStream = new Scanner(new File(p));
	        }
	        catch(FileNotFoundException e)
	        {
	        	System.out.println("Error opening the file");
	        	System.exit(0);
	        }
		 	long endBF = 0;
			long startBF = System.currentTimeMillis();
			int countBF = 0;
			
	        while(patternStream.hasNext() && (endBF - startBF) /1000.0 <= 1.00)
	        {
	        	String line = inputSteam.next();
	        	 String pattern = patternStream.next();
	        	temp = pattern.split(",");
	        	
	        	for(int i =0; i < temp.length;i++){
	        		String word = temp[i];
	        		if(objKmp.matchKMP(word, line) >= 0);
	        			countBF++;
	        	}
	        	
	        		
	        	
	        	endBF = System.currentTimeMillis();
	        	
	        	
	        
	        }
	        System.out.println("KMP "+countBF+" "+(endBF-startBF) / 1000.0+" s");
	        inputSteam.close();
	        patternStream.close();
	      
	        
		
		
	}
	
	public void RK(String p, String T){
		
		RabinKarp objKarp = new RabinKarp();
	    Scanner inputSteam = null;
        Scanner patternStream = null;
        String temp[];
		
		 try{
	        	inputSteam = new Scanner(new File(T));
	        	patternStream = new Scanner(new File(p));
	        }
	        catch(FileNotFoundException e)
	        {
	        	System.out.println("Error opening the file");
	        	System.exit(0);
	        }
		 	long endBF = 0;
			long startBF = System.currentTimeMillis();
			int countBF = 0;
			
	        while(patternStream.hasNext() && (endBF - startBF)/1000.0 <= 1.0)
	        {
	        	String line = inputSteam.next();
	        	 String pattern = patternStream.next();
	        	temp = pattern.split(",");
	        	
	        	for(int i =0; i < temp.length;i++){
	        		String word = temp[i];
	        		if(objKarp.matchRK(word, line) >= 0);
	        			countBF++;
	        	}
	        	
	        		
	        	
	        	endBF = System.currentTimeMillis();
	        	
	        
	        }
	        System.out.println("RK "+countBF+" "+(endBF-startBF) / 1000.0+" s");
	        inputSteam.close();
	        patternStream.close();
	      
	        
	}
	
	public void BM(String p, String T){
		
		BoyerMoore objMoore = new BoyerMoore();
	    Scanner inputSteam = null;
        Scanner patternStream = null;
        String temp[];
		
		 try{
	        	inputSteam = new Scanner(new File(T));
	        	patternStream = new Scanner(new File(p));
	        }
	        catch(FileNotFoundException e)
	        {
	        	System.out.println("Error opening the file");
	        	System.exit(0);
	        }
		 	long endBF = 0 ;
		 
			long startBF = System.currentTimeMillis();
			int countBF = 0;
			
	        while(patternStream.hasNext() && ((endBF-startBF) /1000.0 <= 1.0))
	        {
	        	String line = inputSteam.next();
	        	 String pattern = patternStream.next();
	        	temp = pattern.split(",");
	        	
	        	for(int i =0; i < temp.length;i++){
	        		String word = temp[i];
	        		if(objMoore.matchBM(word, line) >= 0);
	        			countBF++;
	        	}
	        	
	        		
	        	
	        	endBF = System.currentTimeMillis();
	        	
	        
	        }
	        System.out.println("BM "+countBF+" "+(endBF- startBF) / 1000.0+" s");
	        inputSteam.close();
	        patternStream.close();
	      
	        
	}

	public static void main(String []args)
	{
		MatchTester obj = new MatchTester();
		obj.BFMatch("/export/home/notes/ds/lesMiserables/text.txt","/export/home/notes/ds/lesMiserables/text.txt");
		obj.RK("/export/home/notes/ds/lesMiserables/text.txt","/export/home/notes/ds/lesMiserables/text.txt");
		obj.BM("/export/home/notes/ds/lesMiserables/text.txt","/export/home/notes/ds/lesMiserables/text.txt");
		obj.KMPMatch("/export/home/notes/ds/lesMiserables/patterns.txt","/export/home/notes/ds/lesMiserables/text.txt");
	
	       
	        


			
	       
}
	}

