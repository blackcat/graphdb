package dart.blackcat.graphdb.inmemmory;

import java.io.Serializable;

import dart.blackcat.graphdb.Identifiable;

public class Edge implements Identifiable, Serializable {
	
	private static final long serialVersionUID = 4704029787019754216L;
	private long id;
	private Node beginNode;
	private Node endNode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Node getBeginNode() {
		return beginNode;
	}

	public void setBeginNode(Node beginNode) {
		this.beginNode = beginNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginNode == null) ? 0 : beginNode.hashCode());
		result = prime * result + ((endNode == null) ? 0 : endNode.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Edge other = (Edge) obj;
		if (beginNode == null) {
			if (other.beginNode != null)
				return false;
		} else if (!beginNode.equals(other.beginNode))
			return false;
		if (endNode == null) {
			if (other.endNode != null)
				return false;
		} else if (!endNode.equals(other.endNode))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [beginNode=" + beginNode + ", endNode=" + endNode
				+ ", id=" + id + "]";
	}

	@SuppressWarnings("unchecked")
	public <T extends Edge> T clone() {
		T clone = (T) new Edge();
		clone.id = this.id;
		clone.beginNode = this.beginNode;
		clone.endNode = this.endNode;
		return clone;
	}
}
