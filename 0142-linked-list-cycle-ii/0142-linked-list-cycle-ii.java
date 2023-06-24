//Appraoch-1 Using HashSet Tc=O(n) Sc=O(n)
// class Solution {
//     public ListNode detectCycle(ListNode head) {
//         HashSet<ListNode> st=new HashSet<>();
//             while(head != null) {
//                 if(st.contains(head)) return head;
//                 st.add(head);
//                 head = head.next;
//             }
//             return null;
//     }
// }

//Appraoch-2 Using Slow and Fast Pointers Tc=O(n) Sc=O(n)
class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode entry=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                while(slow!=entry){
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}

