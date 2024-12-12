package main

class Graph(private val data: MutableList<Triple<String, String, Int>>) {
    private val graph = generate()

    // Go over data, add vertices, then add edges
    private fun generate(): MutableMap<String, MutableSet<Edge>> {
        val graph = mutableMapOf<String, MutableSet<Edge>>()

        // First go over the graph and add the vertices
        for (line in data) {
            val source = line.first // u
            val destination = line.second // v

            if (!graph.containsKey(source))
                graph[source] = mutableSetOf()

            if (!graph.containsKey(destination))
                graph[destination] = mutableSetOf()
        }

        // Add edges to both vertices
        for (line in data) {
            val source = line.first // u
            val destination = line.second // v
            val weight = line.third // w

            // Add sources and destination and weights to the graph, only if the do not already exist
            if (graph[source]?.none { it.destination == destination } == true) {
                graph[source]?.add(Edge(source, destination, weight))
            }
            if (graph[destination]?.none { it.destination == source } == true) {
                graph[destination]?.add(Edge(destination, source, weight))
            }
        }

        return graph
    }

    // Method to print the graph in a readable format
    override fun toString(): String {
        var str: String = ""

        for ((u, edges) in graph) {
            str += "$u -> $edges\n"
        }

        return str
    }

    // Get edges
    fun getEdges(): MutableList<Edge> {
        val edges = mutableListOf<Edge>()

        for ((_, edgeSet) in graph) {
            for (edge in edgeSet) {
                edges.add(edge)
            }
        }

        return edges
    }

    // Get vertices
    fun getVertices(): MutableList<String> {
        return graph.keys.toMutableList()
    }
}