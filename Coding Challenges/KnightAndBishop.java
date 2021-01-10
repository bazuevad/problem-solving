public class KnightAndBishop {
    public int knightAndBishop(int n, int startRow, int startCol, int endRow, int endCol, int bishopRow, int bishopCol){
        int[][] directions =new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow,startCol});
        Set<String> set = new HashSet<>();
        set.add(startRow+","+startCol);
        int res = 0;
        boolean bishop = true;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] curr = q.remove();
                // System.out.println(curr[0]);
                // System.out.println(curr[1]);
                if(curr[0]==endRow&&curr[1]==endCol){
                    return res;
                }
                for(int[] dir: directions){
                    int newR = curr[0]+dir[0];
                    int newC = curr[1] + dir[1];
                    // System.out.println(newR);
                    // System.out.println(newC);
                    // System.out.println("_____________");
                    if(!set.contains(newR+","+newC)&&newR>=0&&newR<n&&newC>=0&&newC<n){
                        int diffR = Math.abs(newR-bishopRow);
                        int diffC = Math.abs(newC-bishopCol);
                        if((diffR==diffC&&!bishop)||(diffR==0&&diffC==0&&bishop)||(diffR!=diffC)){
                            // System.out.println("start");
                            // System.out.println(newR);
                            // System.out.println(newC);
                            // System.out.println("end");
                            if(diffR==0&&diffC==0&&bishop){
                                bishop = false;
                            }
                            q.add(new int[]{newR, newC});
                            set.add(newR+","+newC);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
int n = 8;
int startRow = 4;
int startCol = 4;
int endRow = 2;
int endCol = 6;
int bishopRow = 2;
int bishopCol = 3;

KnightAndBishop test = new KnightAndBishop();
// test.knightAndBishop(n,startRow,startCol,endRow,endCol,bishopRow,bishopCol);
test.knightAndBishop(8,0,0,1,1,0,1);//4
test.knightAndBishop(5,0,0,4,3,3,0); //-1
test.knightAndBishop(5,4,2,0,1,1,3);//3
test.knightAndBishop(30,25,2,23,29,21,22);//15
test.knightAndBishop(7,6,6,0,1,4,4);//5
test.knightAndBishop(6,0,0,0,2,0,1);//2
test.knightAndBishop(6,5,1,0,5,2,3);//3
test.knightAndBishop(8,4,2,2,6,2,3);//4




