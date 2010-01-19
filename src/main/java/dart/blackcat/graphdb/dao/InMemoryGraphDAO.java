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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVertex(Vertex vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean areVertexesLinked(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Vertex vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVertex(Vertex vertex) {
		// TODO Auto-generated method stub
		return false;
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
