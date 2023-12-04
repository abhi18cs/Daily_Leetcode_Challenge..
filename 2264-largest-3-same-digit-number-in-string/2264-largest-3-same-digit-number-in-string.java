class Solution {
    public String largestGoodInteger(String num) {
       char[] arr = num.toCharArray();
        int max = -1;
        int ans = -1;
        for(int i = 0;i<arr.length-2;i++){
            if(arr[i]==arr[i+1] && arr[i+1]==arr[i+2])
                    {
                        int cur = Character.getNumericValue(arr[i]);
                        if(max<cur){
                            ans = i;
                            max = cur;
                        }

                    }
        }
        return ans==-1? "" : num.substring(ans,ans+3);
    } 
    }
