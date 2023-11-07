class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] timeToReach = new int[n];
        
        for (int i = 0; i < n; i++) {
            timeToReach[i] = (dist[i] - 1) / speed[i]; // Calculate time needed to reach the city
        }
        
        Arrays.sort(timeToReach); // Sort the time taken by monsters
        
        int eliminated = 0;
        for (int i = 0; i < n; i++) {
            if (timeToReach[i] < i) { // If any monster reaches before the time to eliminate
                break;
            }
            eliminated++;
        }
        
        return eliminated;
    }
}