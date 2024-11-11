package main

class Edge(val source: String, val destination: String, private val weight: Int) {
    // returns the vertex of the edge
    fun getSourceVertex(): String {
        return source
    }

    fun getDestinationVertex(): String {
        return destination
    }

    // returns the weight of the edge
    fun getWeight(): Int {
        return weight
    }

    // override the toString method to print the edge
    override fun toString(): String {
        return "($destination, $weight)"
    }
}
