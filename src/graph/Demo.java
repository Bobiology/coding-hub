package graph;

public class Demo {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("D", "C");
		graph.addEdge("A", "C");
		
		//graph.removeEdge("A", "B");
		//graph.removeNode("B");
		
		graph.traverseDepthFirst("A");
		System.out.println("BFS");
		graph.traverseBreadthFirst("A");
		
		//graph.print();
	}

}
