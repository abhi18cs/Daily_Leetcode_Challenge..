class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);
        int res = -1;
        if (target >= mountainArr.get(0) && target <= mountainArr.get(peakIndex))
        {
            res = binarySearch(target, 0, peakIndex, mountainArr);
        }
        if (res == -1) { //if not found result on the left
            res = reverseBinarySearch
                (target, peakIndex + 1, mountainArr.length() - 1, mountainArr);
        }
        return res;
    }
    public int findPeak(MountainArray arr) {
        int left = 0;
        int right = arr.length() - 1;
        while (left  < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int binarySearch(int target, int left, int right, MountainArray arr) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (target > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int reverseBinarySearch(int target, int left, int right, MountainArray arr) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (target > arr.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
}