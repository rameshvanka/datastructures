package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *      1 
 *   2    3
 *   
 * 4   5 6   
 * 
 *   7   8
 * 
 * 
 */

/**
 * Notes:
 * Enqueue: REAR END
 * Dequeue: FRONT END
 * 
 * Algorithm:
 * 
 * Step 1: Dequeue Vertex 'V' from queue
 * 
 * Step 2: Enqueue all the unvisited adjacent vertices of 'v' into queue and set status as visited & Display it
 */

public class BFS {
	
	public static void main(String[] args) {
		System.out.println("BFS example");
		Node rootNode = GraphMock.createBfsMock();
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		Node node1 = new Node(1);
		bfsForGraph(rootNode);
		System.out.println(" ");
		System.out.println("hasPathBFS :"+hasPathBFS(GraphMock.createBfsMock(),node1));
	}
	
	public static void bfsForGraph(Node node) {
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(node);
	    
	 
	    while (!queue.isEmpty()) {
	    	
	      //Step 1:	Dequeue Vertex 'V' from queue 
	      var currentNode = queue.poll();
	      
	      
	      //Step 2:	Enqueue all the unvisited adjacent vertices of 'v' into queue and set status as visited & Display it
	      if (!currentNode.isVisited()) {	    	       
	        queue.addAll(currentNode.getAdjacentNodes());
	        currentNode.updateVisited();	
	        System.out.print(currentNode.getValue() + " ");
	      }
	      
	    }
	  }
	
	
	public static boolean hasPathBFS(Node source, Node destination) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			
			//Step 1:	Dequeue Vertex 'V' from queue & Display it
			Node currentNode = queue.poll();
			
			
			
			if(currentNode.getValue() == destination.getValue()) {
				return true;
			}
			
			//Step 2:	Enqueue all the unvisited adjacent vertices of 'v' into queue and set status as visited
			if (!currentNode.isVisited()) {	
		        queue.addAll(currentNode.getAdjacentNodes());
		        currentNode.updateVisited();
		        System.out.print(currentNode.getValue() + " ");
		    }
			
		}
		
		return false;
		
	}


}
