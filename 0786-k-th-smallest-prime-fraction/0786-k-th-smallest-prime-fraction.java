class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeMap<Double, int[]>map= new TreeMap<>();
      
        for(int i= 0; i< arr.length; i++)
        {
            for(int j= i+ 1;j< arr.length; j++)
            {
                    double num= arr[i];
                    double den= arr[j];
                  double d= (double)(num/den);
              //  System.out.println("d: "+ d);
               map.put(d, new int[]{arr[i], arr[j]});
            }
        }
        int count= 0;
        for(double key: map.keySet())
        {
            count++;
            // System.out.println(Arrays.toString(map.get(key)));
            if(count== k)
            {
                return map.get(key);
            }
       
        }
        return null;
    }
}