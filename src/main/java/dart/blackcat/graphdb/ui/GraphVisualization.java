package dart.blackcat.graphdb.ui;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import dart.blackcat.graphdb.store.Edge;
import dart.blackcat.graphdb.store.Vertex;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.renderers.BasicRenderer;

public class GraphVisualization {

	
	public GraphVisualization(Graph<Vertex, Edge> graph) {
		
		if (graph == null) {
			throw new NullPointerException("Graph can't be null.");
		}
		
		// ui
		Layout<Vertex, Edge> layout;
		layout = new KKLayout<Vertex, Edge>(graph);
		VisualizationViewer<Vertex, Edge> visualizationViewer = new VisualizationViewer<Vertex, Edge>(layout);
		
		BasicRenderer<Vertex, Edge> renderer = new BasicRenderer<Vertex, Edge>();
		
		visualizationViewer.setRenderer(renderer);
		RenderContext<Vertex, Edge> renderContext = visualizationViewer.getRenderContext();
		renderContext.setVertexLabelTransformer(new Transformer<Vertex, String>() {
			
			@Override
			public String transform(Vertex input) {
				return input.toString();
			}
		});
//		renderContext.setEdgeLabelTransformer(new Transformer<Edge, String>() {
//
//			@Override
//			public String transform(Edge input) {
//				return input.toString();
//			}
//			
//		});
		
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
