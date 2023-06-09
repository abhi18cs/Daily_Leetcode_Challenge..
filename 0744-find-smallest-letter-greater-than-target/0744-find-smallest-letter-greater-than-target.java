class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (target < letters[m]) {
                h = m - 1; // go left
            } else {
                l = m + 1; // go right
            }
        }
        return letters[l % letters.length]; // return char greater than target &
		                                        // incase target is not in array return first char
    }
}