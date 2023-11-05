class Solution {
    public int getWinner(int[] arr, int k) {
      List<Integer> list = new LinkedList<>();
        for(int i:arr)
            list.add(i);
        int count=Integer.MIN_VALUE;
        int i=1;
        int res=0;
        int value=1;
        int maxValue = Collections.max(list);
        while(true)
        {
            if(list.get(0)> list.get(1))
            {
                res=list.get(0);
                list.add(list.size(), list.get(1));
                list.remove(1);
            }
            else
            {
                res = list.get(1);
                list.add(list.size(),list.get(0));
                list.remove(0);
            }
          // System.out.println("LOOP:" + i + " VALUE : " +value + " " +list);
            if(res== count)
               value++;  //incrementing the value to find the winner for consecutve iterations
            else
            {
                count=res;
                value=1; //Reset the winning count
             }
            
            if(value ==k || res==maxValue) // if value reaches the target break the loop.
                break;
            
            i++;
         }
          list.clear();
          return res;
   
    }
}