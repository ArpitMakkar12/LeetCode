class Solution {

    public boolean isSafe(char[][] board, int row, int col, int dig) {

        //horizontal
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == dig) {
                return false;
            }
        }

        //vertical
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == dig) {
                return false;
            }
        }

        //grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int i = startRow; i <= startRow + 2; i++) {
            for(int j = startCol; j <= startCol + 2; j++) {
                if(board[i][j] == dig) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean sudokuSolver(char[][] board, int row, int col) {
        if(row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        for(char dig = '1'; dig <= '9'; dig++) {
            if(isSafe(board, row, col, dig)) {
                board[row][col] = dig;
                if(sudokuSolver(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }
}