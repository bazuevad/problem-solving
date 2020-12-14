class Solution {
    int max = 0;
    public int dfs(int[][] M, int[] visited, int i) {
        if(visited[i]==1){
            return 0;
        }
        int count = 1;
        visited[i] = 1;

        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                int temp = dfs(M, visited, j);
                count+=temp;
            }
        }
        return count;
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                int curr = dfs(M, visited, i);
                max = Math.max(max,curr);
            }
        }
        return max;
    }
}





Solution test = new Solution();
int[][] matrix = {{1,1,0,0},{1,1,1,0},{0,1,1,0},{0,0,0,1}};
test.findCircleNum(matrix);
Solution test1 = new Solution();
int[][] matrix1 = {{1,1,0,},{1,1,0},{0,0,1}};
test1.findCircleNum(matrix1);
Solution test2 = new Solution();
int[][] matrix2 = {{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,0,0,0,1}};
test2.findCircleNum(matrix2);





public int maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    
    int [] left = new int[n];
    left[0] = nums[0];
    int [] right = new int[n];
    right[n - 1] = nums[n - 1];
    //populating left array
    for (int i = 1; i < n; i++) {
      // from left to right
      if (i % k == 0){
        left[i] = nums[i]; 
        }
      else{
        left[i] = Math.min(left[i - 1], nums[i]);
      } 
    }
    //populating right array
    for (int i = n-2; i >=0 ; i--) {      
      if (i % k == 0){
        right[i] = nums[i]; 
      }
      else{
        right[i] = Math.min(right[i + 1], nums[i]);
      }
    }
    int [] output = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++){
      output[i] = Math.min(left[i + k - 1], right[i]);
    }
    int ret = Integer.MIN_VALUE;
    for(int i = 0; i < output.length; i++){
        ret = Math.max(ret,output[i]);
    }
    return ret;
}

int[] ex = {1,5,3,2};
maxSlidingWindow(ex,2);
