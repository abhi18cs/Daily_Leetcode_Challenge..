class MyLinkedList {
	Node head;
    int length;
    public class Node{
        int val;
        Node next;
        Node(int val){
        this.val=val;
        }
    }
    
    public MyLinkedList() {
        this.head=null;
        this.length=0;
    }
    
    public int get(int index) {
        if(index>=length) return -1;
        int counter=0;
        Node temp=head;
        while(counter<index){
            counter++;
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node neww=new Node(val);
        neww.next=head;
        head=neww;
        length++;
    }
    
    public void addAtTail(int val) {
         if(head==null) addAtHead(val);
         else{
             Node temp=head;
             while(temp.next!=null)
                 temp=temp.next;
                Node neww=new Node(val);
                temp.next=neww;
                 length++;
             }
    }
     
    public void addAtIndex(int index, int val) {
    	if(index>length) return;
        if(index==0) addAtHead(val);
        else{
            int counter=1;
            Node temp=head;
            while(counter<index){
                temp=temp.next;
                counter++;
            }
            Node neww=new Node(val);
            Node next=temp.next;
            temp.next=neww;
            neww.next=next;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index>=length) return;
        if(index==0){
            head=head.next;
            length--;
        }
        else{
            int counter=1;
            Node temp=head;
            while(counter<index){
                counter++;
                temp=temp.next;
            }
            temp.next=temp.next.next;
            length--;
        }
    }
}