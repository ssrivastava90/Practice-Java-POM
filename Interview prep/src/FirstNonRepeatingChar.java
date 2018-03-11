import java.util.LinkedHashMap;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNonRepeatingChar obj = new FirstNonRepeatingChar();
		System.out.println("Answer is " + obj.firstNonRepeatingCharacter("GeekmsforGeezks"));
	}

	
	char firstNonRepeatingCharacter(String str1) {
		
		//
		str1 = str1.toLowerCase();
		LinkedHashMap<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
		// putting str1 in HM
		for(char a:str1.toCharArray()) {
			if (hm.containsKey(a)){
				hm.put(a, hm.get(a)+1);
			}else {
				hm.put(a, 0);
			}
		}
		char ch='\0';
		for(char a:hm.keySet()) {
			if (hm.get(a)==0) {
				return a;
			}
		}
		return ch;
	}
}
