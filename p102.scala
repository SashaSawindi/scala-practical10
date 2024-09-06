class Fraction(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  
  private val g = gcd(n.abs, d.abs) // Simplifying the fraction by GCD
  val numer: Int = n / g
  val denom: Int = d / g

  // Method to negate the fraction
  def neg: Fraction = new Fraction(-this.numer, this.denom)

  // Method to subtract two fractions
  def sub(that: Fraction): Fraction = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Fraction(newNumer, newDenom)
  }

  // Helper method to compute GCD
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numer/$denom"
}

object Fraction_sub extends App {
  val x = new Fraction(3, 4) // 3/4
  val y = new Fraction(5, 8) // 5/8
  val z = new Fraction(2, 7) // 2/7

  val result = y.sub(z) // y - z
  println(s"y - z = $result") // Output y - z
}
