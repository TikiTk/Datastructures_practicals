
public class KMP {

	public void buildNext(String p, int [] next) {
		
		int m = p.length();
		
		next[0] = -2;
		next[1] = -1;
		
		for(int i = 2; i < m;i++){
				int j = next[i-1]+1;
				
				while(j >= 0 && p.charAt(i-1)!= p.charAt(j)){
					j = next[j]+1;
				}
				next[i] = j;
		}
		for(int j = 0; j < m;j++)
			next[j]++;
		
	}
	
	public int matchKMP(String p, String T) {
		
		int m = p.length();
		int n = T.length();
		
		if(m == 0)
			return 0;
		else if( n==0)
			return -1;
		else if( m > n)
			return -1;
		int i,j, next[] = new int[m+1];
		buildNext(p, next);
		i = 0;
		j = 0;
		while(i < n){
			if(p.charAt(j) == T.charAt(i)){
				
				i++;
				j++;
			}
			else{
				j = next[j];
				if( j < 0){
					j = 0; 
					i++;
				}
			}
			if(j == m)
				return i - m;
			
				}
	
			return -1;		
			}
		public static void main(String []args)
		{
			KMP obj = new KMP();
			System.out.print(obj.matchKMP("abbca", "ppppaabba"));
		}
	}

