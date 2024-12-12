package main

class MainMenu {
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

            // Get selected option and re-print menu if invalid
            println("Enter option: ")
            try {
                selectedOption = readlnOrNull()?.toInt()
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a number.")
                continue
            }
            if (selectedOption !in validOptions) {
                println("Invalid option")
            }
        }

        return selectedOption
    }

}