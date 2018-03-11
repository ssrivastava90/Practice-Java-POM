import java.util.ArrayList;

public class AllPalindromeInSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AllPalindromeInSubstring obj = new AllPalindromeInSubstring();
		obj.getAllPalindromeSubstr("abbaaaba");
		
	}

	void getAllPalindromeSubstr(String str) {
		int counter=0;
		ArrayList<String> palindromes = new ArrayList<String>();
		String tempStr = str;
		for(int i=0;i<str.length();i++) {
			for(int j=0;((i-j>=0) && (j+i<str.length())); j++) {
				if(str.charAt(i+j)!=str.charAt(i-j)) {
					break;
				}else {
					counter++;
//					palindromes.add(tempStr.substring(i+j, i-j));
				}
				
			}
			
		}
		
		// For even lettered palindromes
		for(int i=0;i<str.length();i++) {
			for(int j=0;((i+1-j>=0) && (j+i+1<str.length())); j++) {
				if(str.charAt(i+j+1)!=str.charAt(i+1-j)) {
					break;
				}else {
					counter++;
//					palindromes.add(str.substring(i+j, i-j));
				}
				
			}
			
		}
		System.out.println(counter);
//		for(String a:palindromes) {
//			System.out.println(a);
//		}
	}
	
}
