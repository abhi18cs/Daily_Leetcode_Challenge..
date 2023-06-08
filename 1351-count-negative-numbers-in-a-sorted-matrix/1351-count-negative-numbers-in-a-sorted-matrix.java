// Approach-1
// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count=0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j]<0) count++;
//             }
            
//         }
//      return count;   
//     }
// }


//Approach-2 with BinarySearch
class Solution{
    public int countNegatives(int[][] grid){
        int res=0;
        for(int i=0;i<grid.length;i++){
            res+=negativeEachRow(grid[i]);
        }
        return res;
    }
    public static int negativeEachRow(int[] row){
        int res=0;
        int l=0,h=row.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            // if midPoint is positive, go to the right side
            // if midPoint is negative, count the right side(because they are all negative) and go to left side.
            if(row[m]>=0) l=m+1;
            else if(row[m]<0){
                res+=h-m+1;
                h=m-1;
            }
        }
        return res;
    }
}