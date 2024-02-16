class Solution {
    
        static class Pair{
        int num;
        int freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int findLeastNumOfUniqueInts(int[] ar, int k) {
        int n = ar.length;

        HashMap<Integer,Integer> hp = new HashMap<>();

        for(int i=0; i<n; i++){
            hp.put(ar[i],hp.getOrDefault(ar[i],0)+1);
        }

        ArrayList<Pair> arr = new ArrayList<>();

        for(var a : hp.keySet()){
            arr.add(new Pair(a,hp.get(a)));
        }

        Collections.sort(arr,(a,b)->b.freq-a.freq);

        while(k>0){
            int freq = arr.get(arr.size()-1).freq;
            if(freq<=k){
                arr.remove(arr.size()-1);
                k=k-freq;
            }else{
                break;
            }
        }
        return arr.size();
    }
}