package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	  Object value;
	  private List<Node> adjacentNodes = new ArrayList<Node>();
	  private boolean visited;
	 
	  public Node(Object value) {
	    this.value = value;
	  }
	 
	  public void addAdjacentNode(Node node) {
	    this.adjacentNodes.add(node);
	  }
	 
	  public List<Node> getAdjacentNodes() {
	    return adjacentNodes;
	  }
	 
	 
	  public Object getValue() {	   
	    return value;
	  }
	 
	  public boolean isVisited() {
	    return visited;
	  }
	  
	  public void updateVisited() {
		  visited = true;
	  }

}
