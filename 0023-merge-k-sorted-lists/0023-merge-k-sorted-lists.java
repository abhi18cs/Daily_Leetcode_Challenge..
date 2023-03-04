//merge K sorted lists
class Solution {
    public static ListNode mergeKLists(ListNode[] lists){
    return partion(lists,0,lists.length-1);
}
//this function is for checking the elements
public static ListNode partion(ListNode[] lists,int s,int e){
    if(s==e)  return lists[s];
    if(s<e){
        int m=(s+e)/2;
        ListNode l1=partion(lists,s,m);
        ListNode l2=partion(lists,m+1,e);
        return merge(l1,l2);
    }else
        return null;
}

//This function is from Merge Two Sorted Lists.
public static ListNode merge(ListNode list1,ListNode list2){
    ListNode head;
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
    head.next=merge(list1,list2);
    return head;  
    }

}