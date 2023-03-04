//tc=O(n) sc=O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null) return head;
    ListNode prev=null;
    ListNode next=null;
    ListNode curr=head;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    
    return prev;
    }
}
//tc=O(n) sc=O(1)
// class Solution {
//     public ListNode reverseList(ListNode head) {
  
//         ListNode pre=null;
//         ListNode next=null;
//         while(head!=null){
//             next=head.next;
//             head.next=pre;
//             pre=head;
//             head=next;
//         }
//         return pre;
//     }
// }