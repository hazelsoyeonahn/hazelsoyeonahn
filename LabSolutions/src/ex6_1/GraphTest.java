package ex6_1;

/**
 * A class which demonstrates how a GraphADT graph is built
 * This class is modified to have only one edge between two vertexes
*/
public class GraphTest
{
	public static void main(String[] args)
	{  GraphADT<String> graph = new AdjacencyListGraph<String>();
	//adding Vertex
	Vertex<String> auckland = graph.addVertex("Auc");
	Vertex<String> wellington = graph.addVertex("Wel");
	Vertex<String> christchurch = graph.addVertex("Chr");
	Vertex<String> chatham = graph.addVertex("Cha");
	Vertex<String> fiji = graph.addVertex("Fij");
	Vertex<String> samoa = graph.addVertex("Sam");
	Vertex<String> tahiti = graph.addVertex("Tah");
	Vertex<String> brisbane = graph.addVertex("Bri");
	Vertex<String> sydney = graph.addVertex("Syd");
	Vertex<String> melbourne = graph.addVertex("Mel");
   
	//adding Edge
	graph.addEdge(melbourne, sydney);
	graph.addEdge(brisbane, tahiti);
	graph.addEdge(samoa, fiji);
	graph.addEdge(chatham, christchurch);
	// graph.addEdge(christchurch, wellington); // remove //to test functionality 
	graph.addEdge(wellington, auckland);
	//print the graph
	System.out.println(graph);
   
	}
}
