package model

import myRecipes
import javax.swing.text.View

class IngredientsInventory(): IUsefulFunctions{

    val categories = arrayListOf("Waters", "Milks", "Meets", "Vegetables", "Fruits", "Cereal", "Eggs","Oil")

    val watersInventory = arrayListOf("Purified","Mineralized","Tonic","Glacier","Mountain Spring","Alkaline","Diuretic")
    val milksInventory = arrayListOf("Whole milk","Skim or skim milk", "Semi-skimmed milk", "Soy milk", "Almond milk", "Rice milk", "Organic milk", "Lactose free milk")
    val meetsInventory = arrayListOf("Cow","Veal","Pork","Sheep","Mutton","Chicken","Blue Fish","White fish")
    val vegetablesInventory = arrayListOf("Broccoli","Carrot","Cabbages","Spinach","Tomatoes","Zucchini","Onion","Peppers","Eggplant")
    val fruitsInventory = arrayListOf("Oranges","Blueberries","Bananas","Apples","Grapes","Kiwis","Raspberries","Cherries","Avocado")
    val cerealInventory = arrayListOf("OATS","TEFF","FLAKES","CORN","TEFF FLAKES","KASHA","WHEAT","SPELLET","BULGUR","SALTED OATS","BARLEY","TEFF","QUINOA","WHEATARRACENE","RYE","AMARANTH")
    val eggsInventory = arrayListOf("Hen", "Duck", "Quail","Ganzo","Turkey","Ostrich","Dinosaur")
    val oilsInventory = arrayListOf("Cotton","Corn","Peanut","Soybean","Safflower","Sunflower","Canola","Sesame")

    var categoryIngredients: ArrayList<String> = arrayListOf("empty")

    fun makeRecipeShowOptions() {
        showOptions(categories)
        println("\nPress 0 to go back")
        selectOptionMakeRecipe()
    }

    fun selectOptionMakeRecipe(){
        val response = readLine()!!
        if (numberOrNot(response)) {
            when (val optionSelected: Int = response.toInt()) {
                in 1..categories.size -> {
                    val objectInArray = optionSelected.minus(1)
                    showOptions(listIngredients(objectInArray))
                    fun selectListIngOption() {
                        val response = readLine()!!
                        if (numberOrNot(response)) {
                            when (val optionSelected: Int = response.toInt()) {
                                in 1..categoryIngredients.size -> {
                                    val objectInArray = optionSelected.minus(1)
                                    println(categoryIngredients[objectInArray])
                                    myRecipes.add(categoryIngredients[objectInArray])
                                    println("Saved, You can add more if you want\nPress 0 to go back")
                                    selectListIngOption()
                                }
                                0 -> {
                                    makeRecipeShowOptions()
                                }
                                else -> {
                                    println("Option not available. Try Again")
                                    selectListIngOption()
                                }
                            }
                        }else{
                            println("Not a number, please only write the available options (1 to ${listIngredients(objectInArray).size}) or 0 to go back")
                            selectListIngOption()
                        }
                    }
                    selectListIngOption()
                }
                0 -> {
                    MenuPrincipal().menuPrincipal()
                }
                else -> {
                    println("Option not available. Try Again")
                    MenuPrincipal().menuPrincipal()
                }
            }
        } else{
            println("Not a number, please only write the available options (1 to ${categories.size}) or 0 to go back")
            selectOptionMakeRecipe()
        }
    }

    fun listIngredients (selected: Int): ArrayList<String>{
        when (selected) {
            0 -> {
                categoryIngredients = watersInventory
            }
            1 -> {
                categoryIngredients = milksInventory
            }
            2 -> {
                categoryIngredients = meetsInventory
            }
            3 -> {
                categoryIngredients = vegetablesInventory
            }
            4 -> {
                categoryIngredients = fruitsInventory
            }
            5 -> {
                categoryIngredients = cerealInventory
            }
            6 -> {
                categoryIngredients = eggsInventory
            }
            7 -> {
                categoryIngredients = oilsInventory
            }
        }
        return categoryIngredients
    }
}

