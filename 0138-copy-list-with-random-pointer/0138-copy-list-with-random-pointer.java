class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Map<Node, Node> map =  new HashMap<Node, Node>();
    
        Node curNode = head;
        while(curNode != null)
        {
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }
        
        for(Map.Entry<Node, Node> entry : map.entrySet())  
        // key -> value;  node -> copy
        {
            Node node = entry.getValue();
            node.next = map.get(entry.getKey().next);
            node.random = map.get(entry.getKey().random);
        }
        
        return map.get(head);
    }
}