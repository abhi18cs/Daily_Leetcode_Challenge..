//1.quick sort tc=O(n^2)
// class Solution {
//     public int[] sortArray(int[] nums) {
//         quick(nums,0,nums.length-1);
//         return nums;
//     }
//    public static void quick(int[] a,int f,int l){
//        int i=f,pivot=f;
//        int j=l;
//        int temp;
//        if(f<l){
//            while(i<j){
//               while(i<j && a[i]<=a[pivot])
//                  i++;
//               while(a[j]>a[pivot])
//                  j--;
//               if(i<j){
//                  temp=a[i];
//                  a[i]=a[j];
//                  a[j]=temp;
              
//              } 
//            }
//        temp=a[j];
//        a[j]=a[pivot];
//        a[pivot]=temp;
//        quick(a,f,j-1);
//        quick(a,j+1,l);
//        }
//    }
// }
// 2.merge sort

public class Solution {
    public int[] sortArray(int[] Arr) {
       mergeSort(Arr, 0, Arr.length-1);
       return Arr;
    }
    // Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr
    void mergeSort(int Arr[], int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }


	//For Merging....
    void merge(int Arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start, j = mid+1, k = 0;
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1; i += 1;
            }
            else {
                temp[k] = Arr[j];
                k += 1; j += 1;
            }
        }
    

        // add elements left in the first interval 
        while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }

        // add elements left in the second interval 
        while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }

        // copy temp to original interval
        for(i = start; i <= end; i++) {
            Arr[i] = temp[i - start];
        }
    }
}


