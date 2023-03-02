//Approach using hashmap and sorting tc=O(nlogk) sc=O(k) k==no.of elements
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            String s1=strs[i];
            char[] arr=s1.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            
            if(map.containsKey(str)){
                map.get(str).add(s1); 
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
    }
}

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs == null || strs.length == 0) return new ArrayList<>();
//         Map<String, List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             char[] ca = new char[26];
//             for (char c : s.toCharArray()){
//                 ca[c - 'a']++;
//             }
//             String keyStr = String.valueOf(ca);
//             if (!map.containsKey(keyStr)){
//                 map.put(keyStr, new ArrayList<>());
//             }
//             map.get(keyStr).add(s);
//         }
//         return new ArrayList<>(map.values());
//     }
// }