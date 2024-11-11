package main

class minimumSpanningTree(graph: Graph) {
    private val sortedEdges = graph.getEdges().sortedBy { it.getWeight() }
    private val vertices = graph.getVertices()
    private val parent = mutableMapOf<String, String>()
    private val rank = mutableMapOf<String, Int>()

    fun find(vertex: String): String {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]!!)
        }
        return parent[vertex]!!
    }

    fun union(vertex: String, vertex2: String) {
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

    fun getMST(): List<Edge> {
        vertices.forEach { vertex ->
            parent[vertex] = vertex
            rank[vertex] = 0
        }

        val mst = mutableListOf<Edge>()
        for (edge in sortedEdges) {
            if (find(edge.source) != find(edge.destination)) {
                mst.add(edge)
                union(edge.source, edge.destination)
            }
        }

        return mst
    }

    fun getTotalCableLength(): Int {
        return getMST().sumOf { it.getWeight() }
    }

}