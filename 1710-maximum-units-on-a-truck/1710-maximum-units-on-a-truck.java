class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(x,y)->y[1]-x[1]);
        int count=0;
        int size=boxTypes.length;
        for(int i=0;i<size;i++){
            if(truckSize>boxTypes[i][0]){
                count+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else{
                count+=truckSize*boxTypes[i][1];
                break;
            }
        }
        return count;
    }
}