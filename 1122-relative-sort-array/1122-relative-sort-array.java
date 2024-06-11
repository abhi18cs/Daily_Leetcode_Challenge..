class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
     // Create a map to store the index of each element in arr2
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }

        // Use a custom comparator to sort arr1
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, (a, b) -> {
            if (indexMap.containsKey(a) && indexMap.containsKey(b)) {
                // Both elements are in arr2, compare by their indices in arr2
                return indexMap.get(a) - indexMap.get(b);
            } else if (indexMap.containsKey(a)) {
                // Only element a is in arr2, it should come first
                return -1;
            } else if (indexMap.containsKey(b)) {
                // Only element b is in arr2, it should come first
                return 1;
            } else {
                // Neither element is in arr2, compare by their values
                return a - b;
            }
        });

        // Convert back to int array
        return Arrays.stream(arr1Integer).mapToInt(Integer::intValue).toArray();
    }
}