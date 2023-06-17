//Approach-1 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        
        int maxans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Set<Character> se = new HashSet<>();
            int j = i;
            while (j < s.length() && !se.contains(s.charAt(j))) {
                se.add(s.charAt(j));
                j++;
            }
            maxans = Math.max(maxans, j - i);
        }
        
        return maxans;
    }
}

//brute forece usnig 2 pointers
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//        if(s.length()==0) return 0;
//         HashMap<Character,Integer> map=new HashMap<>();
//         int max=0;
//         //2 pointers
//         for(int i=0,j=0;i<s.length();i++){
//             if(map.containsKey(s.charAt(i))){
//                 j=Math.max(j,map.get(s.charAt(i))+1);
//             }
//             map.put(s.charAt(i),i);
//             max=Math.max(max,i-j+1);
//         }
//         return max;
//     }
// }
// //TC=O(n^2)

//appraoch-2 using hashset tc=O(n),sc=O(n) 
//Sliding windows with hashet check duplicated character
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//     int i=0,j=0,max=0;
//     HashSet<Character> set=new HashSet<>();
//     while(j<s.length()){
//         if(!set.contains(s.charAt(j))){
//             set.add(s.charAt(j++));
//             max=Math.max(max,set.size());
//         }
//         else set.remove(s.charAt(i++));
//     }
//     return max;
//     }
// }