class Solution {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int countOfIslands = 0;
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < column; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    countOfIslands ++;
                }
            }
        }
        return countOfIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
