//Approach-1 Using Hashest Tc=MaxO(M,N) Sc=O(m);
// public class Solution{
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> hs=new HashSet<>();
//         while(headA!=null){
//             hs.add(headA);
//             headA=headA.next;
//         }
//         while(headB!=null){
//             if(hs.contains(headB))
//                 return headB;
//                 headB=headB.next;
            
//         }
//         return null;
//     }
// }

//Approach-2 Optimizied Tc=MaxO(M,N) Sc=O(1);
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1=headA,d2=headB;
        while(d1!=d2){
            if(d1==null) d1=headB;
            else d1=d1.next;
            if(d2==null) d2=headA;
            else d2=d2.next;
        }
        return d1;
    }
}