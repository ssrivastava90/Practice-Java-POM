import java.util.HashMap;
import java.util.TreeMap;

public class NonRepeatingCharString {

	String maxNonRepeating(String str) {
		
		TreeMap<Character,Integer> hp = new TreeMap<Character,Integer>();
		

		// Create HM
		char[] ch = str.toCharArray();
		for(char c:ch){
			if(hp.containsKey(c)){
				hp.put(c, hp.get(c)+1);
			}else {
				hp.put(c, 0);				
			}
		}
		
		// getting all characters one by one
		for(Character s: hp.keySet()) {
			
		}
		return str;
	}
	
	
}
