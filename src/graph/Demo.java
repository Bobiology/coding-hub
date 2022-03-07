package graph;

public class Demo {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		
		graph.removeEdge("A", "B");
		graph.removeNode("B");
		
		graph.print();
	}

}
