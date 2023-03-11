class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true)
        {
            int val = 0;
            while(n > 0)
            {   int indx = n%10;
                val = val + indx*indx;
                n = n/10;  
            }
            if(val == 1)
            {
                return true;
            }
			// checking if val is alreday present in set or not
            if(set.contains(val) != false)
			{
			//if val is present then it mean we are getting into cycle  so Happy Number not possible hence return false
                return false;
            }
            set.add(val);
            n = val;
        }
    }
}