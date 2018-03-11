package ArrayQuestions;

public class KadanesTheorem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,66,22,3,72};
		KadanesTheorem obj = new KadanesTheorem();
		System.out.println(obj.maxDiff(arr));
	}
	

	String maxDiff(int[] intarr){
		int maxDiff = Integer.MIN_VALUE;
		int minValue = intarr[0];
		int i,j;
		String ans="";
		for (i=0;i<intarr.length;i++){			
			if (intarr[i]-minValue>maxDiff){
					maxDiff = intarr[i]-minValue;
				}
			if (intarr[i]<minValue) {
				minValue = intarr[i];
			}
	}
		return String.valueOf(maxDiff);
	}
}