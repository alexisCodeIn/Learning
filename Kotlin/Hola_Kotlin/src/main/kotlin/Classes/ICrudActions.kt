package Classes

interface ICrudActions {
    fun create(): String

    fun read(): String

    fun update(): String

    fun delete(): String

    fun saludar(message:String){
        println(message)
    }


}