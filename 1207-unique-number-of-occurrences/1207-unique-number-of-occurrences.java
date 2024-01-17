class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length == 1)  return true;
        Arrays.sort(arr);
        Set set = new HashSet();
        int time = 0, len = 1;
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1 && arr[i] != arr[i+1])
                len++;
        }
        for(int i=0;i<arr.length;i++){
            time++;
            if(i != arr.length-1 && arr[i] != arr[i+1]){
                set.add(time);
                time = 0;
            }
            if(i == arr.length-1){
                set.add(time);
            }
        }
        return set.size() == len;
    }
}