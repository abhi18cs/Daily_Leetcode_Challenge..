//BruteForce Approach Tc=O(n2) Sc=O(1)
class Solution{
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length; //size of the array
        List<Integer> ans = new ArrayList<>(); // list of answers
        for (int i = 0; i < n; i++) {
            //selected element is arr[i]:
            // Checking if arr[i] is not already
            // a part of the answer:
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    // counting the frequency of v[i]
                    if (arr[j] == arr[i]) {
                        cnt++;
                    }
                }
                // check if frquency is greater than n/3:
                if (cnt > (n / 3))
                    ans.add(arr[i]);
            }
            if (ans.size() == 2) break;
        }

        return ans;
    }
}

  //tc=O(n) sc=O(n)
// class Solution {
//     public List<Integer> majorityElement(int[] arr) {
//        	HashMap<Integer,Integer> cntMap = new HashMap<>();
//     int n = arr.length;
//     for(int i = 0;i<n;i++)
//         cntMap.put(arr[i],cntMap.getOrDefault(arr[i],0)+1);
//     ArrayList<Integer> ans = new ArrayList<>();
//     for(Map.Entry<Integer,Integer> e:cntMap.entrySet())
//         if(e.getValue()> n/3)
//             ans.add(e.getKey());
//     return ans;
	 
//     }
// }

//tc=O(n) sc=O(1)Boyer Moore Voting Algorithm
// class Solution {
//     public List<Integer> majorityElement(int[] arr) {
//     int ans1 = -1, ans2 =-1, cnt1 = 0,cnt2 = 0;
//     for(int e:arr){
//         if(ans1 == e) cnt1++;
//         else if(ans2== e) cnt2++;
//         else if(cnt1 == 0){
//             ans1 = e;
//             cnt1= 1;
//         }
//         else if(cnt2 == 0){
//             ans2 = e;
//             cnt2 = 1;
//         }
//         else{
//             cnt1--;
//             cnt2--;
//         }
//     }
//     cnt1 = 0;
//     cnt2 = 0;
//     for(int e:arr){
//         if(e== ans1) cnt1++;
//         else if(e == ans2) cnt2++;
//     }
//     List<Integer> ans = new ArrayList<>();
//     if(cnt1 >arr.length/3) ans.add(ans1);
//     if(cnt2 > arr.length/3) ans.add(ans2);
//     return ans;
//     }
// }

