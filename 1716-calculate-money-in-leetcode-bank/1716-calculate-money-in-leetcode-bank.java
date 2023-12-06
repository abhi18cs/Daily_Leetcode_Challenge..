class Solution {
    public int totalMoney(int n) {
        int bucket = (n / 7) + 1;
        int rem = n % 7;
        int sum = 0;
        int daysinweek = 7;
        int start = 0;
        for (int i = 0 ;i < bucket; i++ ){
            System.out.println("i is:"+i);
            int m = daysinweek + start;
            if(i == bucket -1){
                m = start + rem;    
            }
            int sigma_start = (start * (start+1))/2;
            sum += ((m * (m + 1)) /2) - sigma_start;
            start++;
        }

        return sum;
    }
}