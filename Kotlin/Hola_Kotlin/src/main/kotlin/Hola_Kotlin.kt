import Classes.*
import java.lang.Math.random

fun main () {
    var numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var compute: String? = null
    var longitud: Int? = compute?.length
    println(longitud)

    var teclado: String? = null
    val longitudTeclado: Int = teclado?.length ?: 0
    println(longitudTeclado)

    val listWithNulls: List<Int?> = listOf<Int?>(7, null, null, 4)
    println("Lista con Null: ${listWithNulls}")

    val listWithoutNulls: List<Int?> = listWithNulls.filterNotNull()
    println("Lista sin nulls " + listWithoutNulls)


    //ARRAYS
    val countries = arrayOf("India", "Mexico", "Colombia", "Argentina", "Chile", "Peru")
    val days = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(countries)
    println(days)

    //Promedio de los numeros
    println("Datos en numeros ${numbers.size}")
    println("Promedio de numeros ${numbers.average()}")
    println("Obtener dato de numeros ${numbers.get(5)}")
    val suma = numbers.sum()
    println(suma)
    numbers = numbers.plus(11)
    println("${numbers.asList()}")

    numbers = numbers.reversedArray()
    println("${numbers.asList()}")

    numbers.reverse()
    println("${numbers.asList()}")
    numbers.reverse()
    println("${numbers.asList()}")

    var x = 10
    var mensajito = "El valor de x es $x"
    println(mensajito)
    x++
    println("${mensajito.replace("es", "fue")}, x ahora es $x")

    println("Promedio de numeros por funcion: ${averageNumbers(numbers, 0)}")
    println(evaluate())
    println(evaluate(nombre = "Tania", ciudad = "New York", pais = "U.S.A"))

    //lambdas
    val hola = { println("hello World") }()
    hola

    val w = { a: Int, b: Int -> a + b }
    println(w(1, 2))

    println({a: Int, b: Int -> a * b}(4, 4))

    val random1 = random()
    println(random1)
    println(random1)

    val random2 = {random()}//Esto es una funcion almacenada, que no puede operarse
    /*println(random2 + 2) Aqui no se puede operar random2 */
    println(random2)
    println(random2)

    val plus = {a:Int,b:Int,c:Int -> a+b+c}
    val result = plus(3,4,5)
    println(result)

    val calculateNumber = {n:Int ->
        when(n){
            in 1..3 -> println("n Esta entre 1 y 3")
            in 4..7 -> println("n Esta entre 4 y 7")
            in 8..11 -> println("n Esta entre 8 y 11")
        }
    }
    println(calculateNumber(4))

    //camera classes
    val camera = Camera()
    println(camera.getResolution())
    println(camera.setResolution(1080))
    println(camera.getResolution())

    println(camera.getCameraStatus())
    camera.setCameraStatus(true)
    println(camera.getCameraStatus())

    println(camera.getFlashStatus())
    camera.setFlashStatus(true)
    println(camera.getFlashStatus())

    println(camera.getBrandStatus())
    camera.setBrandStatus("Nikon")
    println(camera.getBrandStatus())

    //Shoe Classes
    val shoe = Shoe("Yezzy","Pretty shoe", 12345,"Nike")//class
    println("\nShoe---------------------")
    shoe.model = "Tennis"
    println(shoe.model)
    shoe.model = "Sports "
    println(shoe.model)
    println("\nShoe class: $shoe")
    shoe.create()

    //movie classes
    val movie = Movie("El padrino", "Mario Puzo", 200)
    println("\nMovie-----------------------")
    println(movie.title)
    println(movie.creator)
    println(movie.duration)

    //song classes
    val song = Song("Beautiful People","Marylin Manson", 3.34)

    //Superior Functions
    var resultCalculator: Int = 0

    fun calculator(a:Int,b:Int,c:Int, operation:(Int,Int,Int) -> Int): Int{
        return operation(a,b,c)
    }

    fun plus(a:Int, b:Int, c:Int)= a+b+c
    fun subtract(a:Int, b:Int, c:Int)= a-b-c
    fun multiply(a:Int, b:Int, c:Int)= a*b*c

    println(calculator(2,3,4,::subtract))
}

fun evaluate(nombre: String = "Reinaldo", ciudad: String = "Roma", pais: String = "Italia"): String {
    return """Mi nombre es $nombre, vivo en $ciudad, ciudad de $pais. """
}

fun averageNumbers(numbers: IntArray, n: Int): Double {
    return (numbers.average()) + n
}
