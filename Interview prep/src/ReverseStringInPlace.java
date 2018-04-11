import java.io.*;

public class ReverseStringInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringInPlace obj = new ReverseStringInPlace();
//		obj.getInPlaceReverse("Hello Me now Shubham");
		obj.getInPlaceReverse("am");
	}
	
	
	void getInPlaceReverse(String str) {
		//Hello Me now Shubham
		String ans = "";
		int count = 0;
		for(char c:str.toCharArray()) {
            for (int i = 0; i < str.length(); i++) {
                ans = str.charAt(i) + ans;
                if ((str.charAt(i) == ' ') || (count == str.length() - 1)) {
                    System.out.print(ans + " ");
                    ans = "";
                }

                count++;
            }

//		int i=0;
//		char x,y;
//		int j = str.length()-1;
//
//        InputStream is = new ByteArrayInputStream(str.getBytes());
//        BufferedReader br = new BufferedReader (new InputStreamReader(is));
//
//		while(i<j) {
//            x = br.(i);
//            y = str.charAt(j);
//
//            x = x^y;
//            y = y^x;
//            x = x^y;
//
//
//			i++;
//			j--;
//			}
//
//			count++;
//		}

        }
	}

}
