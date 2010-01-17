package dart.blackcat.graphdb.ui;

import javax.swing.JFrame;

import dart.blackcat.graphdb.inmemmory.Edge;
import dart.blackcat.graphdb.inmemmory.Graph;
import dart.blackcat.graphdb.inmemmory.Node;

public class GraphMonitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph();
		g.setId(0);
		
		GraphMonitorFrame frame = new GraphMonitorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.init();
		
		g.addObserver(frame);
		

		Node n0 = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		n0.setId(0);
		n1.setId(1);
		n2.setId(2);
		n3.setId(3);

		Edge e0 = new Edge();
		Edge e1 = new Edge();
		Edge e2 = new Edge();
		e0.setId(0);
		e1.setId(1);
		e2.setId(2);
		e0.setBeginNode(n0);
		e1.setBeginNode(n0);
		e2.setBeginNode(n0);
		e0.setEndNode(n1);
		e1.setEndNode(n2);
		e2.setEndNode(n3);

		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
		g.addEdge(e0);
		g.addEdge(e1);
		g.addEdge(e2);
		
	}

}
