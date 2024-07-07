class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles ;

        int emptyBottles = numBottles ;

        while(emptyBottles >= numExchange)
        {
            ans +=  (emptyBottles - (emptyBottles%numExchange))/numExchange ;
            emptyBottles = (emptyBottles - (emptyBottles%numExchange))/numExchange + emptyBottles%numExchange ;
        }

        return ans ;
    }
}