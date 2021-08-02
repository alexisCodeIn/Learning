package Classes
//protect data
class Shoe(override var name: String, override var description: String, override var sku:Int, var brand: String): Product(name,description, sku), ICrudActions {

    override fun toString(): String {
        return super.toString() + "\nbrand: $brand\nsize: $size\ncolor: $color\nmodel: $model"
    }

    override fun create(): String{
        saludar("Hello from Create")
        return "Create shoe"
    }

    override fun read(): String {
        return "Read shoe"
    }

    override fun update(): String {
        return "Update shoe"
    }

    override fun delete(): String {
        return "Delete Shoe"
    }

    init {
     println("Sku Id: $sku")
     println("Marca: $brand")
    }
    var size: Int = 34 //Minim 34
        set(value) {
            if (value >= 34) {
                field = value
            } else println("Not valid number")
        }

    fun shoeSize(newSize: Int){
        size = newSize
    }

    var color: String = "White"

    var model: String = "Boots" //Not assign Tennis
        set(value) {
            if (value == "Tennis") {
                println("Tennis is not possible to Assign")
            } else field = value
        }
}