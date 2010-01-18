package dart.blackcat.graphdb.store;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;

public class InMemoryGraphStore implements GraphStore {
	
	private static final Log log = LogFactoryImpl.getLog(InMemoryGraphStore.class);
	
	protected Graph<Vertex, Edge> graph;

	public InMemoryGraphStore() {

		log.info("In memory graph implementation.");
		log.info("Starting...");
		
		graph = new DirectedSparseMultigraph<Vertex, Edge>();
		
		// graph itself
		Vertex[] nodes = new Vertex[5];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Vertex();
			nodes[i].setId(i);
			graph.addVertex(nodes[i]);
		}
		Edge[] edges = new Edge[70];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge();
			edges[i].setId(i);
		}
		graph.addEdge(edges[0], nodes[0], nodes[4]);
		graph.addEdge(edges[1], nodes[1], nodes[3]);
		graph.addEdge(edges[2], nodes[1], nodes[4]);
		graph.addEdge(edges[3], nodes[4], nodes[0]);
		graph.addEdge(edges[4], nodes[2], nodes[4]);
		graph.addEdge(edges[5], nodes[3], nodes[3]);
		graph.addEdge(edges[6], nodes[0], nodes[3]);

		graph.addEdge(edges[7], nodes[3], nodes[3]);
		graph.addEdge(edges[8], nodes[3], nodes[3]);
		graph.addEdge(edges[9], nodes[3], nodes[3]);
		graph.addEdge(edges[10], nodes[3], nodes[3]);
		graph.addEdge(edges[11], nodes[3], nodes[3]);
		graph.addEdge(edges[12], nodes[3], nodes[3]);
		graph.addEdge(edges[13], nodes[3], nodes[3]);
		graph.addEdge(edges[14], nodes[3], nodes[3]);
		graph.addEdge(edges[15], nodes[3], nodes[3]);
		graph.addEdge(edges[16], nodes[3], nodes[3]);
	}
	
	public Graph<Vertex, Edge> getGraph() {
		return graph;
	}

}
