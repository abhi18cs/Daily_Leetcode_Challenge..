class Solution {
    public int countPalindromicSubsequence(String s) {
        
    int n = s.length(), ans = 0;
        int[][] firstAndLastOccr = new int[2][26];
        Arrays.fill(firstAndLastOccr[0], -1);
        
        // Preprocessing for finding first and last index of every 
        // character in the input string
        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i)-'a';
            if(firstAndLastOccr[0][idx] == -1) {
                // Mark the first index, if this character never seen before
                firstAndLastOccr[0][idx] = i;
            }
            // Mark the last index of character
            firstAndLastOccr[1][idx] = i;
        }

        // Finding the unique charcters in every count
        for(int i = 0; i < 26; i++) {
            int first = firstAndLastOccr[0][i];
            int last = firstAndLastOccr[1][i];

            // If there exist at least 3 character inside to make the 3 length 
            // palindromic string
            if((first > -1) && (last - first >= 2)) {
                HashSet<Character> set = new HashSet<>();
                first++;
                // Find all the unique charcters in the string between two index
                while(first < last) {
                    set.add(s.charAt(first));
                    first++;
                }
                ans += set.size();
            }
        }
        return ans;
        
    }
}