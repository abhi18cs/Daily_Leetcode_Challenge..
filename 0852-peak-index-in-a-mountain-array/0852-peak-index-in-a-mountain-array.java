class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int l = 0, h = arr.length - 1, m;
        while (l < h) {
            m = l + (h - l) / 2;
            if (arr[m] < arr[m + 1])
                l = m + 1;
            else
                h = m;
        }
        return l;  
    }
}