fun main(args: Array<String>) {
    //return the count of letters that needs to be removed to make an anagram
    println(makeAnagram("abcdef", "cadxyfw"))
    //return the count of letters that needs to be removed that there ane not matching adjaceting
    println(alernatingCharacters("AABAAB"))
    //
    println(superReducedString("aa"))
    println(camelCase("saveChangesInTheEditor"))
    println(caesarCipher("There's-a-starman-waiting-in-the-sky", 3))
}

//return the count of letters that needs to be removed to make an anagram
fun makeAnagram(a: String, b: String): Int {
    var count = 0
    val map = mutableMapOf<Char, Int>()
    var first = a
    var second = b

    if (a.length < b.length) {
        first = b
        second = a
    }

    first.forEach {
        val value = map.getOrDefault(it, 0)
        map.put(it, value + 1)
    }
    second.forEach {
        val value = map.getOrDefault(it, 0)
        map.put(it, value - 1)
    }
    map.values.forEach {
        count = count + Math.abs(it)
    }
    return count
}

//return the count of letters that needs to be removed that there ane not matching adjaceting
fun alernatingCharacters(s: String): Int {

    var value = '0'
    var removed = 0

    for (c in s) {
        if (c !in 'A'..'B')
            return 0
    }

    s.forEach {
        if (value == it) removed++
        value = it
    }
    return removed
}

fun superReducedString(s: String): String {
    // Write your code here
    var value = '0'
    var index = 0

    if (s.isEmpty()) return "Empty String"

    s.forEach {
        if (value == it) { // using return to avoid tail recusion
            return superReducedString(s.removeRange(index - 1, index + 1))
        }
        value = it
        index++
    }

    return s
}

fun camelCase(s: String): Int {
    var letterCount = 0
    val list = mutableListOf<String>()
    var indice = 0

    s.forEachIndexed { i, c ->
        var f = (i == s.length - 1)
        if ((c.isUpperCase()) or f) {
            letterCount++
            list.add(s.substring(indice, i + (if (f) 1 else 0)))
            indice = i
        }
    }
    return letterCount
}

/*
   Caesar shift, is one of the simplest and most widely known encryption techniques.
   t is a type of substitution cipher in which each letter in the plaintext is replaced by a letter
   some fixed number of positions down the alphabet. For example, with a left shift of 3,
   D would be replaced by A, E would become B, and so on.
 */
@OptIn(ExperimentalStdlibApi::class)
fun caesarCipher(s: String, k: Int): String {
    val letterArray = arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    var newStringPwd = ""

    s.forEach {
        if (it.isLetter()) {
            letterArray.forEachIndexed { i, c ->
                if (c.equals(it.uppercase())) {
                    var letterArrayIndice = i + k
                    if ((i + k) >= letterArray.size) {
                        letterArrayIndice = Math.abs(letterArray.size - i - k)
                    }
                    newStringPwd += (if (it.isUpperCase()) letterArray.get(letterArrayIndice)
                        .toString() else letterArray.get(letterArrayIndice).toString()
                        .lowercase())
                    return@forEach
                }
            }
        } else {
            newStringPwd += it
        }
    }
    return newStringPwd
}
