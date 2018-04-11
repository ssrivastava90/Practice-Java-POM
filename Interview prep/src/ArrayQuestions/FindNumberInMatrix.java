package ArrayQuestions;

public class FindNumberInMatrix {

    public static void main(String args[]){
        int[][] arr = {{50,45,40},{44,34,33},{30,20,15}};

//        int arr1[][] = new int[3][3];

        FindNumberInMatrix obj = new FindNumberInMatrix();
        int[] arr2 = (obj.findNumber(arr,33));
        System.out.print(arr2[0]+ " " +arr2[1]);
    }

    private int[] findNumber(int[][] arr, int num){
        int[] res = {0,0};
        int col=0;
        int row = arr.length-1;
        while ((row>=0)&&(num!=arr[row][col])&&(col>=0)){
            if (num<arr[row][col]){
                col++;
            }else if (num>arr[row][col]){
                row--;
            }else{
                res[0] = row;
                res[1] = col;
                return res;
            }
        }
        return res;
    }

}
