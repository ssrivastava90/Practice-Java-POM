import java.util.ArrayList;
import java.util.HashMap;

public class StringDegreeQuestion2 {
char ch;
int freq;
ArrayList<Character> chSet;

	public static void main(String args[]) {
	String str = "abcaadebbb";
	StringDegreeQuestion2 obj = new StringDegreeQuestion2();
	System.out.println(obj.getMinSubstringDegree(str));
	}
	
	public String getMinSubstringDegree(String str) {
		
		String result="";
		int subArrLen = Integer.MAX_VALUE;
		// Get Degree
		ArrayList<Character> charList = highestDegree(str);
		for(char ch:charList) {
			char[] chArr = str.toCharArray();
			int start=-1,end=-1;
			for(int i=0;i<chArr.length;i++) {
				if(chArr[i]==ch) {
					start = i;
					break;
				}
			}
			
			for(int j=chArr.length-1;j>=0;j--) {
				if(chArr[j]==ch) {
					end = j;
					break;
				}
			}
			if ((str.substring(start, end+1)).length()<subArrLen) {
				result = str.substring(start, end+1);
				subArrLen = result.length();
			}

	}
		return result;
	}
	
	private ArrayList<Character> highestDegree(String str) {
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
		for(char c:hm.keySet()) {
			if(hm.get(c)>degree) {
				degree = hm.get(c);
				highest = c;
			}
		}
		// get all character with same highest frequency
		ArrayList<Character> charList = new ArrayList<Character>();
		for(char c:hm.keySet()) {
			if(hm.get(c)==degree) {
				charList.add(c);
			}
		}
		
		return charList;
	}
}
