class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();  
        for(int i=0;i<n;i++){
            int sum1=0;
            for(int j=i;j<n;j++){
                sum1+=nums[j];
                list.add(sum1);
            }
        }
        int sum =0;
        Collections.sort(list);
        System.out.println(list);
        for(int i=left-1;i<right;i++){
            sum = (sum+list.get(i))%(int)(1e9 +7);
        }
        return sum;
    }
}