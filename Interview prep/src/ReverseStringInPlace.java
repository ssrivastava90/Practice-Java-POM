
public class ReverseStringInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringInPlace obj = new ReverseStringInPlace();
		obj.getInPlaceReverse("Hello Me now Shubham");
	}
	
	
	void getInPlaceReverse(String str) {
		//Hello Me now Shubham
		String ans = "";
		int count = 0;
//		for(char c:str.toCharArray()) {
		for(int i=0;i<str.length();i++) {
			ans = str.charAt(i) + ans;
			if((str.charAt(i)==' ') || (count==str.length()-1)){
				System.out.print(ans + " ");
				ans = "";
			}
			
			count++;
		}
		
	}

}
