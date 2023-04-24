class Solution {
public:
     int lastStoneWeight(vector<int>& stones) {
        
        priority_queue<int> maxh;
		
        // Add all the elements of the array to a priority queue( Max Heap ).
        for(auto i:stones) maxh.push(i);
        
		//Now While the priority queue is not empty until then:
        while(!maxh.empty()){
            
            int a=0, b=0;
            a = maxh.top();
            maxh.pop();
            
			
            if(!maxh.empty()) b = maxh.top();
			// If there is only one element on the top return that as the answer
            else return a;
            maxh.pop();
			
            //If there are more than two elements pop out the two top elements and push the absolute difference between them in the queue ( max(a-b, b-a) )
            maxh.push(max(a-b, b-a));

        }
        
        return maxh.top();
        
    }
};