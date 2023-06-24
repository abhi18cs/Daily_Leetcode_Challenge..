//Approach-1 Using Recursion Tc=O(n) Sc=O(1) 
class Solution {
    public ListNode middleNode(ListNode head) {
        int n=0;
        ListNode temp=head;
        //We can traverse through the Linked List while maintaining a count of nodes let’s say in variable n.
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        //then traversing for 2nd time for n/2 nodes to get to the middle of the list
        for(int i=0;i<n/2;i++){
            temp=temp.next;
        }
        return temp;
    }
}

//Approach-2 Using Recursion Tc=O(n) Sc=O(1) Tortoise-Hare-Approach
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

