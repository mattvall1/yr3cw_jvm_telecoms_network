package main

// Minimum Spanning Tree - Kruskal's Algorithm
class MinimumSpanningTree(graph: Graph) {
    private val sortedEdges = graph.getEdges().sortedBy { it.getWeight() } // Sort edges by weight
    private val vertices = graph.getVertices()
    private val parent = mutableMapOf<String, String>()
    private val rank = mutableMapOf<String, Int>()

    // Find the root of the vertex using path compression
    private fun find(vertex: String): String {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]!!)
        }
        return parent[vertex]!!
    }

    // Union of two vertices - merge two vertices by linking their roots and update ranks
    private fun union(vertex: String, vertex2: String) {
        val root = find(vertex)
        val root2 = find(vertex2)

        if (rank[root]!! > rank[root2]!!) {
            parent[root2] = root
        } else if (rank[root]!! < rank[root2]!!) {
            parent[root] = root2
        } else {
            parent[root2] = root
            rank[root] = rank[root]!! + 1
        }
    }

    // Get the minimum spanning tree
    fun getMST(): List<Edge> {
        // Initialise parent and rank
        vertices.forEach { vertex ->
            parent[vertex] = vertex
            rank[vertex] = 0
        }

        val mst = mutableListOf<Edge>()
        // Iterate over sorted edges and add to the MST if they don't create a cycle
        for (edge in sortedEdges) {
            if (find(edge.source) != find(edge.destination)) {
                mst.add(edge)
                // Merge the two vertices (perform union)
                union(edge.source, edge.destination)
            }
        }

        // Return the list of edges forming the overall MST
        return mst
    }

    // Get the total cable length (return the sum of all weights)
    fun getTotalCableLength(): Int {
        return getMST().sumOf { it.getWeight() }
    }

}