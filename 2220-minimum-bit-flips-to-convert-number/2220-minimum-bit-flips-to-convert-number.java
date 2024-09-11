class Solution {
    public int minBitFlips(int start, int goal) {
        if(start==goal) return 0;
        String s=Integer.toBinaryString(start);
        String g=Integer.toBinaryString(goal);
        int count=0;
        if(s.length() >g.length()){
            int diff=s.length()- g.length();
            while(diff-->0)
                g=0+g;
        }
        else if (g.length() >s.length()){
            int diff=g.length()- s.length();
            while(diff-->0)
                s=0+s;
        }
        for( int i=g.length()-1;i>=0;i--){
            if(s.charAt(i)!=g.charAt(i))
                count++;
        }
        return count;
        
    }
}