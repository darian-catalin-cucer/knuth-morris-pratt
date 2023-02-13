fun KMPSearch(text: String, pattern: String): Int {
    val n = text.length
    val m = pattern.length
    val lps = IntArray(m)
    var j = 0
    var i = 0
    computeLPSArray(pattern, m, lps)

    while (i < n) {
        if (pattern[j] == text[i]) {
            i++
            j++
        }
        if (j == m) {
            return i - j
            j = lps[j - 1]
        } else if (i < n && pattern[j] != text[i]) {
            if (j != 0) {
                j = lps[j - 1]
            } else {
                i++
            }
        }
    }
    return -1
}

fun computeLPSArray(pattern: String, m: Int, lps: IntArray) {
    var len = 0
    var i = 1
    lps[0] = 0
    while (i < m) {
        if (pattern[i] == pattern[len]) {
            len++
            lps[i] = len
            i++
        } else {
            if (len != 0) {
                len = lps[len - 1]
            } else {
                lps[i] = len
                i++
            }
        }
    }
}
