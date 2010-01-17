package dart.blackcat.graphdb.ui;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import static java.lang.Math.*;

import javax.swing.JFrame;

import dart.blackcat.graphdb.inmemmory.Edge;
import dart.blackcat.graphdb.inmemmory.Graph;
import dart.blackcat.graphdb.inmemmory.Node;

public class GraphMonitorFrame extends JFrame implements Observer {

	private static final long serialVersionUID = -478797786482309264L;

	protected static final int WIDTH = 500;
	protected static final int HEIGHT = 400;
	protected static final int FIRST_EDGE_ANGLE = 270;
	
	protected Graphics g;
	
	protected Graph graph;
	
	
	public GraphMonitorFrame() {
		setTitle("Graph Monitor");
		setSize(WIDTH, HEIGHT);
	}
	
	public void init() {
		g = getGraphics();
	}
	
	protected void printNode(Node node, Graph graph, int x, int y) {
		g.drawString("Node[" + node.getId() + "]", x, y);
	}
	
	protected void recursivePrint(Node node, Edge edge, Graph graph, int x, int y, Set<Node> nodeSet) {
		printNode(node, graph, x, y);		// print node
		nodeSet.remove(node);				// remove printed node
		
		Set<Edge> edges = graph.getEdges(node);	// find not printed edges
		double diffAngle = 2 * PI / edges.size();
		if (edge != null) {
			edges.remove(edge);
		}
		
		int l = 80;
		for (Iterator<Edge> i = edges.iterator(); i.hasNext();) {
			Edge currEdge = i.next();
							
			double angle = 1.5 * PI - diffAngle;		// print edge, x and y
			double x2d = x + l * cos(angle);
			double y2d = y + l * sin(angle);
			int x2 = (int) x2d;
			int y2 = (int) y2d;
			
			g.drawLine(x, y, x2, y2);
			
			if (currEdge.getBeginNode().equals(node)) {
				node = currEdge.getEndNode();
			} else {
				node = currEdge.getBeginNode();
			}

			if (nodeSet.contains(node)) {
				recursivePrint(node, currEdge, graph, x2, y2, nodeSet);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		graph = (Graph) o;
		
		int x = 250;
		int y = 200;
		
		Set<Node> nodeSet = graph.getNodes();
		while ( ! nodeSet.isEmpty()) {
			recursivePrint(nodeSet.iterator().next(), null, graph, x, y, nodeSet);
			x = x + 30;
		}
	}
	
	@Override
	public void repaint() {
		super.repaint();
		
		update(graph, null);
	}

}
