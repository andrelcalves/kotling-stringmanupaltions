

fun main(args: Array<String>) {
    //return the count of letters that needs to be removed to make an anagram
    var countAnagram   =  makeAnagram("abcdef","cadxyfw")
    //return the count of letters that needs to be removed that there ane not matching adjaceting
    var countAlterning =  alernatingCharacters("AABAAB")
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

fun alernatingCharacters(s:String):Int{

    var value = '0'
    var removed = 0

    for(c in s){
        if (c !in 'A'..'B')
           return 0
    }

    s.forEach {
        if (value == it) removed++
        value = it
    }
    return removed
}