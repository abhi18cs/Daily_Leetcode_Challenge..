//tc=O(n) sc=O(1)
/* Whenever we get a array Question like this where elements are in a particular Contiguous range like(1 to n) then its best solution always comes from the help of array indices. In all such cases array indices can be used a  marker for these elements. for ex here to mark that element 5 is there in array just make element at 4th index as negative. But Caution because as some elements are missing from array some may be repeated too. so if there is already negative element at the marker then don't make it negative.
*/

class Solution {
public static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> l=new ArrayList<Integer>();
        int [] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]-1] = nums[i];

        }
        for(int j=0;j<arr.length;j++){
            if(arr[j] == 0){
                l.add(j+1);
            }

        }
        return l;
    }
}