class MyHashMap {
    int []arr=new int[1000001];;
    public MyHashMap() {
       
        Arrays.fill(arr,-1);
    }
    
    public void put(int key, int value) {
        arr[key]=value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key]=-1;
    }
}

