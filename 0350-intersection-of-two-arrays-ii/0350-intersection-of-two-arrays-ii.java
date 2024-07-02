//Brute force tc=O(n^2) sc=O(n)
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         ArrayList<Integer> ans=new ArrayList<>();
//        for(int i=0;i<nums1.length;i++){
//            for(int j=0;j<nums2.length;j++){
//                if(nums1[i]==nums2[j]){
//                    ans.add(nums1[i]);
//                    nums2[j]=-1;
//                    break;
//                }
//            }
           
//         }
//         int []anss=new int [ans.size()];
//            for(int k=0;k<ans.size();k++){
//                anss[k]=(int)ans.get(k);
//            }
//         return anss; 
//     }
// }

//Optimized soln
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                ans.add(nums1[p1]);
                p1++;p2++;
            }
            else if(nums1[p1]>nums2[p2]) p2++;
            else p1++;
        }
          
            int []anss=new int [ans.size()];
            for(int k=0;k<ans.size();k++){
               anss[k]=(int)ans.get(k);
           }
        return anss; 
    }
}