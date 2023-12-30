package graph;

import java.util.Stack;


/**
 * Algorithm:
 * 
 * Step 1:  Take any vertex as start vertex, Push it onto stack 
 * 
 * Step 2:  While Stack is Empty {
 *            2a) Select any unvisited adjacent vertex & Push it onto stack and make that unvisited vertex status as visited
 *            
 *            2b) If there is no unvisited adjacent vertices then do backtracking Ex: Pop a vertex from the stack. 
 * 
 *         }
 * 
 *         
 */
public class DFS {
	
	public static void main(String[] args) {
		System.out.println("DFS");
		Node rootNode = GraphMock.createBfsMock();
		dfsNonRecursive(rootNode);
		System.out.println(" ");
		System.out.println("********************");
		dfsRecursive(GraphMock.createBfsMock());
		System.out.println(" ");
		System.out.println("********************");
		
		Node source = GraphMock.createBfsMock();
		Node destination = new Node(6);
		System.out.println("hasPathDFS "+hasPathDFS(source,destination));
		
		
	}
	
	
	  
	    //This is main important concept of traversing *****  - Most of questions tweak here.
		public static void dfsRecursive(Node node) {
			
			System.out.print(node.getValue() + " ");
			//update the state of node
			node.updateVisited();

			//Traversing the nodes through adjacency list
			for (Node currentNode : node.getAdjacentNodes()) {
				if (!currentNode.isVisited()) {					
					dfsRecursive(currentNode);
				}
			}			
			
		}

	
	
	
	
		public static void dfsNonRecursive(Node node) {
			Stack<Node> stack = new Stack<Node>();
			// Step 1: Take any vertex as start vertex, Push it onto stack
			Node currentNode = node;
			stack.push(currentNode);

			while (!stack.isEmpty()) {

				currentNode = stack.pop();

				System.out.print(currentNode.getValue() + " ");
				currentNode.updateVisited();

				// 2a) Select any unvisited adjacent vertex & Push it onto stack and make that
				// unvisited vertex status as visited
				// traversing the nodes
				for (int i = currentNode.getAdjacentNodes().size() - 1; i >= 0; i--) {
					if (!currentNode.getAdjacentNodes().get(i).isVisited()) {
						stack.push(currentNode.getAdjacentNodes().get(i));
					}
				}
			}
		}
	
	public static boolean hasPathDFS(Node source,Node destination) {
		Stack<Node> stack = new Stack<Node>();
		// Step 1: Take any vertex as start vertex, Push it onto stack
		Node currentNode = source;
		stack.push(currentNode);

		while (!stack.isEmpty()) {

			currentNode = stack.pop();
			
			if(currentNode.getValue() == destination.getValue()) {
				return true;
			}

			// 2a) Select any unvisited adjacent vertex & Push it onto stack and make that
			// unvisited vertex status as visited
			if (!currentNode.isVisited()) {

				for (int i = currentNode.getAdjacentNodes().size() - 1; i >= 0; i--) {
					stack.push(currentNode.getAdjacentNodes().get(i));
				}

				currentNode.updateVisited();
				System.out.print(currentNode.getValue() + " ");
			}
		}
		
		return false;
	}

}
