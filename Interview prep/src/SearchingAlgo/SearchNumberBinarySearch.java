package SearchingAlgo;

public class SearchNumberBinarySearch {

    public static void main(String args[]){
        SearchNumberBinarySearch searchNumberBinarySearch = new SearchNumberBinarySearch();
        int[] arr = {3,6,9,12,15,33,66,78,83};
        System.out.print(searchNumberBinarySearch.findNumber(arr,0,arr.length-1,9));
    }


    private int findNumber(int[] arr, int start, int end, int x){
        if(end>=start){

            int mid = 1+((end-start)/2);

            if (arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                return findNumber(arr,mid+1,end,x);
            }else{
                return findNumber(arr,start,mid-1,x);
            }
        }
    // if element not found
    return -1;
    }
}


