public class BruteForce{
	
	public int matchBF(String p, String t){
	
	int m = p.length();
	int n = t.length();
	int i = 0, found = -1;
	
	while(found < 0 && i <= n-m){
	
		int j = 0;
		while(j < m && p.charAt(j)  == t.charAt(i+j))
			j++;
		if(j == m)
			found = i;
		i++;
		}
	return found;
	}

public static void main(String [] args)
{
	BruteForce obj = new BruteForce();
	
	System.out.println(obj.matchBF("abba","acccbbannannaccabbaass"));
}
}
