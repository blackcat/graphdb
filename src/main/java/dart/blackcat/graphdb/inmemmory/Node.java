package dart.blackcat.graphdb.inmemmory;

import java.io.Serializable;

import dart.blackcat.graphdb.Identifiable;

public class Node implements Identifiable, Serializable, Cloneable {
	
	private static final long serialVersionUID = -8381475532419657121L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends Node> T clone() {
		T clone = (T) new Node();
		clone.id = this.id;
		return clone;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + "]";
	}
	
}
