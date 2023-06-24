class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> hashTable=new HashSet<>();
        while(head != null) {
            if(hashTable.contains(head)) return true;
            hashTable.add(head);
            head = head.next;
        }
        return false;
    }
}



//tc=O(n) sc=O(1)
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

