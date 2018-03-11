package SearchingAlgo;

public class SqareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOperations obj = new NumberOperations();
		System.out.println(String.valueOf(obj.getSquareroot(145)));
	}

}

class NumberOperations{
	int getSquareroot(int num) {
		int min=0,max=num;
		int mid=0;
		if (num==0 || num==1) {
			return num;
		}
		
		while (min<=max) {
		mid = (min+max)/2;
		
		if (mid*mid==num) {
			return mid;
		}
		
		if(mid*mid<num) {
			min = mid;
//			max = num;
			
		}else {
			max = mid-1;
		}
		}
		return mid;
}
}