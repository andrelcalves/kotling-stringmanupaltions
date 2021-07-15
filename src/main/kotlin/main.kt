

fun main(args: Array<String>) {
    //return the count of letters that needs to be removed to make an anagram
    var countAnagram   =  makeAnagram("abcdef","cadxyfw")
    //return the count of letters that needs to be removed that there ane not matching adjaceting
    var countAlterning =  alernatingCharacters("AABAAB")
    //
    var stringRemoved = superReducedString("aa")
}

//return the count of letters that needs to be removed to make an anagram
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
//return the count of letters that needs to be removed that there ane not matching adjaceting
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

fun superReducedString(s:String):String{
    var value = '0'
    var index = 0

    var string = ""
    string = s
    if(string.isEmpty()) return "Empty String"

    string.forEach {
        if (value == it) { // using return to avoid tail recusion
            return superReducedString(s.removeRange(index - 1, index + 1))
        }
        value = it
        index++
    }
    return string
}