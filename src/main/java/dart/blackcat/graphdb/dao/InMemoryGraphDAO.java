package dart.blackcat.graphdb.dao;

import java.util.List;
import java.util.Set;

import dart.blackcat.graphdb.store.Edge;
import dart.blackcat.graphdb.store.GraphStore;
import dart.blackcat.graphdb.store.Vertex;
import edu.uci.ics.jung.graph.Graph;

public class InMemoryGraphDAO implements GraphDAO {
	
	protected Graph<Vertex, Edge> graph;
	
	public InMemoryGraphDAO(GraphStore graphStore) {
		graph = graphStore.getGraph();
	}

	@Override
	public void addEdge(Edge edge, Vertex v1, Vertex v2) {
		if (edge == null || v1 == null || v2 == null) {
			throw new NullPointerException("Arguments should not be null.");
		}
		graph.addEdge(edge, v1, v2);
	}

	@Override
	public void addVertex(Vertex vertex) {
		if (vertex == null) {
			throw new NullPointerException("Argument should not be null.");
		}
		graph.addVertex(vertex);
	}

	@Override
	public boolean areVertexesLinked(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Edge edge) {
		if (edge == null) {
			throw new NullPointerException("Argument should not be null.");
		}
		return graph.containsEdge(edge);
	}

	@Override
	public boolean containsVertex(Vertex vertex) {
		if (vertex == null) {
			throw new NullPointerException("Argument should not be null.");
		}
		return graph.containsVertex(vertex);
	}

	@Override
	public boolean removeEdge(Edge edge) {
		if (edge == null) {
			throw new NullPointerException("Argument should not be null.");
		}
		return graph.removeEdge(edge);
	}

	@Override
	public boolean removeVertex(Vertex vertex) {
		if (vertex == null) {
			throw new NullPointerException("Argument should not be null.");
		}
		return graph.removeVertex(vertex);
	}

	@Override
	public List<Edge> findPath(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Edge> getIncomingEdges(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Edge> getOutgoingEdges(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return false;
	}

}
