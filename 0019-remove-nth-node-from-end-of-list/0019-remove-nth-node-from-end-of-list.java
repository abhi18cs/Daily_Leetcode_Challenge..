//Approach-1 BruteForce Tc=O(n) Sc=O(1)
//We can traverse through the Linked List while maintaining a count of nodes, let’s say in the variable count, and then traversing for the 2nd time for (n – count) nodes to get to the nth node of the list.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        int position = count - n;
        
        if (position == 0) {
            return head.next; // Remove the head node
        }
        
        temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        
        temp.next = temp.next.next; // Remove the nth node
        
        return head;
    }
}

//Approach-2 Using TwoPointers T c=O(n) Sc=O(1)
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//     //make a start node
//         ListNode start=new ListNode();
//         start.next=head;
//         ListNode slow=start;
//         ListNode fast=start;
//         for(int i=1;i<=n;i++){
//             fast=fast.next;
//         }      
//         while(fast.next!=null){
//             slow=slow.next;
//             fast=fast.next;
//         } 
//         slow.next=slow.next.next;
//         return start.next; 
//     }
// }