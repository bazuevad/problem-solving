
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] edges = new ArrayList[n];
        for(int i = 0;i <n;i++){
            edges[i] = new ArrayList<Integer>();
        }
        for(List<Integer> list:connections){
            edges[list.get(0)].add(list.get(1));
            edges[list.get(1)].add(list.get(0));
        }
        int[] rank = new int[n];
        Arrays.fill(rank,-2);
        HashSet<List<Integer>> set = new HashSet<>(connections);
        List<List<Integer>> critical = new ArrayList<>();
        dfs(0,0,edges,rank,set);
        return new ArrayList<>(set);
        
    }
    
    public int dfs(int node, int depth, List<Integer>[] map, int[] rank, HashSet<List<Integer>> critical){
        if(rank[node]>=0){
            return rank[node];
        }
        rank[node] = depth;
        int minDepth = depth;
        for(int neighbor: map[node]){
            //if neighbor is a parent, continue the serch
            if(rank[neighbor]==depth-1){
                continue;
            }
            int minDepthNeighbor = dfs(neighbor,depth+1,map,rank,critical);
            minDepth = Math.min(minDepth,minDepthNeighbor);
            if(minDepthNeighbor<=depth){
                critical.remove(Arrays.asList(node, neighbor));
                critical.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepth;
    }
