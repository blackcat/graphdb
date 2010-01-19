package dart.blackcat.graphdb.logic.impl;

import java.util.List;
import java.util.Set;

import dart.blackcat.graphdb.dao.GraphDAO;
import dart.blackcat.graphdb.logic.GraphDBLogic;
import dart.blackcat.graphdb.store.Edge;
import dart.blackcat.graphdb.store.Vertex;

public class GraphDBLogicImpl implements GraphDBLogic {
	
	protected GraphDAO dao;
	
	public GraphDBLogicImpl(GraphDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addEdge(Edge edge, Vertex v1, Vertex v2) {
		dao.addEdge(edge, v1, v2);
	}

	@Override
	public void addVertex(Vertex vertex) {
		dao.addVertex(vertex);
	}

	@Override
	public boolean areVertexesLinked(Vertex v1, Vertex v2) {
		return dao.areVertexesLinked(v1, v2);
	}

	@Override
	public boolean containsEdge(Edge edge) {
		return dao.containsEdge(edge);
	}

	@Override
	public boolean containsVertex(Vertex vertex) {
		return dao.containsVertex(vertex);
	}

	@Override
	public List<Edge> findPath(Vertex v1, Vertex v2) {
		return dao.findPath(v1, v2);
	}

	@Override
	public Set<Edge> getIncomingEdges(Vertex v) {
		return dao.getIncomingEdges(v);
	}

	@Override
	public Set<Edge> getOutgoingEdges(Vertex v) {
		return dao.getOutgoingEdges(v);
	}

	@Override
	public boolean hasEdge(Vertex v1, Vertex v2) {
		return dao.hasEdge(v1, v2);
	}

	@Override
	public boolean removeEdge(Edge edge) {
		return dao.removeEdge(edge);
	}

	@Override
	public boolean removeVertex(Vertex vertex) {
		return dao.removeVertex(vertex);
	}

}
