//Brute Force
//tc=O(nlogn) sc=O(1)
// class Solution {
//     public boolean isAnagram(String s, String t) {
//          char[] schar=s.toCharArray();
//          char[] tchar=t.toCharArray();
//          Arrays.sort(schar);
//          Arrays.sort(tchar);
//          return Arrays.equals(schar,tchar);
//     }
// }

//tc=O(n) sc=O(n)
// If two strings are anagrams then the frequency of every char in both of the strings are same.
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()) return false;
//         if(s==null || t==null) return false;
//         int count[]=new int[26];
//         for(int i=0;i<s.length();i++){
//             count[s.charAt(i)-'a']++;
//             count[t.charAt(i)-'a']--;
//         }
//         for(int i:count){
//             if(i!=0) return false;
//         }
//             return true;   
//     }
// }

//Another approach using hashmap
class Solution {
    public boolean isAnagram(String a, String b) {
// Check if length of both strings is same or not
        if (a.length() != b.length()) {
            return false;
        }
        // Create a HashMap containing Character as Key and
        // Integer as Value. We will be storing character as
        // Key and count of character as Value.
        HashMap<Character, Integer> map = new HashMap<>();
        // Loop over all character of String a and put in
        // HashMap.
        for (int i = 0; i < a.length(); i++) {
            // Check if HashMap already contain current
            // character or not
            if (map.containsKey(a.charAt(i))) {
                // If contains increase count by 1 for that
                // character
                map.put(a.charAt(i),
                        map.get(a.charAt(i)) + 1);
            }
            else {
                // else put that character in map and set
                // count to 1 as character is encountered
                // first time
                map.put(a.charAt(i), 1);
            }
        }
        // Now loop over String b
        for (int i = 0; i < b.length(); i++) {
            // Check if current character already exists in
            // HashMap/map
            if (map.containsKey(b.charAt(i))) {
                // If contains reduce count of that
                // character by 1 to indicate that current
                // character has been already counted as
                // idea here is to check if in last count of
                // all characters in last is zero which
                // means all characters in String a are
                // present in String b.
                map.put(b.charAt(i),
                        map.get(b.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }
        // Extract all keys of HashMap/map
        Set<Character> keys = map.keySet();
        // Loop over all keys and check if all keys are 0.
        // If so it means it is anagram.
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        // Returning True as all keys are zero
        return true;
    }
}








