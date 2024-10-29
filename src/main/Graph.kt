package main

class Graph(private val data: MutableList<Triple<String, String, Int>>) {
    private val graph = generate()

    // go over data, add vertices, then add edges
    private fun generate(): MutableMap<String, MutableSet<Edge>> {
        val graph = mutableMapOf<String, MutableSet<Edge>>()

        // first go over the graph and add the vertices
        for (line in data) {
            val u = line.first
            val v = line.second

            if (!graph.containsKey(u))
                graph[u] = mutableSetOf()

            if (!graph.containsKey(v))
                graph[v] = mutableSetOf()
        }

        // add edges to both vertices
        for (line in data) {
            val u = line.first
            val v = line.second
            val w = line.third

            graph[u]?.add(Edge(v, w))
            graph[v]?.add(Edge(u, w))
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
}