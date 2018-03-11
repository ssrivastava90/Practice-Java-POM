import java.util.LinkedHashMap;

public class LongestNonRepeatingString {

	
	void findLongestSubstr(String str) {
		LinkedHashMap<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
		char[] charString = str.toCharArray();
		String ans="";
		int longestint = 0;
		int counter = 0;
		for(char c:charString) {
			//Adding to HM
			if(hm.containsKey(c)) {
				System.out.println(String.valueOf(longestint) + " " + ans);
				ans="";
				longestint = 0;
			}else {
				hm.put(c, counter);
			}
			counter++;
			ans = ans + c;
			longestint++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestNonRepeatingString obj = new LongestNonRepeatingString();
		obj.findLongestSubstr("abcdaedfghiejklmnopqe");
	}

}
