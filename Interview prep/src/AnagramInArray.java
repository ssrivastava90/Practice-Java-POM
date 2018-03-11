import java.util.Arrays;
import java.util.LinkedHashMap;

public class AnagramInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"bca","def","cba","abc","xyz","de","fed"};
		AnagramInArray obj = new AnagramInArray();
		obj.isAnagramInArray(str);
	}

	
	void isAnagramInArray(String[] inp) {
		LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
		int c = 0;
		int i = 0;
		for (String st:inp) {
			char[] arr = st.toCharArray();
			Arrays.sort(arr);
			String sortedstr = new String(arr);
			if(hm.containsKey(sortedstr)){
				System.out.println(inp[hm.get(sortedstr)] + " is anagram of " + inp[c]);
			}else {
				hm.put(sortedstr,i);
				i++;
			}
			c++;
			}
	}
		}
	



