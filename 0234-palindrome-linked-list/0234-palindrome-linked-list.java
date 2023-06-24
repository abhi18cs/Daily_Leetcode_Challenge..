//Approac-1 Using Stack Tc=O(n) Sc=O(n)
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode temp=head;
//         Stack<Integer> stack=new Stack<>();
//         while(temp!=null){
//             stack.push(temp.val);
//             temp=temp.next;
//         }
//         while(!stack.isEmpty()){
//             if(stack.pop()!=head.val){
//                 return false;
//             }
//             head=head.next;
//         }
//         return true;
//     }
// }

//Approach-2 Using 2 Pointers Tc=O(n) Sc=O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        //base cond
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        //now find out middle of the linkedlist
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the ll right half
        slow.next=reverse(slow.next);
        //move slow to the right half
        slow=slow.next;
        //check left and right are equal or not
        while(slow!=null){
            if(head.val!=slow.val) return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
        //reverse fn
        ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode next=null;
            while(head!=null){
                next=head.next;
                head.next=pre;
                pre=head;
                head=next;
            }
        return pre;
        }
}

    