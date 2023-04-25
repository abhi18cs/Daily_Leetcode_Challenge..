class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    HashSet<Integer> visited;
    int start;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        visited = new HashSet<>();
        start = 1;
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            return start++;
        } else {
            if(start < pq.peek()){
                return start++;
            } else {
                int smallest = pq.poll();
                if(start == smallest) start++;
                visited.remove(smallest);
                return smallest;
            }
        }
    }
    
    public void addBack(int num) {
        if(!visited.contains(num)){
            visited.add(num);
            pq.offer(num);
        }
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */