class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> m = new TreeMap();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = getMappedValue(mapping, nums[i]);
            m.putIfAbsent(mappedValue, new LinkedList());
            m.get(mappedValue).add(nums[i]);
        }

        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry e : m.entrySet()) {
            LinkedList<Integer> ll = (LinkedList<Integer>) (e.getValue());
            for (int val : ll) {
                result[index] = val;
                index++;
            }
        }
        return result;
    }

    private int getMappedValue(int[] mapping, int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            int digit = num % 10;
            sb.append(mapping[digit]);
            num = num / 10;
        }
        int value = Integer.valueOf(sb.reverse().toString());
        return value;
    }
}
