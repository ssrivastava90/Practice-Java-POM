package ArrayQuestions;


//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/

public class ArrangePositiveNegativeAlternate {

    public static void main(String aregs[]){

        int[] arr = {4,3,-5,2,-3,-1,9,99,100,-2};


        //Shifting all negatives to left
        int i = -1;
        for(int j=0;j<arr.length;j++){
            if (arr[j]<0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //swap positives and negatives
        int pos = i+1;
        int neg = 0;
        int n = arr.length;
        while((pos<n)&&(neg<n)){
            int temp = arr[pos];
            arr[pos] = arr[neg];
            arr[neg] = temp;
            pos++;
            neg = neg+2;
        }

        printArray(arr);

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
