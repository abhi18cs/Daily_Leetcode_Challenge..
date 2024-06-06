class Solution {
    // Define a Pair class to hold a key-value pair
    class Pair implements Comparable<Pair> {
        int key; // Key represents the card value
        int data; // Data represents the frequency of the card

        // Constructor to initialize the Pair
        Pair(int key, int data) {
            this.key = key;
            this.data = data;
        }

        // Override compareTo method to compare Pairs based on their keys
        @Override
        public int compareTo(Pair o) {
            return this.key - o.key; // Compare based on the key values
        }
    }

    // Method to check if it's possible to rearrange the hand into consecutive groups
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Check if it's possible to form groups of the given size with the given hand size
        if (hand.length % groupSize != 0) return false;

        // Initialize a priority queue to store Pairs sorted by key values (min heap)
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        // Initialize a HashMap to count the frequencies of each card
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // Populate the HashMap with card frequencies
        for (int j : hand) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        
        // Add each entry of the HashMap to the priority queue
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        
        // Iterate through the priority queue until it's empty
        while (!minHeap.isEmpty()) {
            // Temporary list to store Pairs for processing
            List<Pair> temp = new ArrayList<>();
            
            // Greedily choose the min element from the priority queue
            Pair min = minHeap.poll();
            min.data = min.data - 1; // Decrement the frequency of the card
            temp.add(min); // Add the Pair to the temporary list
            int current = min.key; // Track the current card value
            
            // Try to form consecutive groups of the given size
            for (int i = 1; i < groupSize; i++) {
                if (!minHeap.isEmpty()) {
                    Pair freq = minHeap.poll(); // Poll the next Pair from the priority queue
                    if (freq.key != current + 1) { // Check if the next card is consecutive
                        return false; // If not, return false
                    }
                    freq.data = freq.data - 1; // Decrement the frequency of the next card
                    temp.add(freq); // Add the Pair to the temporary list
                    current++; // Update the current card value
                } else {
                    return false; // If the priority queue becomes empty prematurely, return false
                }
            }
            
            // Add back Pairs to the priority queue if their frequency is greater than 0
            for (Pair p : temp) {
                if (p.data > 0) {
                    minHeap.offer(p);
                }
            }
        }
        return true; // If all groups are formed successfully, return true
    }
}