class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Dummy node to create the new list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode iter = head.next; // Skip the initial 0
        int sum = 0;
        
        while (iter != null) {
            if (iter.val == 0) {
                // When we reach a 0, create a new node with the sum
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0; // Reset sum
            } else {
                // Accumulate the sum between zeros
                sum += iter.val;
            }
            iter = iter.next;
        }
        
        return dummy.next; // Return the new list, skipping the dummy node
    }
}