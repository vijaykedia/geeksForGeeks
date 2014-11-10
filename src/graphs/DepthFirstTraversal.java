package graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstTraversal {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addUnOrdered(0, 1);
		g.addUnOrdered(0, 2);
		g.addUnOrdered(1, 3);
		g.addUnOrdered(2, 5);
		g.addUnOrdered(1, 4);
		g.addUnOrdered(2, 6);
		depthFirstTraversal(g, 2);
	}

	static void depthFirstTraversal(Graph g, int start) {
		// initialize two lookup tables 1. stack and 2 . Set
		Stack<Vertex> _lookup = new Stack<Vertex>();
		Set<Vertex> state = new HashSet<Vertex>();
		// add the vertices in set which will help in resolving the loops
		Vertex temp = g.getVertex(start);
		state.add(temp);
		while (true) {
			System.out.print(temp.getData() + "\t");
			for (Edge e : g.getPair().get(temp)) {
				if (state.contains(e.destination)) {
					continue;
				} else {
					_lookup.push(e.destination);
					state.add(e.destination);
				}
			}
			if (_lookup.isEmpty()) {
				break;
			}
			temp = _lookup.pop();
		}
	}
}
