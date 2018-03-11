import java.util.HashMap;

public class StringDegreeQuestion {
char ch;
int freq;
	public static void main(String args[]) {
	String str = "abcaadeb";
	StringDegreeQuestion obj = new StringDegreeQuestion();
	System.out.println(obj.getMinSubstringDegree(str));
	}
	
	public String getMinSubstringDegree(String str) {
		
		
		// Get Degree
		highestDegree(str);
		
		char[] chArr = str.toCharArray();
		int start=-1,end=-1;
		for(int i=0;i<chArr.length;i++) {
			if(chArr[i]==this.ch) {
				start = i;
				break;
			}
		}
		
		for(int j=chArr.length-1;j>=0;j--) {
			if(chArr[j]==this.ch) {
				end = j;
				break;
			}
		}
		return str.substring(start, end+1);
	}
	
	private void highestDegree(String str) {
	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
	// Creating the HM
	for(char c: str.toCharArray()) {
		if(hm.containsKey(c)) {
			hm.put(c, hm.get(c) + 1);
		}else {
			hm.put(c, 0);
		}	
	}
	
	int degree = 0;
	char highest = '\0';
	for(char c:hm.keySet()) {
		if(hm.get(c)>degree) {
			degree = hm.get(c);
			highest = c;
		}
	}
	
	this.ch = highest;
	this.freq = degree;
	}
}
