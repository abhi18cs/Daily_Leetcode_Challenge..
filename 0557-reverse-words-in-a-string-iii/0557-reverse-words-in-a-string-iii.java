class Solution {
    public String reverseWords(String s) {
        String[] t=s.split(" ");
        StringBuilder str=new StringBuilder();
        for(int i=0;i<t.length;i++){
            char[] a=t[i].toCharArray();
            int k=0,j=a.length-1;
            while(k<j){
                char tmp=a[k];
                a[k]=a[j];
                a[j]=tmp;
                k++;
                j--;
            }
            str.append(String.valueOf(a)+" ");
        }
        return str.toString().trim();
    }
}