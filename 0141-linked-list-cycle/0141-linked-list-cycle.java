//Appraoch-1 Using HashSet Tc=O(n) Sc=O(n) n=size of the list
class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> hs=new HashSet<>();
        while(head != null) {
            if(hs.contains(head)) return true;
            hs.add(head);
            head = head.next;
        }
        return false;
    }
}

//Appraoch-2 Using slow and fast pointer Tc=O(n) Sc=O(1) n=size of the list
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head==null || head.next==null) return false;
//         ListNode slow=head;
//         ListNode fast=head;
//         while(fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//         if(slow==fast) return true;
//         }
//         return false;
//     }
// }

