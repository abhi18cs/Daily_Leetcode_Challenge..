class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
       int x1=coordinates[0][0],x2=coordinates[1][0];
        int y1=coordinates[0][1],y2=coordinates[1][1];
        for(int i=2;i<coordinates.length;i++){
            int x3=coordinates[i][0],y3=coordinates[i][1];
            if((y3-y1)*(x2-x1)!=(x3-x1)*(y2-y1)) return false;
        }
        return true;
    }
}