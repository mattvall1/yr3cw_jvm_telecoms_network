package main
import kotlin.system.exitProcess

class App {
    fun run() {
        val defaultFile = "src/main/capitals.txt"
        val path = "src/main/"
        var createdGraph = false
        var cityGraph = Graph(mutableListOf())

        // Ask user for filename input and create graph from data
        while(!createdGraph) {
            println("Enter filename: ")
            val file = readlnOrNull()
            val fileHandler = FileHandler(path + file, defaultFile)
            cityGraph = Graph(fileHandler.readFile())

            // Check graph created successfully
            if (cityGraph.toString() == "") {
                println("Graph not created")
            } else {
                createdGraph = true
            }
        }

        // View main menu
        val mainMenu = MainMenu()
        while (true) {
            // Open menu
            val selectedOption = mainMenu.run()

            // Handle menu options
            if (selectedOption == 1) {
                // Print graph
                println(cityGraph)
            } else if (selectedOption == 2) {
                // Create MST class
                val minimumSpanningTree = minimumSpanningTree(cityGraph)

                // Create MST and print
                val mst = minimumSpanningTree.getMST()
                val cableLength = minimumSpanningTree.getTotalCableLength()
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