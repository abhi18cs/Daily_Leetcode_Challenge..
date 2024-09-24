class Solution {
    public class Trie{
        Trie child[];
        public Trie(){
            child=new Trie[10];
        }
    }
    Trie root=new Trie();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int j=0;j<arr1.length;j++){
            Trie temp=root;
            String x=Integer.toString(arr1[j]);
            for(int i=0;i<x.length();i++){
                int ind=x.charAt(i)-'0';
                if(temp.child[ind]==null)
                temp.child[ind]=new Trie();
                temp=temp.child[ind];
            }
        }
        int ans=0;
        for(int j=0;j<arr2.length;j++){
            Trie temp=root;
            int count=0;
            String x=Integer.toString(arr2[j]);
            for(int i=0;i<x.length();i++){
                int ind=x.charAt(i)-'0';
                if(temp.child[ind]==null)
                    break;
                 temp=temp.child[ind];
                count++;
            }
             ans=Math.max(ans,count);
        }
        return ans;
    }
}