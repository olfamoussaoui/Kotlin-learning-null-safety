import java.lang.IllegalArgumentException

fun main() {

    //Explore : Working with null
    //Regular initialization means non-null by default
    var a: String = "abc" // a cannot be null because we initialized the variable

    // How to allow null then ? => by using this ?
    var cin: String? = "0213658" //That allow the using of null
    cin = null

    var inferredNonNull = "The compiler assumes non-null";
    // inferredNonNull = null => compilation error

    fun strLength(notNull: String): Int {                   // 7
        return notNull.length
    }
    println("length of a = ${strLength(a)}")
    // println("length of cin = ${strLength(cin)}") => Compilation error

    //Explore : checking for null in a condition
    var x = 12;
    var y = null
    val l =  if (y != null) y else x
    println("l = $l")

    val b: String? = "Kotlin"

    if (b != null && b.isNotEmpty())
        println("String of length ${b.length}")
    else
        println("Empty string")

    //Explore : Safe calls
    val n = "kotlin"
    val m: String? = null
    println("length of n = ${n.length}")
    println(m?.length)

    //Note: To perform a certain operation only for non-null values,
    // you can use the safe call operator together with let
    println("#### Work with let operator ####")
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // prints Kotlin and ignores null
    }

    // If either `person` or `person.department` is null, the function is not called:
    var person = Person("Olfa", null)
    person?.department?.head = "Bringa"

    println(person.department)

    //Explore: Elvis operator
    val v: String? = null
    val p = b?.length ?: -1
    println("foo: ${foo(person)}")

    //Explore: Collections of a nullable type
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull();
    println("intList = $intList")

}

data class Person(val name: String, val department: Department?)

data class Department(var head: String)

fun foo(person: Person): String? {
    val name = person.name ?: return null
    // val department = person.department ?: throw IllegalArgumentException("department expected")
    return "Pas de problème"
}