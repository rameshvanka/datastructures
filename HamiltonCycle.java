package backtracking;

import java.util.Arrays;

/* Let us create the following graph
(0)--(1)--(2)
 |   / \   |
 |  /   \  |
 | /     \ |
(3)-------(4)    */

public class HamiltonCycle {
	
	int V;
	int[] vindex = new int[5];
	int[][] graph;
	

	/** Function to assign color **/
	public void hamiltonCycle(int[][] g) {

		V = g.length;
		vindex = new int[V];
		graph = g;
		
		int startVertex = 0;		
		Arrays.fill(vindex, -1);

		try {			
			vindex[startVertex] = 0;
			hamilton(startVertex);
			System.out.println("No solution");			
		} catch (Exception e) {
			System.out.println("\nSolution exists ");			
		}
	}

	/** function to assign colors recursively **/
	public void hamilton(int vertex) throws Exception {

		if (promising(vertex)) {

			if (vertex == V - 1) {
				display();
			} else {
				for (int j = 1; j < V; j++) {
					vindex[vertex + 1] = j;
					hamilton(vertex + 1);
				}
			}

		}

	}

	public boolean promising(int currentVertex) {

		// 1st Bounded Condition - For last vertex, there should be vertex to first means First must be adjacent to the last vertex
		if (currentVertex == V - 1 && graph[vindex[V - 1]][vindex[0]] == 0) {
			return false;
		}

		// 2nd Bounded Condition - Every Vertex, there should be edge with previous vertex, ith vertex must be adjacent to (i-1)st.
		if (currentVertex > 0 && graph[vindex[currentVertex - 1]][vindex[currentVertex]] == 0) {
			return false;
		}

		
		
		//3rd Bounded Condition - Duplicate Check , Check if vertex is already selected
		for (int i = 0; i < currentVertex; i++) {
			if (vindex[i] == vindex[currentVertex]) {
				return false;
			}
		}

		return true;
	}

	public void display() {
		System.out.print("\nHamilton Cycle : ");
		for (int i = 0; i < V; i++)
			System.out.print(vindex[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		int graph[][] = { { 0, 1, 0, 1, 0 }, 
				          { 1, 0, 1, 1, 1 }, 
				          { 0, 1, 0, 0, 1 }, 
				          { 1, 1, 0, 0, 1 },
				          { 0, 1, 1, 1, 0 }
				         };
		
		

		HamiltonCycle hamiltonian = new HamiltonCycle();
		// Print the solution
		hamiltonian.hamiltonCycle(graph);
	}

}
