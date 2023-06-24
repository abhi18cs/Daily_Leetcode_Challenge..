//Approach-1 Using Recursion Tc=O(n) Sc=O(1) We can traverse through the Linked List while maintaining a count of nodes let’s say in variable n, and then traversing for 2nd time for n/2 nodes to get to the middle of the list.
class Solution {
    public ListNode middleNode(ListNode head) {
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<n/2;i++){
            temp=temp.next;
        }
        return temp;
    }
}

//Approach-2 Using Recursion Tc=O(n) Sc=O(1)
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode slow=head,fast=head;
//         if(head==null && head.next==null) return head;
//         while(fast!=null && fast.next!=null ){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         return slow;
//     }
// }

