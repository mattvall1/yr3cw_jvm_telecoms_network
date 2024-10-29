package main

class App {
    fun run() {
        val backupFile = "src/main/capitals.txt"
        val path = "src/main/"

        println("Enter filename: ")
        val file = readlnOrNull()

        val fileHandler = FileHandler(path + file, backupFile)
        val graph = Graph(fileHandler.readFile())

        println(graph)

        return
    }
}