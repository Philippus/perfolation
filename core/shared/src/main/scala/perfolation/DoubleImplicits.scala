package perfolation

import perfolation.numeric.{Grouping, NumericFormatter, RoundingMode}

class DoubleImplicits(val d: Double) extends AnyVal {
  /**
    * Format a numeric value
    *
    * @param i minimum integer digits (defaults to 1, -1 defines no minimum)
    * @param f minimum fraction digits (defaults to 2, -1 defines no minimum)
    * @param maxI maximum integer digits (defaults to -1 for no maximum)
    * @param maxF maximum fraction digits (defaults to -1 to set the max the same as the minimum)
    * @param g grouping mode (defaults to Grouping.None)
    * @param rm rounding mode for maximum fraction digits (defaults to RoundingMode.HalfUp)
    * @return formatted String for the numeric value
    */
  def f(i: Int = 1,
        f: Int = 2,
        maxI: Int = -1,
        maxF: Int = -1,
        g: Grouping = Grouping.None,
        rm: RoundingMode = RoundingMode.HalfUp): String = {
    NumericFormatter.format(
      value = d,
      minimumIntegerDigits = i,
      maximumIntegerDigits = maxI,
      minimumFractionDigits = f,
      maximumFractionDigits = if (maxF == -1) f else maxF,
      grouping = g,
      roundingMode = rm
    )
  }
}
