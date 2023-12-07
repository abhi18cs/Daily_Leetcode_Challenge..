class Solution {
    public String largestOddNumber(String num) {
    String res = "";
        int len = num.length();
        for (int i = 0; i < len; i++) {
            String i1 = num.substring(i);
            String i2 = num.substring(0, len - i);
            if (Integer.valueOf(i1.charAt(i1.length() - 1)) % 2 == 1 && Integer.valueOf(i2.charAt(i2.length() - 1)) % 2 == 1) {
                return compare(i1, i2);
            } else if (Integer.valueOf(i1.charAt(i1.length() - 1)) % 2 == 1 && Integer.valueOf(i2.charAt(i2.length() - 1)) % 2 == 0) {
                return i1;
            } else if (Integer.valueOf(i1.charAt(i1.length() - 1)) % 2 == 0 && Integer.valueOf(i2.charAt(i2.length() - 1)) % 2 == 1)  {
                return i2;
            }
        }
        return "";
    }

    private String compare(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return str1;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return str2;
            }
        }
        return str1;
    }
}
