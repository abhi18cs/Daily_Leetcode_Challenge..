class Solution {
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        ArrayList<Integer> temp = greaterValueToRight(list);
        return fromLL(temp);
    }
    private ArrayList<Integer> greaterValueToRight(ArrayList<Integer> list){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=list.size()-1; i>=0; i--){
            int curr = list.get(i);
            while(!stack.isEmpty() && stack.peek() <= curr){
                stack.pop();
            }
            if(stack.isEmpty()){
                res.add(curr);
            }
            stack.push(curr);
        }
        Collections.reverse(res);
        return res;
    }
    private ListNode fromLL(ArrayList<Integer> temp){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int i=0; i<temp.size(); i++){
            curr.next = new ListNode(temp.get(i));
            curr = curr.next;
        }
        return dummy.next;
    }
}