/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();

        int counter = 2;
        ListNode pre = head;
        ListNode current = head.next;

        while(current != null && current.next != null) {
            if(current.val > pre.val && current.val > current.next.val || current.val < pre.val && current.val < current.next.val ) {
                list.add(counter);
            }
            pre = current;
            current = current.next;
            counter++;
        }

        if(list.size() < 2) {
            return new int[] {-1,-1};
        }

        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        for(int i = 1; i < list.size(); i++){
            min = Math.min(min,list.get(i) - list.get(i-1));
        }

       ans[0] = min;
       ans[1] = list.get(list.size()-1) - list.get(0);

       return ans;   
    }
}