object NetWorthMultiCurrency {


  def calculate(assets: Double, liabilities: Double): Double = assets - liabilities

  def main(args: Array[String]): Unit = {
    val assets = args(0) // example: "100000 EUR,9000 USD"
    val liabilities = args(1) // example: "59100 EUR,12200 USD"

    val assetsInEuros = assets.split(",").map(Currency(_))
    val liabilitiesInEuros = liabilities.split(",").map(Currency(_))

    val totalAssetsInEuros = assetsInEuros.map(_.valueInEuros).sum
    val totalLiabilitiesInEuros = liabilitiesInEuros.map(_.valueInEuros).sum


    println(s"Your net worth is ${calculate(totalAssetsInEuros, totalLiabilitiesInEuros)}")
  }

  object Currency {
    val currencyConverter: Map[String, Double] = Forex.getExchangeRates()

    /**
     * This method return Currency object
     * @param value: example: "1000 USD"
     **/
    def apply(value: String): Currency = {
      val Array(amountString: String, currencyCode: String) = value.split("\\s")
      val amount: Long = amountString.toLong

      if (currencyCode != "EUR") {
        val multiplier: Double = 1 / currencyConverter(currencyCode)

        println(s"$currencyCode -> EUR : $multiplier")

        Currency(amount, currencyCode, amount * multiplier)
      }

      Currency(amount, currencyCode, amount)
    }
  }
  /**
   *
   * @param amount: example 100
   * @param code: example USD
   * @param valueInEuros: example 98.23
   */
  case class Currency(amount: Long, code: String, valueInEuros: Double)
}


