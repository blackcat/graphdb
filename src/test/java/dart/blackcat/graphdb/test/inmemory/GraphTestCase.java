package dart.blackcat.graphdb.test.inmemory;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dart.blackcat.graphdb.inmemmory.Edge;
import dart.blackcat.graphdb.inmemmory.Graph;
import dart.blackcat.graphdb.inmemmory.Node;
import dart.blackcat.graphdb.test.IdentifiableTestCase;

public class GraphTestCase extends IdentifiableTestCase<Graph> {
	
	private Graph g = new Graph();
	
	private Node n0 = NodeTestCase.initialize(0);
	private Node n1 = NodeTestCase.initialize(1);
	private Node n2 = NodeTestCase.initialize(2);

	private Edge e0 = EdgeTestCase.initialize(0);
	private Edge e1 = EdgeTestCase.initialize(1);

	@Override
	@Before
	public void init() {
		g.setId(0);
		
		a = new Graph[3];
		b = initialize(0);
		
		for (int i = 0; i < a.length; i++) {
			a[i] = initialize(i);
		}

		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		
		e0.setBeginNode(n0);
		e0.setEndNode(n1);
		e1.setBeginNode(n1);
		e1.setEndNode(n2);
		
		try {
			g.addEdge(e0);
			g.addEdge(e1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		origin = initialize(0);
		clone = origin.clone();
	}

	@Test
	public void testAddNode() {
		Node n = NodeTestCase.initialize(10);
		g.addNode(n);
		assertTrue( g.hasNode(n.getId()) );
	}

	@Test
	public void testAddEdge() {
		Edge e = new Edge();
		e.setId(10);
		e.setBeginNode(n0);
		e.setEndNode(n2);
		
		try {
			g.addEdge(e);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		assertTrue( g.hasEdge(e.getId()) );
	}

	@Test
	public void testGetEdges() {
		Set<Edge> edges = g.getEdges(n1);
		Set<Edge> origin = new HashSet<Edge>();
		origin.add(e0);
		origin.add(e1);
		assertEquals(origin, edges);
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
		
		g0.setId(seed);

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
