package dart.blackcat.graphdb.test.inmemory;

import dart.blackcat.graphdb.store.Edge;
import dart.blackcat.graphdb.test.IdentifiableTestCase;


public class EdgeTestCase extends IdentifiableTestCase<Edge> {

	@Override
	public void init() {
		a = new Edge[3];
		b = new Edge();
		
		for (int i = 0; i < a.length; i++) {
			a[i] = new Edge();
			a[i].setId(i);
			a[i].setBeginNode(VertexTestCase.initialize(i * 10 + 1));
			a[i].setEndNode(VertexTestCase.initialize(i * 10 + 2));
		}
		b.setId(0);
		b.setBeginNode(VertexTestCase.initialize(1));
		b.setEndNode(VertexTestCase.initialize(2));
		
		origin = a[0];
		clone = origin.clone();
	}

	public static Edge initialize(int seed) {
		Edge n = new Edge();
		n.setId(seed);
		n.setBeginNode(VertexTestCase.initialize(seed * 10 + 1));
		n.setEndNode(VertexTestCase.initialize(seed * 10 + 2));
		return n;
	}
}
