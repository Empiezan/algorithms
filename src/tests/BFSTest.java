package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

import structures.Graph;
import algorithms.BFS;
import org.junit.Assert;

class BFSTest {

	@Test
	void test() {
		Integer i1 = 0;
		Integer i2 = 1;
		Integer i3 = 2;
		Integer i4 = 3;
		
		Graph<Integer> graph = new Graph<Integer>();
		graph.addNode(i1);
		graph.addNode(i2);
		graph.addNode(i3);
		graph.addNode(i4);
		
		graph.addEdge(i1, i2);
		graph.addEdge(i1, i4);
		graph.addEdge(i1, i3);
		graph.addEdge(i2, i3);
		graph.addEdge(i3, i4);
		graph.addEdge(i2, i4);
		
		BFS shortPath = new BFS(graph);
		LinkedList<Integer> calculatedPath = shortPath.shortestPath(i1, i4);
		Assert.assertTrue(shortPath.getGraph().getNodeList().size() == 4);
		
		LinkedList<Integer> shortestPath = new LinkedList<Integer>();
		shortestPath.add(i1);
		shortestPath.add(i4);
		
		Assert.assertTrue(calculatedPath.equals(shortestPath));
	}

}
