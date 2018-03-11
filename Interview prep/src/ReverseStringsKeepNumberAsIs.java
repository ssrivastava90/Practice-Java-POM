import java.util.ArrayList;
import java.util.HashSet;

public class ReverseStringsKeepNumberAsIs {
	HashSet<String> hs = new HashSet<String>();
	
	ReverseStringsKeepNumberAsIs(){
		this.hs.add("+");
		this.hs.add("-");
		this.hs.add("*");
		this.hs.add("/");
		this.hs.add("%");
		this.hs.add("^");
		this.hs.add("\\");
	}
	
	String reversalNumSame(String str) {
		// 1+2*3-20
		String[] brokenStr = (str+" ").split("");
		// can be used str+"".toCharArray()
		String result="",temp="";
		for (String c:brokenStr) {
			if ((this.hs.contains(c)) || (c.equalsIgnoreCase(" "))) {
				result = c + temp + result;
				temp="";
				c = "";
			}
			temp = temp + c;
		}
		return result.trim();
		
	}
	
//	String reversalNumSame(String str) {
//		// 1+2*3-20
//		String[] brokenStr = (str+"@").split("");
//		String result="",temp="";
//		ArrayList<String> num = new ArrayList<>();
//		ArrayList<String> oper =  new ArrayList<>();;
//		for (String c:brokenStr) {
//			if ((this.hs.contains(c)) || (c.equalsIgnoreCase("@"))) {
//				num.add(temp);
//				oper.add(c);
//				c = "";
//				temp = "";
//			}
//			temp = temp + c;
//		}
//		
//		for (int i=num.size()-1;i>=0;i--) {
//			if(i>=2) {
//				result = result + num.get(i) + oper.get(i-2);
//			}else {
//				result = result + num.get(i);
//			}
//		}
//		
//		return result;
//		
//	}
	
}
