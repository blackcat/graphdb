package dart.blackcat.graphdb.test.inmemory;

import dart.blackcat.graphdb.inmemmory.Node;
import dart.blackcat.graphdb.test.IdentifiableTestCase;


public class NodeTestCase extends IdentifiableTestCase<Node> {

	@Override
	public void init() {
		a = new Node[3];
		b = new Node();
		
		for (int i = 0; i < a.length; i++) {
			a[i] = new Node();
			a[i].setId(i);
		}
		b.setId(0);
		
		origin = a[0];
		clone = origin.clone();
	}

	public static Node initialize(int seed) {
		Node n = new Node();
		n.setId(seed);
		return n;
	}
}
