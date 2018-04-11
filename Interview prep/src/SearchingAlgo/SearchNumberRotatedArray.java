package SearchingAlgo;

public class SearchNumberRotatedArray {

    public static void main(String args[]){
        SearchNumberRotatedArray searchNumberRotatedArray = new SearchNumberRotatedArray();
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int pivot = searchNumberRotatedArray.findPivot(arr,0,arr.length-1);
        int key = 7;
        System.out.print(pivot);
        if (arr[0]<key){
            System.out.print(searchNumberRotatedArray.findNumber(arr,0,pivot-1,key));
        }else{
            System.out.print(searchNumberRotatedArray.findNumber(arr,pivot+1,arr.length-1,key));
        }

    }


    private int findNumber(int[] arr, int start, int end, int x){
        while(start<=end){
            int mid = 1+ (end-start)/2;
            if (arr[mid]==x){
                return mid;
            }

            else if (arr[mid]>x){
                return findNumber(arr,mid+1,end,x);
            }else{
                return findNumber(arr,start,mid-1,x);
            }
        }
        return -1;
    }


    private int findPivot(int[] arr, int start, int end) {

        if (end == start) {
            return start;
        } else if (end < start) {
            return -1;
        } else {
            while (end > start) {
                int mid = (end + start) / 2;
                if ((mid < end) && (arr[mid] > arr[mid + 1])) {
                    return mid;
                }
                if ((mid > start) && (arr[mid - 1] > arr[mid])) {
                    return mid - 1;
                } else if (arr[mid] > arr[start]) {
                    return findPivot(arr, start, mid - 1);
                }
                return findPivot(arr, mid + 1, end);
            }

        }
    return -1;
    }

}
