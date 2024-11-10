package main

class mainMenu {
    fun run(): Int? {
        // Loop for menu system
        var selectedOption: Int? = null
        val validOptions = listOf(1, 2, 3)

        while(selectedOption !in validOptions) {
            // Print options
            println("Main menu - Please select from the following options (enter corresponding number):")
            println("1. View graph")
            println("2. Get Minimum Spanning Tree (MST)")
            println("3. Quit")

            // Get selected option and re-print menu if invalid (TODO: Proper error checking (if not int))
            println("Enter option: ")
            selectedOption = readlnOrNull()?.toInt()
            if(selectedOption !in validOptions) {
                println("Invalid option")
            }
        }

        return selectedOption
    }

}