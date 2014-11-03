package geeksForGeeks.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstTraversal {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addUnOrdered(0, 1);
	    g.addUnOrdered(0, 2);
	    g.addUnOrdered(1, 3);
	    g.addUnOrdered(2, 5);
	    g.addUnOrdered(1, 4);
	    g.addUnOrdered(2, 6);
		breadthFirstTraversal(g, 3);
	}
	
	static void breadthFirstTraversal(Graph g, int start) {
		//initialize two lookup tables 1. stack and 2 . Set
		Queue<Vertex> _lookup = new LinkedList<Vertex>();
		Set<Vertex> state = new HashSet<Vertex>();
		
		//add the vertices in set which will help in resolving the loops
		Vertex temp = g.getVertex(start);
		state.add(temp);
		while (true) {
			System.out.print(temp.getData() + "\t");
			for (Edge e : g.getPair().get(temp)) {
				if (state.contains(e.destination)) {
					continue;
				} else {
					_lookup.add(e.destination);
					state.add(e.destination);
				}
			}
			if (_lookup.isEmpty()) {
				break;
			}
			temp = _lookup.poll();
		}
	}
}
