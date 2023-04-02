class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++) {
            int n = spells[i];
            int idx = binarySearch(n, potions, 0, potions.length, success);
            if(idx == 0 || idx == potions.length-1) {
                result[i] = ((long)potions[idx] * (long)n >= success) ? potions.length - idx : 0;
            } else {
                result[i] = potions.length - idx;    
            }
        }
        return result;
    }
    
    private int binarySearch(int spell, int[] potions, int start, int end, long success) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            long product = (long)potions[mid] * (long)spell;
            if(product >= success) {
                end = mid;
            }else if(product < success) {
                start = mid+1;
            }
        }
        return start;
    }
}