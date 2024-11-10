package main

class Graph(private val data: MutableList<Triple<String, String, Int>>) {
    private val graph = generate()

    // go over data, add vertices, then add edges
    private fun generate(): MutableMap<String, MutableSet<Edge>> {
        val graph = mutableMapOf<String, MutableSet<Edge>>()

        // first go over the graph and add the vertices
        for (line in data) {
            val source = line.first // u
            val destination = line.second // v

            if (!graph.containsKey(source))
                graph[source] = mutableSetOf()

            if (!graph.containsKey(destination))
                graph[destination] = mutableSetOf()
        }

        // add edges to both vertices
        for (line in data) {
            val source = line.first // u
            val destination = line.second // v
            val weight = line.third // w

            graph[source]?.add(Edge(source, destination, weight))
            graph[destination]?.add(Edge(source, destination, weight))
        }

        return graph
    }

    override fun toString(): String {
        var str: String = ""

        for ((u, edges) in graph) {
            str += "$u -> $edges\n"
        }

        return str
    }

    fun getEdges(): MutableList<Edge> {
        val edges = mutableListOf<Edge>()

        for ((_, edgeSet) in graph) {
            for (edge in edgeSet) {
                edges.add(edge)
            }
        }

        return edges
    }

    fun getVertices(): MutableList<String> {
        return graph.keys.toMutableList()
    }
}