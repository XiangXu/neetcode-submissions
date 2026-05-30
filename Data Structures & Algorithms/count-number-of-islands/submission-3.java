class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int counter = 0;
       
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    counter++;
                    bfs(grid, i, j, row, col, visited);
                }
            }
        }
        return counter;
    }
    
    private void bfs(char[][] grid, int currRow, int currCol, int row, int col, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {currRow, currCol});
        visited[currRow][currCol] = true;
       
        int[][] directions = { {1, 0}, {-1 , 0}, {0, 1}, {0, -1} };
        
        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            for(int[] direction : directions) {
                int startRow = position[0] + direction[0];
                int startCol = position[1] + direction[1];
                
                if(startRow < 0 || startRow >= row || startCol < 0 || startCol >= col 
                   || visited[startRow][startCol] || grid[startRow][startCol] != '1') {
                    continue;
                }
                queue.offer(new int[]{startRow, startCol});
                visited[startRow][startCol] = true;
            }
        }
    }
}