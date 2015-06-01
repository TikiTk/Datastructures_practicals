
public class RabinKarp {
	
	public static int modHash = 65521;
	public static final int base = (Character.MAX_VALUE +1) % modHash;
	
	public int firstHash(String s) {
		
		int m = s.length();
		int j,h = 0;
		
		for(j = 0; j < m;j++){
				h = mod(h*base);
				h = mod(h+ s.charAt(j));
		}
		return h;
		
		
		
	}
	
	public int hash(String s) {
		return firstHash(s);
		
	}
	
	public int baseLeftmost(String T) {
		int baseLeft = 1;
		
		for(int i = 1; i < T.length(); i++)
			baseLeft = mod(baseLeft*base);
		return baseLeft;
	}
	
	public int matchRK(String p, String T) {
		int m = p.length();
		int n = T.length();
		if(m > n)
			return -1;
		int pHash = hash(p);
		int THash = hash((String)T.subSequence(0, m));
		int baseLeft = baseLeftmost(p);
		
		for(int i = 0;i+m <= n;i++){
				if(THash == pHash){
						if(stringCompare((String)T.subSequence(i, i+m),p));
						return i;
						
				}
				if(i == n-m)
					return -1;
				THash = mod(THash - mod(baseLeft * T.charAt(i)));
				
				THash = mod(mod(THash*base)+T.charAt(i+m));
		}
		return -1;
	}
	private boolean stringCompare(String T, String p) {
		
		int m = p.length();
		int n = T.length();
		if( m!= n)
			return false;
		for(int i = 0; i < m;i++){
				if(p.charAt(i)!= T.charAt(i))
					return false;
				
		}
		
		return true;
	}

	private int mod(int i) {
		int modulo = i % modHash;
		if(modulo < 0)
			return modulo + modHash * (1+ (-modulo/modHash));
		else
			return modulo;
	}
	

public static void main(String[]args){
		RabinKarp obj = new RabinKarp();
		System.out.println(obj.matchRK("abba",""));
}
		
	}


