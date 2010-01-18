package dart.blackcat.graphdb.test.inmemory;

import dart.blackcat.graphdb.store.Vertex;
import dart.blackcat.graphdb.test.IdentifiableTestCase;


public class NodeTestCase extends IdentifiableTestCase<Vertex> {

	@Override
	public void init() {
		a = new Vertex[3];
		b = new Vertex();
		
		for (int i = 0; i < a.length; i++) {
			a[i] = new Vertex();
			a[i].setId(i);
		}
		b.setId(0);
		
		origin = a[0];
		clone = origin.clone();
	}

	public static Vertex initialize(int seed) {
		Vertex n = new Vertex();
		n.setId(seed);
		return n;
	}
}
