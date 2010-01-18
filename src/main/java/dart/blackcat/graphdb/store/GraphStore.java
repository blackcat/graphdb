package dart.blackcat.graphdb.store;

import edu.uci.ics.jung.graph.Graph;

public interface GraphStore {

	public Graph<Vertex, Edge> getGraph();
}
