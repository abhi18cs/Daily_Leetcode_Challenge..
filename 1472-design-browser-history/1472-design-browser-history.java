class BrowserHistory {
    //node class
    public class Node{
        String url;
        Node prev,next;
        public Node(String url){//constructor
            this.url=url;
            next=null;
            prev=null;
        }
    }

    Node head,curr; //instance variable
    public BrowserHistory(String homepage) {
        head=new Node(homepage);
        curr=head;
    }
    
    public void visit(String url) {
        Node node=new Node(url);
        //adding a new node to end of list
        curr.next=node;
        node.prev=curr;
        curr=node;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps-- >0){
            curr=curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps-- >0){
            curr=curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */