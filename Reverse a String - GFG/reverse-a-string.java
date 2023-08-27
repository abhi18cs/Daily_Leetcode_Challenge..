//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Method-1 Using Traversing 
// class Reverse
// {
//     // Complete the function
//     // str: input string
//     public static String reverseWord(String str)
//     {
//         // Reverse the string str
//         String ans="";
//         char ch;
//         for(int i=0;i<str.length();i++){
//             ch=str.charAt(i);
//             ans=ch+ans;
//         }
//         return ans;
//     }
// }
//Method-2 USing String Builder
// class Reverse
// {
//     // Complete the function
//     // str: input string
//     public static String reverseWord(String str)
//     {
//         // Reverse the string str
//         StringBuilder sb=new StringBuilder();
//         sb.append(str);
//         sb.reverse();
//         return sb.toString();
//     }
    
// }
//Method-3 Using StringBuffer
class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuffer sb=new StringBuffer(str);
        sb.reverse();
        return sb.toString();
    }
    
}

//Method-3 Using StringBuffer
class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuffer sb=new StringBuffer(str);
        sb.reverse();
        return sb.toString();
    }
    
}











