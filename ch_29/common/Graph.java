package ch_29.common;

public interface Graph<V> {
  /** Return the number of vertices in the graph */
  public int getSize();

  /** Return the vertices in the graph */
  public java.util.List<V> getVertices();

  /** Return the object for the specified vertex index */
  public V getVertex(int index);

  /** Return the index for the specified vertex object */
  public int getIndex(V v);

  /** Return the neighbors of vertex with the specified index */
  public java.util.List<Integer> getNeighbors(int index);

  /** Return the degree for a specified vertex */
  public int getDegree(int v);

  /** Print the edges */
  public void printEdges();

  /** Clear the graph */
  public void clear();

  /** Add a vertex to the graph */  
  public boolean addVertex(V vertex);

  /** Add an edge (u, v) to the graph */  
  public boolean addEdge(int u, int v);

  /** Add an edge to the graph */  
  public boolean addEdge(Edge e);

  /** Remove a vertex v from the graph, return true if successful */  
  public boolean remove(V v);

  /** Remove an edge (u, v) from the graph */  
  public boolean remove(int u, int v);
  
  /** Obtain a depth-first search tree */
  public UnweightedGraph<V>.SearchTree dfs(int v);

  /** Obtain a breadth-first search tree */
  public UnweightedGraph<V>.SearchTree bfs(int v);
}
