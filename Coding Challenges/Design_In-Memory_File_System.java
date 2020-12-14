class FileSystem {
    File root;
    class File{
        boolean isFile;
        Map<String,File> map;
        StringBuilder content;
        public File(){
            this.isFile = false;
            map = new HashMap<>();
            content = new StringBuilder();
        }
    }

    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        ArrayList<String> res = new ArrayList<>();
        String[] paths = path.split("/");
        File curr = this.root;
        
        for(String pth: paths){
            if(pth.length()==0){
                continue;
            }
            curr = curr.map.get(pth);
        }
        
        if (curr.isFile){
            res.add(paths[paths.length-1]);
            return res;
        }
        for(String key:curr.map.keySet()){
            res.add(key);
        }
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        String[] paths = path.split("/");
        File curr = this.root;
        for(String pth: paths){
            if(pth.length()==0){
                continue;
            }
            if(!curr.map.containsKey(pth)){
                curr.map.put(pth,new File());
            }
            curr = curr.map.get(pth);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        
        String[] paths = filePath.split("/");
        File curr = this.root;
        for(String pth: paths){
            if(pth.length()==0){
                continue;
            }
            if(!curr.map.containsKey(pth)){
                curr.map.put(pth,new File());
            }
            curr = curr.map.get(pth);
        }
        if(curr.content.length()==0){
            curr.isFile=true;
        }
        curr.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        File curr = this.root;
        for(String pth: paths){
            if(pth.length()==0){
                continue;
            }
            curr = curr.map.get(pth);
        }
        return curr.content.toString();
    }
}