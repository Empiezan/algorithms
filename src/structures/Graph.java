package structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph<X> {
	
	private BitGraph adjMatrix;
	protected ArrayList<X> nodeList;
	private static final int DEFAULT_CAPACITY = 5;
	private int size;
	private int capacity;
	
	public Graph(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.nodeList = new ArrayList<X>();
		this.adjMatrix = new BitGraph(capacity);
	}
	
	public Graph() {
		this(DEFAULT_CAPACITY);
	}
	
	public Graph(Graph g) {
		this.adjMatrix = g.adjMatrix;
		this.nodeList = g.nodeList;
		this.size = g.size;
		this.capacity = g.capacity;
	}
	
	public void addNode(X node) {
		if (nodeList.contains(node)) {
			throw new IllegalArgumentException("Graph already contains this object");
		}
		if (size >= capacity) {
			resize(Size.LARGER);
		}
		nodeList.add(node);
		adjMatrix.addEdge(size, size);
	}
	
	private void resize(Size s) {
		// TODO Auto-generated method stub
		if (s.equals(Size.LARGER)) {
			capacity *= 2;
		}
		else {
			capacity /= 2;
		}
		adjMatrix.resize();	
	}

	public X removeNode(X node) {
		for (int v = 0; v < size; ++v) {
			if (nodeList.contains(node)) {
				return node;
			}
		}
		throw new IllegalStateException("Node does not exist");
	}
	
	public void addEdge(X v, X u) {
		if (!nodeList.contains(v)) {
			addNode(v);
		}
		if (!nodeList.contains(u)) {
			addNode(u);
		}
		adjMatrix.addEdge(nodeList.indexOf(v), nodeList.indexOf(u));
	}

	public BitGraph getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(BitGraph adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public ArrayList<X> getNodeList() {
		return nodeList;
	}

	public void setNodeList(ArrayList<X> nodeList) {
		this.nodeList = nodeList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public static int getDefaultCapacity() {
		return DEFAULT_CAPACITY;
	}
	
	public int getNodeIndex(Object o) {
		for (int i = 0; i < nodeList.size(); ++i) {
			if (o.equals(nodeList.get(i))) {
				return i;
			}
		}
		throw new NoSuchElementException("Object does not exist in graph");
	}
	
	public Iterator<X> iterator() {
		return nodeList.iterator();
	}
}
