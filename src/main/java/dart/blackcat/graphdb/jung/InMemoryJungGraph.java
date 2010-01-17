package dart.blackcat.graphdb.jung;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import dart.blackcat.graphdb.inmemmory.Edge;
import dart.blackcat.graphdb.inmemmory.Node;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class InMemoryJungGraph {
	
	private static final Log log = LogFactoryImpl.getLog(InMemoryJungGraph.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("In memory graph implementation with JUNG.");
		log.info("Starting...");
		
		Graph<Node, Edge> graph = new SparseMultigraph<Node, Edge>();
		
		// graph itself
		Node[] nodes = new Node[5];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node();
			nodes[i].setId(i);
			graph.addVertex(nodes[i]);
		}
		Edge[] edges = new Edge[70];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge();
			edges[i].setId(i);
		}
		graph.addEdge(edges[0], nodes[0], nodes[4]);
		graph.addEdge(edges[1], nodes[1], nodes[3]);
		graph.addEdge(edges[2], nodes[1], nodes[4]);
		graph.addEdge(edges[3], nodes[4], nodes[0]);
		graph.addEdge(edges[4], nodes[2], nodes[4]);
		graph.addEdge(edges[5], nodes[3], nodes[3]);
		graph.addEdge(edges[6], nodes[0], nodes[3]);

		graph.addEdge(edges[7], nodes[3], nodes[3]);
		graph.addEdge(edges[8], nodes[3], nodes[3]);
		graph.addEdge(edges[9], nodes[3], nodes[3]);
		graph.addEdge(edges[10], nodes[3], nodes[3]);
		graph.addEdge(edges[11], nodes[3], nodes[3]);
		graph.addEdge(edges[12], nodes[3], nodes[3]);
		graph.addEdge(edges[13], nodes[3], nodes[3]);
		graph.addEdge(edges[14], nodes[3], nodes[3]);
		graph.addEdge(edges[15], nodes[3], nodes[3]);
		graph.addEdge(edges[16], nodes[3], nodes[3]);
		
		// ui
		Layout<Node, Edge> layout = new KKLayout<Node, Edge>(graph);
		VisualizationViewer<Node, Edge> visualizationViewer = new VisualizationViewer<Node, Edge>(layout);
		GraphZoomScrollPane pane = new GraphZoomScrollPane(visualizationViewer);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(640, 480));
		frame.setTitle("Graph DB representation with JUNG");
		

		frame.setVisible(true);
	}

}
