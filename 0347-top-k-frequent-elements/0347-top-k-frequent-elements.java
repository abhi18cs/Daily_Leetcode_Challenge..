//https://leetcode.com/problems/top-k-frequent-elements/solutions/81635/3-java-solution-using-array-maxheap-treemap/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            int max = Collections.max(map.values());
            if(max>0){
                for (Map.Entry m :map.entrySet()) {
                    if((int)m.getValue()==max){
                        list.add((int)m.getKey());
                        map.replace((int)m.getKey(),Integer.MIN_VALUE);
                    }
                    if(list.size()==k)
                        break;
                }
            }
            if(list.size()==k)
                break;
        }
        int arr[]= new int[list.size()];
        for(int j=0;j<arr.length;j++)
            arr[j]=list.get(j);
        return arr;
    }
}