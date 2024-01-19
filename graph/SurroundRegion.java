package dfs;

public class SurroundRegion {
	
	public static void main(String[] args) {
		System.out.println("Surround Region Problem");
		//2D matrix with 1's as blocked  and 0's as path.
		char[][] board = {{'X','X','X','X','X'},
		                   {'O','O','X','O','X'},
				           {'O','X','X','O','X'},
				           {'X','X','X','X','X'}};
		
		print(board);
		solve(board);
		System.out.println();
		System.out.println("Surrounded Region Result");
		print(board);
	}
	
	public static void print(char[][] board) {
		for(int i=0; i < board.length; i++) {
			System.out.println("");
			for(int j=0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}
	
	

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'P';
                }
            }
        }

        for(int j = 0; j < n; j++) {
            dfsCore(0, j, board);
        }
        for(int j = 0; j < n; j++) {
            dfsCore(m - 1, j, board);
        }
        for(int i = 0; i < m; i++) {
            dfsCore(i, 0, board);
        }
        for(int i = 0; i < m; i++) {
            dfsCore(i, n - 1, board);
        }

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfsCore(int row, int col, char[][] board) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'P') {
            board[row][col] = 'O';
            dfsCore(row - 1, col, board);
            dfsCore(row + 1, col, board);
            dfsCore(row, col - 1, board);
            dfsCore(row, col + 1, board);
        }
    }

}
