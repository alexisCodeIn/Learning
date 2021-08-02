package model

open class MenuPrincipal:IUsefulFunctions{
    fun menuPrincipal() {
        val startMessage = "\nWelcome to Recipes Maker\n"
        val options =
            ("Press enter and write the number of the option you want\n1. Make a recipe\n2. See my recipes\n3. Exit")
        println(startMessage)
        println(options)
        menuPrincipalSelectOption()
    }

    private fun menuPrincipalSelectOption(){
        val response = readLine()!!
        if (numberOrNot(response)) {
            when (response.toInt()) {
                1 -> {
                    println("Make a recipe\nSelect one category\n")
                    IngredientsInventory().makeRecipeShowOptions()
                }
                2 -> {
                    println("See my recipes")
                    ViewRecipe().viewRecipe()
                }
                3 -> {
                    println("Exit")
                }
                else -> {
                    print("Option not available. Try Again\n")
                    menuPrincipalSelectOption()
                }
            }
        }else{
            println("Not a number, please only write the available options (1 to 3) or 0 to go back")
            menuPrincipalSelectOption()
        }
    }
}