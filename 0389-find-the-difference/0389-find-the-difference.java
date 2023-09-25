class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize variables to store the sum of ASCII values
        int k = 0; // For string s
        int j = 0; // For string t
        
        // Iterate through the characters in string s
        for (int i = 0; i < s.length(); i++) {
            k += s.charAt(i); // Add the ASCII value of s[i] to k
            j += t.charAt(i); // Add the ASCII value of t[i] to j
        }
        
        // Add the ASCII value of the extra character in t
        j += t.charAt(s.length());
        
        // Calculate the difference in ASCII values and convert it to a character
        return (char) (j - k);
    }
}
