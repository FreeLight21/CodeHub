public class MaxAreaOfIsland {
    //上下左右
    private static int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static int depth = 0;
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int ans = maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    public static int maxAreaOfIsland(int[][] grid){
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                   res = Math.max(res,dfs(grid,i,j));
                   depth = 0;
                }
            }
        }
        return res;
    }

    //dfs,多叉树的遍历问题,淹没岛屿的同时怎么记录岛的面积呢？
    private static int  dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j<0 || i >=m || j>=n){
            return 0;
        }

        if(grid[i][j] == 0){
            return 0;
        }
        //淹没岛屿，+1
        grid[i][j] = 0;
        depth++;
        for(int[] d : dirs){
            int next_i = i+d[0];
            int next_j = j+d[1];
            dfs(grid,next_i,next_j);
        }
        return depth;
    }

}
