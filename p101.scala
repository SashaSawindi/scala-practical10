class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  
  private val g = gcd(n.abs, d.abs) // Simplifying the fraction by GCD
  val numer: Int = n / g
  val denom: Int = d / g

  // Method to negate the rational number
  def neg: Rational = new Rational(-this.numer, this.denom)

  // Helper method to compute GCD
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numer/$denom"
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(x.neg) // Output: -3/4
}
