package main

import java.io.File
import java.io.FileNotFoundException

class FileHandler(private val file: String, private val backupFile: String) {
    fun readFile(): MutableList<Triple<String, String, Int>> {
        // data structure for lines in the file
        val data = mutableListOf<Triple<String, String, Int>>()

        // read the file
        try {
            File(file).forEachLine {
                // split the line by spaces
                val line = it.split(", ")

                // add the line to the data structure
                data.add(Triple(line[0], line[1], line[2].toInt()))
            }
        }
        catch (e: FileNotFoundException) {
            println("File not found, using backup file")
            File(backupFile).forEachLine {
                // split the line by spaces
                val line = it.split(", ")

                // add the line to the data structure
                data.add(Triple(line[0], line[1], line[2].toInt()))
            }
        }

        return data
    }
}