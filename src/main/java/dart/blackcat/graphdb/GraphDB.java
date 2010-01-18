package dart.blackcat.graphdb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import dart.blackcat.graphdb.store.GraphStore;
import dart.blackcat.graphdb.store.InMemoryGraphStore;
import dart.blackcat.graphdb.ui.GraphVisualization;

public class GraphDB {
	
	private static final Log log = LogFactoryImpl.getLog(GraphDB.class);

	/**
	 * GraphDB boot class. 
	 * <br>Parameters
	 * (1) - graph implementation 'db', 'file' or 'inmemory' (default)
	 * (2) - is monitor need 'yes' / 'no', defaults to 'yes'
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		GraphStore store;
		GraphVisualization visualization;
		
		if (args.length >= 1) {
			
			if ("db".equals(args[0])) {
				log.error("Database graph not implemented yet."); // TODO database graph implementation
				return;
			} else if ("file".equals(args[0])) {
				log.error("File based graph not implemented yet."); // TODO file based graph implementation
				return;
			} else if ("inmemory".equals(args[0])) {
				store = new InMemoryGraphStore();
			} else {
				log.error("Unknown graph store implementation: " + args[0]);
				return;
			}
			
			if (args.length >= 2) {
				
				if ("yes".equals(args[1])) {
					visualization = new GraphVisualization(store.getGraph());
				} else if ( ! "no".equals(args[1])) {
					log.error("Unknown graph visualization parameter: " + args[1]);
					return;
				}
			}
		} else {
			store = new InMemoryGraphStore();
			visualization = new GraphVisualization(store.getGraph());
		}
	}

}
