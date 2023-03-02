class Solution {
    public boolean isPalindrome(String s) {
    int i = 0,j = s.length() - 1;
    while (i < j) {
        Character start = s.charAt(i);
        Character end = s.charAt(j);
        if (!Character.isLetterOrDigit(start)) {
            i++;
            continue;
        }
        if (!Character.isLetterOrDigit(end)) {
            j--;
            continue;
        }
        if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
            return false;
        }
        i++;
        j--;    
    }
    
    return true;
    }
}

// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//         int i = 0;
//         int j = s.length() - 1;
//         while(i <= j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

//method usig predefined methods
// class Solution {
//     public boolean isPalindrome(String s) {
//         String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//         String rev = new StringBuffer(actual).reverse().toString();
//         return actual.equals(rev);
//     }
// }