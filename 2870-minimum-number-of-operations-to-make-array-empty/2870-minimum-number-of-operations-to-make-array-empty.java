class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
	for(int num : nums){
		map.put(num, map.getOrDefault(num, 0)+1);
	}

	int ct = 0;
	for(int val : map.values()){
		if(val==1) return -1;

		int three = val/3;
		int rem = (val-(3*three));
		if(rem%2 != 0){
			rem += 3;
			three--;
		}

		ct += three;
		ct += rem/2;
	}

	return ct;
    }
}