package main

class Edge(private val v: String, private val w: Int) {
    // returns the vertex of the edge
    fun get_vertex(): String {
        return v
    }

    // returns the weight of the edge
    fun get_weight(): Int {
        return w
    }

    // override the toString method to print the edge
    override fun toString(): String {
        return "($v, $w)"
    }
}
