package aws;

public class Graph {
	private int[][] adjMatrix;
	int vertice; // number of vertices
	int edge; // number of edges in graph

	public Graph(int vertice) {
		this.vertice = vertice;
		this.edge = 0;
		this.adjMatrix = new int[vertice][vertice];
	}

	public void addEdge(int u, int v) {
		adjMatrix[u][v] = 1;
		adjMatrix[v][u] = 1;
		edge++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(vertice + " vertices, " + edge + " edges " + "\n");
		for (int v = 0; v < vertice; v++) {
			sb.append(v + ": ");
			for (int w : adjMatrix[v])
				sb.append(w + " ");

			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		System.out.println("Done!");
		System.out.println(g);
	}

}
