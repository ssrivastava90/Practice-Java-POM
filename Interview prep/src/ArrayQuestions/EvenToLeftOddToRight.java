package ArrayQuestions;

public class EvenToLeftOddToRight {

    public static void main(String args[]){

        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        EvenToLeftOddToRight evenToLeftOddToRight = new EvenToLeftOddToRight();
        for(int a: evenToLeftOddToRight.seggregate(arr)){
            System.out.print(a + ",");
        }

    }

    private int[] seggregate(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while (start<end){

            while(arr[start]%2!=0){
                start++;
            }
            while(arr[end]%2==0){
                end--;
            }

            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;

    }

}



