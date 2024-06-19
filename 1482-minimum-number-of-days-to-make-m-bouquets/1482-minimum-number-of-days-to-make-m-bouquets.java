class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        // If there are not enough flowers to make m bouquets, return -1
        if (m * k > n) {
            return -1;
        }
        
        // Initialize start to 0 and end to the maximum value in the array bloomDay
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }
        
        int ans = -1;
        
        // Binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }

    // Helper function to get the number of bouquets possible by day "day"
    private int getNumOfBouquets(int[] bloomDay, int day, int k) {
        int numOfBouquets = 0;
        int flowers = 0;
        
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    numOfBouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        
        return numOfBouquets;
    }
}