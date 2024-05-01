class Solution {
    public String reversePrefix(String word, char ch) {
        char[] ch1=word.toCharArray();
        int locate=0;
        for(int i=0;i<word.length();i++){
            if(ch==ch1[i]){
                locate=i;
                break;
            }
        }
        char res[]=new char[word.length()];
        for(int i=0;i<=locate;i++){
            res[i]=ch1[locate-i];  //for reverse
        }
        for( int i=locate+1;i<word.length();i++){
            res[i]=ch1[i];
        }
        return String.valueOf(res);
    }
}