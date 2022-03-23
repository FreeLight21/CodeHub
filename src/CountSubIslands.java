public class CountSubIslands {
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        int ans = countSubIslands(grid1,grid2);
        System.out.println(ans);
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j] == 1 && grid1[i][j] == 0){
                    dfs(grid2,i,j);
                }
            }
        }
        
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                 if(grid2[i][j] == 1 && grid1[i][j] == 1){
                    dfs(grid2,i,j);
                    res++;
                 }
            }
        }
        return res;
    }

    public static void dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i <0 || j<0 || i>=m || j>=n){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

}
