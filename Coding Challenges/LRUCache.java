class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer,Integer>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int val = map.get(key);
            map.remove(key);
            map.put(key,val);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size()==this.capacity&&!map.containsKey(key)){
            Map.Entry first = map.entrySet().iterator().next();
            map.remove(first.getKey());
            map.put(key,value);
        }
        else{
            if(map.containsKey(key)){
                map.remove(key);
            }
            map.put(key,value);
        }
    }
}
