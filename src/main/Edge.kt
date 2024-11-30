package main

class Edge(val source: String, val destination: String, private val weight: Int) {
    // Returns the weight of the edge
    fun getWeight(): Int {
        return weight
    }

    // Method to print the edge
    override fun toString(): String {
        return "($destination, $weight)"
    }
}
