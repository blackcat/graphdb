package dart.blackcat.graphdb.inmemmory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dart.blackcat.graphdb.Identifiable;

public class Graph implements Identifiable, Serializable {

	private static final long serialVersionUID = 6288219714830644682L;
	
	private long id;
	private Map<Long, Node> nodeMap				= new HashMap<Long, Node>();
	
	private Map<Node, Set<Edge>> beginNodeEdgeMap	= new HashMap<Node, Set<Edge>>();
	private Map<Node, Set<Edge>> endNodeEdgeMap		= new HashMap<Node, Set<Edge>>();
	
	
	public void addNode(Node node) {
		nodeMap.put(node.getId(), node);
	}
	
	public void addEdge(Edge edge) throws Exception {
		if ( ! nodeMap.containsKey(edge.getBeginNode().getId())) {
			throw new Exception("Begin node not found in graph.");
		}

		if ( ! nodeMap.containsKey(edge.getEndNode().getId())) {
			throw new Exception("End node not found in graph.");
		}
		
		Set<Edge> beginningEdges = beginNodeEdgeMap.get(edge.getBeginNode());
		if (beginningEdges == null) {
			beginningEdges = new HashSet<Edge>();
		}
		beginningEdges.add(edge);
		beginNodeEdgeMap.put(edge.getBeginNode(), beginningEdges);

		Set<Edge> endingEdges = endNodeEdgeMap.get(edge.getEndNode());
		if (endingEdges == null) {
			endingEdges = new HashSet<Edge>();
		}
		endingEdges.add(edge);
		endNodeEdgeMap.put(edge.getEndNode(), endingEdges);
	}
	
	public Set<Edge> getEdges(Node node) {
		Set<Edge> result = new HashSet<Edge>();

		result.addAll(beginNodeEdgeMap.get(node));
		result.addAll(endNodeEdgeMap.get(node));
		
		return result;
	}
	

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((beginNodeEdgeMap == null) ? 0 : beginNodeEdgeMap.hashCode());
		result = prime * result
				+ ((endNodeEdgeMap == null) ? 0 : endNodeEdgeMap.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nodeMap == null) ? 0 : nodeMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (beginNodeEdgeMap == null) {
			if (other.beginNodeEdgeMap != null)
				return false;
		} else if (!beginNodeEdgeMap.equals(other.beginNodeEdgeMap))
			return false;
		if (endNodeEdgeMap == null) {
			if (other.endNodeEdgeMap != null)
				return false;
		} else if (!endNodeEdgeMap.equals(other.endNodeEdgeMap))
			return false;
		if (id != other.id)
			return false;
		if (nodeMap == null) {
			if (other.nodeMap != null)
				return false;
		} else if (!nodeMap.equals(other.nodeMap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Graph [id=" + id + ", " + nodeMap.size() + " nodes]";
	}

	@SuppressWarnings("unchecked")
	public <T extends Graph> T clone() {
		T clone = (T) new Graph();
		clone.id = this.id;
		return clone;
	}
}
