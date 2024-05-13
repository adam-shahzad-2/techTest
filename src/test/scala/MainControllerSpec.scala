import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class MainControllerSpec extends AnyFreeSpec with Matchers {
  val test = new MainController

  "test input" -{
    "produce small test output from small input" in {
      assert(test.printNextGeneration(List((1,2),(2,2),(3,2))) contains List((2,1),(2,2),(2,3)))
    }

//    "produce large test output from large input" in {
//      assert(test.printNextGeneration(List((1000000001,1000000002),(1000000002,1000000002),(1000000003,1000000002))) == List((1000000002,1000000001),(1000000002,1000000002),(1000000002,1000000003)))
//    }
//
//    "produce combined test output from combine input" in {
//      assert(test.printNextGeneration(List((1,2),(2,2),(3,2),(1000000001,1000000002),(1000000002,1000000002),(1000000003,1000000002))) == List((2,1),(2,2),(2,3),(1000000002,1000000001),(1000000002,1000000002),(1000000002,1000000003)))
//    }
  }
}
