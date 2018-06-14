package structures;

import java.util.*;

public class BitGraph {
	
	private ArrayList<BitSet> adjMatrix;
	private static final int DEFAULT_CAPACITY = 5;
	private int size;
	private int capacity;
	
	public BitGraph() {
		this(DEFAULT_CAPACITY);
	}
	
	public BitGraph(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.adjMatrix = new ArrayList<BitSet>(size);
		for (int v = 0; v < size; ++v) {
			adjMatrix.add(new BitSet());
		}
	}
	
	public BitGraph(BitGraph bG) {
		this(bG, bG.getSize());
	}
	
	public BitGraph(BitGraph bG, int size) {
		this(size);
		this.size = bG.size;
		for (int v = 0; v < adjMatrix.size(); ++v) {
			adjMatrix.add(bG.adjMatrix.get(v));
		}
	}
	
	public void addEdge(int v, int u) {
		if (v >= adjMatrix.size()) {
			resize();
		}
		if (u >= adjMatrix.get(v).size()) {
			doubleSetSize(v);
		}
		adjMatrix.get(v).set(u, 1);
		adjMatrix.get(u).set(v, 1);
	}
	
	public void removeEdge(int v, int u) {
		adjMatrix.get(v).set(u, 0);
	}
	
	private void doubleSetSize(int v) {
		// TODO Auto-generated method stub
		int setSize = adjMatrix.get(v).size();
		BitSet newSet = new BitSet(setSize * 2);
		for (int u = 0; u < setSize; ++u) {
			newSet.set(u, adjMatrix.get(v).get(u));
		}
		adjMatrix.set(v, newSet);
	}

	public void resize() {
		// TODO Auto-generated method stub
		size *= 2;
		ArrayList<BitSet> newMatrix = new ArrayList<BitSet>(size);
		for (int v = 0; v < size; ++v) {
			newMatrix.set(v, adjMatrix.get(v));
		}
		adjMatrix = newMatrix;
	}
	
	public int getSize() {
		return size;
	}
	
}
