//Tc=O(nlogn) Sc=O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));//O(nlogn)
        Stack<int []> stack=new Stack();
        stack.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){//O(n)
            int startPoint2=intervals[i][0];
            int endPoint2=intervals[i][1];
        
        
            int []popArray=stack.pop();
            int startPoint1=popArray[0];
            int endPoint1=popArray[1];

            int endMax=Math.max(endPoint2,endPoint1);
            if(endPoint1>=startPoint2){
                int []merge=new int []{startPoint1,endMax};
                stack.add(merge);
            }
            else{
                stack.add(popArray);
                stack.add(intervals[i]);
            }
        }
        
        int [][]output=new int [stack.size()][2];
        for(int i=output.length-1;i>=0;i--){//O(n)
            int[]popArray=stack.pop();
            output[i][0]=popArray[0];
            output[i][1]=popArray[1];
        }
        return output;

        
    }
}

