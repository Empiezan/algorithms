package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import structures.Graph;

public class BFS {
	
	private HashSet<Integer> visited;
	private Queue<Integer> q;
	private Graph<?> g;
	private HashMap<Integer, Integer> connections;
	
	public BFS (Graph<?> g) {
		this.g = g;
		this.visited = new HashSet<Integer>();
		this.q = new PriorityQueue<Integer>();
		this.connections = new HashMap<Integer, Integer>();
	}
	
	public HashSet<Integer> getVisited() {
		return visited;
	}

	public void setVisited(HashSet<Integer> visited) {
		this.visited = visited;
	}

	public Graph<?> getGraph() {
		return g;
	}

	public void setG(Graph<?> g) {
		this.g = g;
	}
	
	public Queue<Integer> getQ() {
		return q;
	}

	public void setQ(Queue<Integer> q) {
		this.q = q;
	}

	public HashMap<Integer, Integer> getConnections() {
		return connections;
	}

	public void setConnections(HashMap<Integer, Integer> connections) {
		this.connections = connections;
	}

	public Graph<?> getG() {
		return g;
	}

	public void iterate(Object o) {
		Integer index = g.getNodeIndex(o);		
		q.add(index);
		
		while (!q.isEmpty()) {
			Integer currNodeIndex = q.poll();
			if (!visited.contains(currNodeIndex)) {
				visited.add(currNodeIndex);
				System.out.println(currNodeIndex);
				LinkedList<Integer> innerNeighbors = g.getAdjMatrix().getNeighbors(currNodeIndex);
				for (Iterator<Integer> nit = innerNeighbors.iterator(); nit.hasNext();) {
					Integer next = nit.next();
					if (!visited.contains(next)) {
						q.add(next);
						connections.put(currNodeIndex, next);
					}
				}
			}
		}
	}
	
	public HashSet<Integer> getConnected(Object o) {
		iterate(o);
		return visited;
	}
	
	public LinkedList<Integer> shortestPath(Object start, Object finish) {
		iterate(start);
		LinkedList<Integer> path = new LinkedList<Integer>();
		Integer startIndex = g.getNodeIndex(start);
		path.add(startIndex);
		while (connections.containsKey(startIndex)) {
			startIndex = connections.get(startIndex);
			path.add(startIndex);
		}
		
		if (path.isEmpty()) {
			throw new IllegalStateException("No path exists between the two nodes");
		}
		
		return path;
	}	
}
