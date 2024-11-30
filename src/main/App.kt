package main
import kotlin.system.exitProcess

class App {
    fun run() {
        val defaultFile = "src/main/capitals.txt"
        val path = "src/main/"

        // Ask user for filename input and create graph from data
        println("Enter filename: ")
        val file = readlnOrNull()
        val fileHandler = fileHandler(path + file, defaultFile)
        val graph = Graph(fileHandler.readFile())

        // Check graph created successfully (TODO: better error handling)
        if (graph.toString() == "") {
            println("Graph not created successfully")
            return
        }

        // View main menu
        val mainMenu = mainMenu()
        while (true) {
            // Open menu
            val selectedOption = mainMenu.run()

            // Handle menu options
            if (selectedOption == 1) {
                // Print graph
                println(graph)
            } else if (selectedOption == 2) {
                // Create MST class
                val MST = minimumSpanningTree(graph)

                // Create MST and print
                val mst = MST.getMST()
                val cableLength = MST.getTotalCableLength()
                println("Minimum Spanning Tree: $mst")
                println("Minimum Cable Length: $cableLength")

                continue
            } else if (selectedOption == 3) {
                // Terminate program normally
                println("Goodbye...")
                exitProcess(0)
            }
        }
    }
}