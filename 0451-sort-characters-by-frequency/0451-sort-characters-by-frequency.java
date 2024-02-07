class Solution {
    public class Pair implements Comparable<Pair>{
        int count=0;
        char s=' ';
        
        Pair(char s,int count){
            this.count=count;
            this.s=s;
        }
        @Override
        public int compareTo(Pair p){
           return p.count-this.count;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        
        for(Map.Entry<Character,Integer> mapElement:map.entrySet()){
            pq.add(new Pair(mapElement.getKey(),mapElement.getValue()));
        }
        String s1="";
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            for(int i=0;i<pair.count;i++){
                s1+=pair.s;
            }
        }
        return s1;
    }
}