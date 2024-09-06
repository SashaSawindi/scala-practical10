object LetterCount {

  def countLetterOccurrences(words: List[String]): Int = {
    // Step 1: Use map to get the lengths of each word (number of letters)
    val lengths = words.map(word => word.length)

    // Step 2: Use reduce to sum up the lengths
    val totalLetters = lengths.reduce(_ + _)

    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $total")
  }
}
