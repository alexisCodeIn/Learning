package model

import myRecipes
import java.util.ArrayList

class ViewRecipe: IUsefulFunctions {

    fun viewRecipe() {
        fun exit () {
            val response = readLine()!!
            if (numberOrNot(response)) {
                if (response == "0") {
                    MenuPrincipal().menuPrincipal()
                }else println("Option not available. Try Again")
            }else println("Option not available. Try Again")
            exit()
        }
        myRecipes.ifEmpty {
            println("\nEmpty")
        }
        if (myRecipes.any()) {
            println(myRecipes)
        }
        println("\nPress 0 to go back")
        exit()
    }

}