//Approach Using Recursion Tc=O(n+m) [Let N be the number of nodes in list l1 and M be the number of nodes in list l2. We have to iterate through both lists. So, the total time complexity is O(N+M)]
//Sc=O(n+m)[We are creating another linked list that contains the (N+M) number of nodes in the list. So, space complexity is O(N+M).]
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null;
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val>list2.val){
            head=list2;
            list2=list2.next;
        }  
        else {
            head=list1;
            list1=list1.next;
        }
        head.next=mergeTwoLists(list1,list2);
        return head;  
    }
}