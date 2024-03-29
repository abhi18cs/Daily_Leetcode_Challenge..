//Approach Tc=O(n) Sc=O(1)
      /*  Intuition 
            a. if K or more nodes available in given list
                 1. reverse first k node,
                 2. remove from the main list
                 3. append in the new list
                 4. move main pointer to next group first node

            b. if NOT available 
                 1. just append the Remaining nodes in new list
        
        */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode mainCurr = head;
        //dummy nodes, places holder of head 
        //reverse linked list
        ListNode dummyNode = new ListNode();
        ListNode newCurr = dummyNode;
        while(mainCurr != null){
            ListNode curr = mainCurr;
            
            //get next group first node
            int i = k;
            int availableNode = 0;
            while(i --> 0 && curr != null){
                curr = curr.next;
                availableNode++;
            }
            ListNode nextGroupFirstNode = curr;
            //if Available node is K, then reverse and add in newNode list
            //otherwise just append remaining node
            if(availableNode == k){
                newCurr.next = getReverseFirstKNodes(mainCurr, k);
                newCurr = mainCurr;
            }else{
                newCurr.next = mainCurr;
            }
            //move to next group
            mainCurr = nextGroupFirstNode;
        }
        return dummyNode.next;
    }
    //reverse K first node, and 
    //return the head of K node list
    private ListNode getReverseFirstKNodes(ListNode node, int k){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null && k --> 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}