package ArrayQuestions;

public class SortRGB {

	void seggregateRGB(String str) {
		char[] ch = str.toCharArray();
		int high = ch.length-1;
		int low=0,mid=0;
		
		while(mid<=high) {
			switch (ch[mid]) {
			case 'r':
				ch = swap(ch, mid,low);
				mid++;
				low++;
				break;
				
			case 'g':
				mid++;
				break;
				
			case 'b':
				ch = swap(ch, high,mid);				
				high--;
				break;
			}
		}
		
		String ans = new String(ch);
		System.out.println(ans);		
	}
	
	private char[] swap(char[] arr1, int mid, int low) {
		char temp;
		temp = arr1[mid];
		arr1[mid] = arr1[low];
		arr1[low] = temp;
		return arr1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortRGB obj = new SortRGB();
		obj.seggregateRGB("rgrgrgrgbbbb");
	}

}
