//object NetWorthSpec {
// def runTests(): Unit ={
//   assert(NetWorth.calculate(100,20) == 80,"the result should be 80")
//   assert(NetWorth.calculate(1000,2000) == -1000,"the result should be -1000")
// }
//
//   def main(args: Array[String]): Unit = {
//    println("running tests")
//    runTests()
//    println("All tests passed")
//  }
//}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NetWorthSpec extends AnyFlatSpec with Matchers {
  "A NetWorth Calculator" should "return 500" in {
    NetWorth.calculate(1000, 500) should be (500)
  }

  "A NetWorth Calculator" should "return 5000" in {
    NetWorth.calculate(10000, 5000) should be (5000)
  }
}
