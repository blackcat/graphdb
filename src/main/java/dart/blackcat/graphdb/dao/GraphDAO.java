package dart.blackcat.graphdb.dao;

import java.util.List;
import java.util.Set;

import dart.blackcat.graphdb.store.Edge;
import dart.blackcat.graphdb.store.Vertex;

public interface GraphDAO {

	/**
	 * add vertex to graph, vertex should not be <code>null</code>
	 * 
	 * @throws NullPointerException in case argument is <code>null</code>
	 */
	public void addVertex(Vertex vertex);
	
	/**
	 * delete vertex from graph, vertex should not be <code>null</code>
	 * 
	 * @return <code>true</code> in case vertex was deleted, <code>false</code> otherwise
	 * @throws NullPointerException in case argument is <code>null</code>
	 */
	public boolean deleteVertex(Vertex vertex);
	
	/**
	 * @return <code>true</code> in case graph contains vertex, <code>false</code> otherwise
	 * @throws NullPointerException in case argument is <code>null</code>
	 */
	public boolean containsVertex(Vertex vertex);
	
	
	public void addEdge(Edge edge, Vertex v1, Vertex v2);
	public boolean deleteEdge(Edge edge);
	public boolean containsEdge(Edge edge);
	
	public boolean hasEdge(Vertex v1, Vertex v2);

	public Set<Edge> getIncomingEdges(Vertex v);
	public Set<Edge> getOutgoingEdges(Vertex v);
	
	public boolean areVertexesLinked(Vertex v1, Vertex v2);
	public List<Edge> findPath(Vertex v1, Vertex v2);
}
