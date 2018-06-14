package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import structures.BitGraph;
import structures.Graph;

public class BFS extends Graph<Object>{
	
	private HashSet<Object> visited;
	private Graph g;
	
	public BFS () {
		this.g = new Graph();
		this.visited = new HashSet<Object>();
	}
	
	public BFS (Graph g) {
		this();
		this.g = g;
	}
	
	public void iterate(Object o) {
		
	}
	
	public ArrayList<Object> getConnected() {
		return null;
		
	}
	
	public ArrayList<Object> shortestPath() {
		return null;
		
	}

	public HashSet<Object> getVisited() {
		return visited;
	}

	public void setVisited(HashSet<Object> visited) {
		this.visited = visited;
	}

	public Graph getG() {
		return g;
	}

	public void setG(Graph g) {
		this.g = g;
	}
	
}
