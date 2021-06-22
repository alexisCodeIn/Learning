package Classes

import kotlin.collections.MutableList as MutableList1

data class Movie(val title:String, val creator:String, val duration: Int)

class Song(name:String, Singer: String, duration: Double){
    val firstProperty = "First property: $name".also(::println)
}
class Customer(name: String) {
    val customerKey = name.toUpperCase().also(::println)
}
