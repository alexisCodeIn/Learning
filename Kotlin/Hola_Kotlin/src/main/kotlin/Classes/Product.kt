package Classes

abstract class Product (open var name: String, open var description: String, open var sku: Int){

    override fun toString(): String {
        return "\nName: $name\nDescription: $description\nSku: $sku"
    }

    abstract fun create(): String

    abstract fun read(): String

    abstract fun update(): String

    abstract fun delete(): String
}