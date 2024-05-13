import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers


class CountNeighboursSpec extends AnyFreeSpec with Matchers {
 val testLocation = Location(1,1,Alive)
 val test = new MainController

 "count neighbour function" - {
  "count zero neighbours correctly" in {
   assert(test.countNeighbours(location = testLocation, List.empty[Location]) == 0)
  }
  "count one diagonal neighbours correctly" in {
   assert(test.countNeighbours(location = testLocation, List(Location(0,0,Alive))) == 1)
  }
  "count one horizontal paralell neighbours correctly" in {
   assert(test.countNeighbours(location = testLocation, List(Location(2,1,Alive))) == 1)
  }
  "count one vertical paralell neighbours correctly" in {
   assert(test.countNeighbours(location = testLocation, List(Location(1,0,Alive))) == 1)
  }
  "count 8 neighbours correctly" in {
   assert(test.countNeighbours(location = testLocation,
    List(Location(0,0,Alive), Location(0,1,Alive), Location(0,2,Alive),
         Location(1,0,Alive), Location(1,1,Alive), Location(1,2,Alive),
         Location(2,0,Alive), Location(2,1,Alive), Location(2,2,Alive))) == 8)
  }
 }
}
