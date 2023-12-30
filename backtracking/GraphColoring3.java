package backtracking;

/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/
 
import java.util.Scanner;
 
/** Class GraphColoring **/
public class GraphColoring3
{    
    private int V, numOfColors;
    private int[] color; 
    private int[][] graph;
 
    /** Function to assign color **/
    public void graphColor(int[][] g, int noc)
    {
        V = g.length;
        numOfColors = noc;
        color = new int[V];
        graph = g;
        int startVertex = 0;
 
        try
        {
            //solve(0);
        	color[startVertex] = 1;
        	mColoring(startVertex);
            System.out.println("No solution");
        }
        catch (Exception e)
        {
            System.out.println("\nSolution exists ");
            display();
        }
    }
 
    
    /** function to assign colors recursively **/
	public void mColoring(int vertex) throws Exception {

		if (promising(vertex)) {
			/** base case - solution found **/
			if (vertex == V) {
				display();
			}
			/** try all colours- Try Every color to next vertex **/
			for (int c = 1; c <= numOfColors; c++) {
				//System.out.println("vertex " + vertex + " color " + c);
				/** assign and proceed with next vertex **/
				display();
				color[vertex+1] = c;
				mColoring(vertex + 1);

			}
		}

	}
    
    //Bounded condition : Every Vertex's Adjaceny Not contains same color
	//Ex: A's Adjaceny list - [ 0,1,0,1] A's Adjaceny list B and D
	//Here CurrentVertex - A, A's Adjaceny list [0,1,0,1], Check A's Color equals A's Adjaceny List Vertex Colors
	public boolean promising(int currentVertex) {		
		for (int j = 0; j < V; j++) {
			if (graph[currentVertex][j] == 1 && color[j] == color[currentVertex]) {
				return false;
			}
		}
		return true;
	}
	
    /** display solution **/
    public void display()
    {
        System.out.print("\nColors : ");
        for (int i = 0; i < V; i++)
            System.out.print(color[i] +" ");
        System.out.println();
    }    
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Graph Coloring Algorithm Test\n");
        /** Make an object of GraphColoring class **/
        GraphColoring3 gc = new GraphColoring3();
 
        /** Accept number of vertices **/
		/*
		 * System.out.println("Enter number of verticesz\n"); int V = scan.nextInt();
		 */
        int V = 4;
 
        /** get graph **/
        System.out.println("\nEnter matrix\n");
		/*
		 * int[][] graph = new int[V][V]; for (int i = 0; i < V; i++) for (int j = 0; j
		 * < V; j++) graph[i][j] = scan.nextInt();
		 */
        
        int[][] graph = {{0,1,0,1},
    		              {1,0,1,0},
	                      {0,1,0,1},
	                      {1,0,1,0}};
 
		/*
		 * System.out.println("\nEnter number of colors"); int c = scan.nextInt();
		 */
        int c = 3;
 
        gc.graphColor(graph, c);
 
    }
}

/***


Output --> 

Graph Coloring Algorithm Test


Enter matrix

Vertex - 0

Colors : 1 0 0 0 
Vertex - 1
1 - 0 - 1 Color row - Column1 1

Colors : 1 1 0 0 
Vertex - 1
1 - 0 - 1 Color row - Column2 1

Colors : 1 2 0 0 
Vertex - 2
2 - 0 - 0 Color row - Column1 1
2 - 1 - 1 Color row - Column1 2

Colors : 1 2 1 0 
Vertex - 3
3 - 0 - 1 Color row - Column1 1

Colors : 1 2 1 1 
Vertex - 3
3 - 0 - 1 Color row - Column2 1
3 - 1 - 0 Color row - Column2 2
3 - 2 - 1 Color row - Column2 1

Colors : 1 2 1 2 

Solution exists 

Colors : 1 2 1 2 

**/