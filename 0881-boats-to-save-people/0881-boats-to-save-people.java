
//Approach-1 Using 2 Pointers Tc=O(nlogn) Sc=(1)
// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         int count=0;
//         Arrays.sort(people);
//         int i=0,j=people.length-1;
//         while(i<=j){
//             if(people[i]+people[j]<=limit){
//                 i++;j--;
//             }
//             else j--;
//             count++;
//         }
//         return count;
//     }
// }

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] map = new int[limit + 1];
        
        for(int x : people){
            map[x]++;
        }
        
        int i = 0;
        int j = limit;
        int numPeople = 0;
        
        while(i <= j){
            while(map[i] == 0 && i <= j){
                i++;
            }
            while(map[j] == 0 && i <= j){
                j--;
            }
            if(i + j <= limit){
                if(map[j] > 0)
                   map[j]--;
                if(map[i] > 0)
                   map[i]--;
            }
            else{
                if(map[j] > 0)
                   map[j]--;
            }
            numPeople++;
        }
        return numPeople - 1;
    }
}