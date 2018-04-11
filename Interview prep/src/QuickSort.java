//public class QuickSort {
//
//    public static void main(String args[]){
//
////        int[] arr = {8,2,6,9,3,1,94,4};
//        int[] arr = {8,2,6,9,4};
//
//        QuickSort quickSort = new QuickSort();
//        arr = quickSort.sort(arr,0,arr.length-1);
//
//        for(int i:arr){
//            System.out.print(i+ ",");
//        }
//    }
//
//    private int[] sort(int[] arr,int low, int high){
//
//        int p = partition(arr,low,high);
//        for(int i:arr){
//            System.out.print(i+ ",");
//        }
//        arr = sort(arr,low,p-1);
//        arr = sort(arr,p+1,high);
//
//        return arr;
//    }
//
//
//    private int partition(int[] arr,int low, int high){
//
//        int i = low-1;
//        System.out.println("low, high, i = " + low + " "  + high + " "  + i );
//        int pivot = arr[high];
//
//        // Swapping all number before pivot
//        for (int j=low;j<high;j++){
//            if (arr[j]<=pivot){
//                i++;
//                arr = swap(arr,i,j);
//            }
//
//        }
//
//        //Finally swapping the pivot
//        i++;
//        arr = swap(arr,i, high);
//
//        return i;
//    }
//
//
//    private static int[] swap(int[] arr, int i, int j){
//        int temp;
//        temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//
//        return arr;
//    }
//
//}


// Java program for implementation of QuickSort
class QuickSort
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        i++;
        arr = swap(arr,i,high);

        return i;
    }

        private static int[] swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    int[] sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            arr = sort(arr, low, pi-1);
            arr = sort(arr, pi+1, high);
        }

        return arr;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}