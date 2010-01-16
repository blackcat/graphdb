package dart.blackcat.graphdb.test.inmemory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dart.blackcat.graphdb.inmemmory.Edge;
import dart.blackcat.graphdb.inmemmory.Graph;
import dart.blackcat.graphdb.inmemmory.Node;
import dart.blackcat.graphdb.test.IdentifiableTestCase;

public class GraphTestCase extends IdentifiableTestCase<Graph> {
	
	private Graph g = new Graph();

	@Test
	public void testAddNode() {
		g.clear();
		
		Node n = NodeTestCase.initialize(0);
		g.addNode(n);
		assertTrue( g.hasNode(n.getId()) );
	}

	@Test
	public void testAddEdge() {
		g.clear();
		
		Edge e = EdgeTestCase.initialize(0);
		g.addNode(e.getBeginNode());
		g.addNode(e.getEndNode());
		try {
			g.addEdge(e);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		assertTrue( g.hasEdge(e.getId()) );
	}

	@Test
	public void testGetEdges() {
		fail("Not yet implemented");
	}

	@Override
	@Before
	public void init() {
		g.setId(0);
		
		a = new Graph[3];
		b = initialize(13);
		
		for (int i = 0; i < a.length; i++) {
			a[i] = initialize(i);
		}
		
	}

	public static Graph initialize(int seed) {
		Graph g0 = new Graph();
		
		Node n0 = NodeTestCase.initialize(0);
		Node n1 = NodeTestCase.initialize(1);
		Node n2 = NodeTestCase.initialize(2);
		
		Edge e0_1 = new Edge();		
		Edge e1_2 = new Edge();
		
		e0_1.setId(0);
		e0_1.setBeginNode(n0);
		e0_1.setEndNode(n1);
		
		e1_2.setId(1);
		e1_2.setBeginNode(n1);
		e1_2.setEndNode(n2);

		g0.addNode(n0);
		g0.addNode(n1);
		g0.addNode(n2);
		
		try {
			g0.addEdge(e0_1);
			g0.addEdge(e1_2);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return g0;
	}
}
