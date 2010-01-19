package dart.blackcat.graphdb.store;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public interface GraphStore {

	public DirectedSparseMultigraph<Vertex, Edge> getGraph();
}
