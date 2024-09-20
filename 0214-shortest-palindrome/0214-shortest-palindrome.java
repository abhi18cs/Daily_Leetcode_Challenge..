class Solution {
    private boolean isPalidrome(char[] arr, int i, int j) {
	while(i < j) {
		if(arr[i++] != arr[j--]) {
			return false;
		}
	}
	return true;
}

public String shortestPalindrome(String s) {
	char[] arr = s.toCharArray();
	int n = arr.length, i=n-1;
	while(i >= 0) {
		if(isPalidrome(arr, 0, i)) {
			break;
		}
		i--;
	}
	String rev = new StringBuilder(s.substring(i+1)).reverse().toString();
	return rev+s;
}
}