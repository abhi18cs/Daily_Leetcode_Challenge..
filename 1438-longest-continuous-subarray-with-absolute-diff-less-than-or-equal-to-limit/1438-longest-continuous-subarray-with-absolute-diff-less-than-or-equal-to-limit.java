class Solution {
   
        public int longestSubarray(int[] A, int limit) {
	PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	PriorityQueue<int[]> maxQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

	int j = 0, i;
	int res = 0;
	for (i = 0; i < A.length; i++) {
		minQ.add(new int[]{A[i], i});
		maxQ.add(new int[]{A[i], i});

		while (maxQ.peek()[0] - minQ.peek()[0] > limit) {
			j = Math.min(maxQ.peek()[1], minQ.peek()[1]) + 1;
			while (minQ.peek()[1] < j) minQ.poll();
			while (maxQ.peek()[1] < j) maxQ.poll();
		}
		res = Math.max(res, i - j + 1);
	}
	return res;

    }
}