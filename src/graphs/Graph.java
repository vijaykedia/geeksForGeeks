package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private Map<Vertex, ArrayList<Edge>> pair;
	private Set<Vertex> vertices;

	Graph() {
		pair = new HashMap<Vertex, ArrayList<Edge>>();
		vertices = new HashSet<Vertex>();
	}

	public boolean contains(int data) {
		boolean flag = false;
		for (Vertex v : vertices) {
			if (v.getData() == data) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Vertex getVertex(int data) {
		if (contains(data) == true) {
			for (Vertex v : vertices) {
				if (v.getData() == data) {
					return v;
				}
			}
		}
		return null;
	}

	public void addUnOrdered(int source, int destination) {
		Vertex _source = null, _destination = null;
		if (contains(source) == true) {
			_source = getVertex(source);
		}
		if (contains(destination) == true) {
			_destination = getVertex(destination);
		}
		if (null == _source) {
			_source = new Vertex(source);
			vertices.add(_source);
		}
		if (null == _destination) {
			_destination = new Vertex(destination);
			vertices.add(_destination);
		}
		Edge _edge = new Edge(_destination);
		ArrayList<Edge> _pairs;
		if (pair.containsKey(_source) == true) {
			_pairs = pair.get(_source);
			_pairs.add(_edge);
			pair.put(_source, _pairs);
		} else {
			_pairs = new ArrayList<Edge>();
			_pairs.add(_edge);
			pair.put(_source, _pairs);
		}
		_edge = new Edge(_source);
		_pairs = null;
		if (pair.containsKey(_destination) == true) {
			_pairs = pair.get(_destination);
			_pairs.add(_edge);
			pair.put(_destination, _pairs);
		} else {
			_pairs = new ArrayList<Edge>();
			_pairs.add(_edge);
			pair.put(_destination, _pairs);
		}
		_pairs = null;
		_destination = null;
		_edge = null;
	}

	public void addOrdered(int source, int destination) {
		Vertex _source = null, _destination = null;
		if (contains(source) == true) {
			_source = getVertex(source);
		}
		if (contains(destination) == true) {
			_destination = getVertex(destination);
		}
		if (null == _source) {
			_source = new Vertex(source);
			vertices.add(_source);
		}
		if (null == _destination) {
			_destination = new Vertex(destination);
			vertices.add(_destination);
		}
		Edge _edge = new Edge(_destination);
		ArrayList<Edge> _pairs;
		if (pair.containsKey(_source) == true) {
			_pairs = pair.get(_source);
			_pairs.add(_edge);
			pair.put(_source, _pairs);
		} else {
			_pairs = new ArrayList<Edge>();
			_pairs.add(_edge);
			pair.put(_source, _pairs);
		}
		_pairs = null;
		_destination = null;
		_edge = null;
	}

	public void print() {
		System.out.println("Size of graph :" + vertices.size());
		for (Vertex v : pair.keySet()) {
			System.out.print(v.getData() + " : ");
			for (Edge e : pair.get(v)) {
				System.out.print(e.destination.getData() + "  ");
			}
			System.out.println("");
		}
	}

	public Map<Vertex, ArrayList<Edge>> getPair() {
		return pair;
	}

	public void setPair(Map<Vertex, ArrayList<Edge>> pair) {
		this.pair = pair;
	}

	public Set<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Vertex> vertices) {
		this.vertices = vertices;
	}

}

class Vertex {
	private int data;

	Vertex(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

}

class Edge {
	Vertex destination;
	double cost;

	Edge(Vertex destination) {
		this(destination, 1.0);
	}

	Edge(Vertex destination, double cost) {
		this.destination = destination;
		this.cost = cost;
	}
}