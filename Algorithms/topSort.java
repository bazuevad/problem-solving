// L ← Empty list that will contain the sorted elements
// S ← Set of all nodes with no incoming edges
// while S is non-empty do
// 	remove a node n from S
// 	add n to tail of L
// 	for each node m with an edge e from n to m do
// 		remove edge e from the graph
// 		if m has no other incoming edges then
// 			insert m into S
// if graph has edges then
// 	return error (graph has at least one cycle)
// else
// 	return L (a topologically sorted order)
	
	
public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    int n = jobs.size();
		List<Integer>[] edges = new List[n+1];
		
		int[] inc = new int[n+1];
		for(int i = 0; i < n+1;i++){
			edges[i] = new LinkedList<Integer>();
		}
		for(Integer[] pair: deps){
			inc[pair[1]]++;
			edges[pair[0]].add(pair[1]);
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i <n+1;i++){
			if(i==0){
				if(jobs.get(0)==1){
					continue;
				}
			}
			if(i==n){
				if(jobs.get(n-1)!=n){
					continue;
				}
			}
			if(inc[i]==0){
				q.offer(i);
			}
		}
		int edge = deps.size();
		List<Integer> res = new ArrayList<Integer>();
		while(!q.isEmpty()){
			int curr = q.poll();
			res.add(curr);
			for(int next: edges[curr]){
				edge--;
				inc[next]--;
				if(inc[next]==0){
					q.offer(next);
				}
			}
		}
		if(edge!=0){
			return new ArrayList<Integer>();
		}
		return res;
  }
