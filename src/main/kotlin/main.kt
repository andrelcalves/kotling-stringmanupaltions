

fun main(args: Array<String>) {
    //return the count of letters that needs to be removed to make an anagram
    var count =  makeAnagram("abcdef","cadxyfw")
}

fun makeAnagram( a:String,  b:String) :Int {
    var count = 0
    val map = mutableMapOf<Char,Int>()
    var first = a
    var second = b

    if (a.length < b.length) {
        first = b
        second = a
    }

    first.forEach {
        val value = map.getOrDefault(it,0)
        map.put(it, value+1)
    }
    second.forEach{
        val value = map.getOrDefault(it,0)
        map.put(it,value -1)
    }
    map.values.forEach{
        count = count+ Math.abs(it)
    }
    return count
}