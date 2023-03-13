class Solution {
    public String addBinary(String a, String b) {
        return new java.math.BigInteger(a,2).add(new java.math.BigInteger(b,2)).toString(2);
    }
}

// class Solution {
//     public String addBinary(String a, String b) {
//         StringBuilder res=new StringBuilder();
//         int add=0;
//         for(int i=1;i<=Math.max(a.length(),b.length());i++){
//             if(i<=a.length())
//                 add+=a.charAt(a.length()-i)-'0';
//             if(i<=b.length())
//                 add+=b.charAt(b.length()-i)-'0';
//             res.append(add%2);
//             add/=2;
//         }
//         if(add>0) res.append(1);
//         return res.reverse().toString();
//     }
// }