package geeksForGeeks.graphs;

import java.util.HashMap;
import java.util.Map;

public class TopologicalSort {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addOrdered(0, 1);
	    g.addOrdered(0, 2);
	    g.addOrdered(1, 3);
	    g.addOrdered(2, 5);
	    g.addOrdered(1, 4);
	    g.addOrdered(2, 6);
		topologicalSort(g);
	}
	
	public static void topologicalSort(Graph g) {
		Map<Vertex, Boolean> lookup = new HashMap<Vertex, Boolean>();
		Map<Vertex, Integer> _lookup = new HashMap<Vertex, Integer>();
		Integer outdegree;
		for (Vertex v : g.getVertices()) {
			if (null == g.getPair().get(v)) {
				outdegree = 0;				
			} else {
				outdegree = g.getPair().get(v).size();
			}
			_lookup.put(v, outdegree);
		}
		while (true) {
			for (Vertex v : g.getVertices()) {
				if ( _lookup.containsKey(v)) {
					if (_lookup.get(v) == 0) {
						System.out.print(v.getData() + "\t");
						lookup.put(v, false);
						_lookup.remove(v);
					} else {
						for (Edge e : g.getPair().get(v)) {
							if (lookup.containsKey(e.destination) && lookup.get(e.destination) == false ) {
								_lookup.put(v, _lookup.get(v) -1);
								lookup.put(e.destination, true);
							}
						}
					}
				}
			}

			if (_lookup.isEmpty()) {
				break;
			}
		}
	}
	
}
