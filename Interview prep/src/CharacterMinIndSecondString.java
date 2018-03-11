import java.util.HashMap;

public class CharacterMinIndSecondString {
	
	void firstCharMatch(String str1, String str2) {
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		// putting str1 in HM
		int ind=0;
		for(char a:str1.toCharArray()) {
			if (!hm.containsKey(a)){
				hm.put(a, ind);
			}
			ind++;
		}
		
		int min = Integer.MAX_VALUE;
		char c='\0';
		ind=0;
		for(char b:str2.toCharArray()) {
			if(hm.containsKey(b)) {
				if(hm.get(b)<min) {
					c = b;
					ind = hm.get(b);
				}
			}
		}
		System.out.println("Index is " + String.valueOf(ind+1) + " Character is " + c);
	}
	
	
	
	public static void main(String args[]) {
		CharacterMinIndSecondString obj = new CharacterMinIndSecondString();
		obj.firstCharMatch("geeksforgeeks", "set");
	}
}

