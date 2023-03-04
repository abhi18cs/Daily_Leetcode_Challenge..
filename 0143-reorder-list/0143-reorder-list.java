class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        Stack<ListNode> s= new Stack<>();
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            s.add(curr);
            curr=curr.next;
        count++;
        }
        curr=head;
        for(int i=0;i<=count/2;i++){
            ListNode temp= curr.next;
            curr.next=s.pop();
            curr=curr.next;
            curr.next=temp;
            curr=curr.next;

        }
        if(count%2!=0)
            curr.next.next=null;
        else curr.next=null;
    }
}