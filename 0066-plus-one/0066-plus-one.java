class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
  // if a digit is less than 9, just add 1 and return the new digit array
                digits[i]++;
                return digits;
            }else{
// if digit is 9, make it zero and in the next iteration the next value will get increment
                digits[i]=0;
            }
        }
        
    // if we are here means, every digit in array was 9. So create a new array with +1 size and make first digit Zero.
    // exp:  99 => create new array of size 3 => make its first digit 1 => return new array => 100;
        int[] arr=new int [digits.length+1];
        arr[0]=1;
        return arr;
    }
}