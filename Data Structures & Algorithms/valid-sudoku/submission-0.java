class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowSet = new HashMap<>();
        Map<Integer, Set<Character>> colSet = new HashMap<>();
        Map<String, Set<Character>> subBoxSet = new HashMap<>();

        for(int r = 0; r < 9; r ++) {
            for(int c = 0; c < 9; c++) {
                if('.' == board[r][c]) {
                    continue;
                }

                String subBoxSetKey = (r / 3) + "," + (c / 3);

                if(rowSet.computeIfAbsent(r, k -> new HashSet()).contains(board[r][c])
                || colSet.computeIfAbsent(c, k -> new HashSet()).contains(board[r][c])
                || subBoxSet.computeIfAbsent(subBoxSetKey, k -> new HashSet()).contains(board[r][c])
                ) {
                    return false;
                }

                rowSet.get(r).add(board[r][c]);
                colSet.get(c).add(board[r][c]);
                subBoxSet.get(subBoxSetKey).add(board[r][c]);
            }
        }
        return true;
    }
}
