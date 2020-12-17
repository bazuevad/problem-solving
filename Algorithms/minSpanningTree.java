    public int findParent(int x, int[] parents){
        while(parents[x]>0){
            x = parents[x];
        }
        return x;
    }
    public int minimumSpanningTree(int N, int[][] connections) {
        int[] parents = new int[N+1];
        Arrays.fill(parents,-1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int[] conn: connections){
            pq.add(conn);
        }
        int sum = 0;
        int edge = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int root1 = findParent(x,parents);
            int root2=findParent(y,parents);
            if(root1!=root2){
                edge++;
                sum+=curr[2];
                parents[root2]=root1;
            }
        }
        if(edge!=N-1){
            return -1;
        }
        return sum;
        
    }