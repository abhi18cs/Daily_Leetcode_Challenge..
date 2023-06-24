//Aproach-1 IterativeMethod Tc=O(n) Sc=O(1)
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head==null || head.next==null) return head;
//         ListNode prev=null;
//         ListNode next=null;
//         ListNode curr=head;
//         while(curr!=null){
//             next=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=next;
//         }

//         return prev;
//     }
// }

//Aproach-2 RecursiveMethod Tc=O(n) Sc=O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}