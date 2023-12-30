package graph;

import java.util.Arrays;

public class DFSMatrixRamesh2 {
	
	public static void main(String[] args) {
		System.out.println("DFS Matrix Ramesh");
		int[][] graphMatrix = { {0,1}, {1,0} };
		int startRow = 0;
		int startColumn = 0;
		
		int destRow = 1;
		int destColumn = 1;
		
		boolean[][] visited = new boolean[graphMatrix.length][graphMatrix[0].length];
		
		for(boolean[] visitedRow : visited) {
			Arrays.fill(visitedRow, false);
		}
		
		dfsPath(0,0,graphMatrix,visited);
		
		
		
		
	}
	
	public static String getStar(int length) {
		String temp = "";
		if(length >= 0) {
			for(int i=0; i <=length;i++) {
				temp = temp + "*"; 
			}
		}
		return temp;
	}
	
	public static void dfsPath(int startRow, int startColumn, int[][] graphMatrix, boolean[][] visited) {
		
		int rowLength = graphMatrix.length;
		int columnsLength = graphMatrix[0].length;
		
		//System.out.println("rowLength:"+rowLength + " columns length:"+columnsLength);
		
		System.out.println(getStar(startRow) + "("+startRow+","+startColumn+")  ");
		
		if(startRow < 0 || startRow >= rowLength || startColumn < 0 || startColumn >= columnsLength ||  visited[startRow][startColumn]) {
			return;
		}	
		
		
		visited[startRow][startColumn] = true;
		//System.out.println("Visited - ("+startRow+","+startColumn+")");
		
		
		
		//Here 4 directions only need to find (Move Left, Move Right, )
		
		//Move left, Move Right
		for( int row = startRow -1; row <= startRow + 1; row = row+2) {
			System.out.println("Left, Right (" + row + "," + startColumn + ")");
			dfsPath(row, startColumn,  graphMatrix,  visited);
		}
		
		//Move top, Move bottom
		for(int column = startColumn -1 ; column <= startColumn + 1 ; column = column + 2) {
			System.out.println("Top, Bottom (" + startRow + "," + column + ")");
			dfsPath(startRow, column,  graphMatrix,  visited);			
		}
		
		
		
	}

}
