package model

import java.lang.Double
import java.lang.NumberFormatException

interface IUsefulFunctions {

    fun showOptions(options: ArrayList<String>){
        for ((i) in options.withIndex()) {
            println("${i + 1}. " + options[i])
        }
    }

    fun numberOrNot(response: String): Boolean {
        var numeric = true
        try {
            Double.parseDouble(response)
        } catch (e: NumberFormatException){
            numeric = false
        }

        return numeric
    }
}
