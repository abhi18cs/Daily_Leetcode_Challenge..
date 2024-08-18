//tc=O(n)sc=O(n)
// class Solution {
//     public int nthUglyNumber(int n) {
//         if(n==1) return 1;
//     PriorityQueue<Integer> pq = new PriorityQueue<>();
//     pq.add(1);
//     int curr=0,prev=0;
//     for(int i=1;i<=n;i++){
//         curr = (int)pq.poll();
//         if(curr==prev){
//             i--;
//             continue;
//         }
//         // avoid overflow
//         if(curr <= Integer.MAX_VALUE/2)    
//             pq.add(curr*2);
//         if(curr <= Integer.MAX_VALUE/3)
//             pq.add(curr*3);
//         if(curr <= Integer.MAX_VALUE/5)
//             pq.add(curr*5);
        
//         prev = curr;
//     }
//     return curr;
    
//     }
// }
class Solution {
    
    static List<Long> res = new ArrayList<>();
    
    static {
        for (long a = 1; a < Integer.MAX_VALUE; a *= 2)
            for (long b = a; b < Integer.MAX_VALUE; b *= 3)
                for (long c = b; c < Integer.MAX_VALUE; c *= 5)
                    res.add(c);
        Collections.sort(res);
    }
    
    public int nthUglyNumber(int n) {
        return res.get(n-1).intValue();
    }
    
}