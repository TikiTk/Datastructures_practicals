
public class BoyerMoore {

	public void getLast(String p, int lastInP[]) {
		
		
		int s = 256;
		int m = p.length();
		for(int j = 0; j < s; j++)
			lastInP[j] = -1;
		
		for(int j = 0; j < m; j++)
			lastInP[(int)(p.charAt(j))] = j;
		
	}
	
	public void setLastInP(String p, int lastInP[]) {
		
		int m = p.length();
		
		for(int i =0; i <256;i++)
			lastInP[i] = -1;
		for(int j =0; j < m;j++)
			lastInP[(int)(p.charAt(j))] = j;
		
	}
	
	public void resetLastInP(String p, int lastInP[]) {
		
		for(int i =0; i < p.length();i++){
				if(lastInP[(int)(p.charAt(i))] > 0)
					lastInP[(int)(p.charAt(i))] = -1;}
				
					
		}
	public int matchBM(String p, String T) {
		
		int m = p.length();
		int n = T.length();
		
		if(m == 0)
			return 0;
		else if( n == 0)
			return -1;
		else if(m > n)
			return -1;
		
		int s  =256;
		int last [] = new int[s];
		getLast(p, last);
		int i , j;
		i = j = m -1;
		
		do{
			if(p.charAt(j) == T.charAt(i)){
				if( j == 0){
					return i;
				}
				else{
						i--;
						j--;
				}
		
			
			}else
			{
				i = i+m - Math.min(j, 1+last[T.charAt(i)]);
				j = m - 1;
				
			}
		
		
	}while( i < n);
		return -1;
		
	}
	
	public static void main(String[]args)
	{
			BoyerMoore obj = new BoyerMoore();
			System.out.println(obj.matchBM("abba","ppppabba"));
	}
}
