package graph;

import java.util.Arrays;

public class DFSMatrixRamesh {
	
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
	
	public static void dfsPath(int startRow, int startColumn, int[][] graphMatrix, boolean[][] visited) {
		
		int rowLength = graphMatrix.length;
		int columnsLength = graphMatrix[0].length;
		
		//System.out.println("rowLength:"+rowLength + " columns length:"+columnsLength);
		
		System.out.println("Ramesh - ("+startRow+","+startColumn+")");
		
		if(startRow < 0 || startRow >= rowLength || startColumn < 0 || startColumn >= columnsLength || graphMatrix[startRow][startColumn] == 1 || visited[startRow][startColumn]) {
			return;
		}	
		
		
		visited[startRow][startColumn] = true;
		System.out.println("Visited - ("+startRow+","+startColumn+")");
		
		int topRow = startRow-1;
		int bottomRow = startRow+1;
		
		int leftColumn = startColumn-1;
		int rightColumn =startColumn+1; 
		
		dfsPath(topRow, startColumn,  graphMatrix,  visited); // Move Top
		dfsPath(bottomRow, startColumn,  graphMatrix,  visited); // Move Bottom
		dfsPath(startRow,   leftColumn,graphMatrix,  visited); //Move Left
		dfsPath(startRow,   rightColumn,graphMatrix,  visited); //Move Right		
		
	}

}
