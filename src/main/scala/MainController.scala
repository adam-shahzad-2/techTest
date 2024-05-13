sealed abstract class DeadOrAlive
object Dead extends DeadOrAlive
object Alive extends DeadOrAlive

case class Location(xValue: Int, yValue: Int, deadOrAlive: DeadOrAlive)

class MainController {

  def printNextGeneration(input: List[(Int,Int)]): List[(Int,Int)] = {
    val whatHappensToAliveCells: List[Location] = inputToListOfLiveLocations(input).filter{
      location => willBeAlive(countNeighbours(location, inputToListOfLiveLocations(input)), Alive) == Alive
    }

    var whatHappensToDeadCells: List[Location] = List.empty[Location]
    for (x <- 0 to input.map(f => f._1).max +1) {
      for (y <- 0 to input.map(f => f._2).max +1) {
        if (willBeAlive(countNeighbours(Location(x, y, Dead), inputToListOfLiveLocations(input)), Dead) == Alive)
          whatHappensToDeadCells = whatHappensToDeadCells :+ Location(x,y, Alive)
      }
    }
    println(whatHappensToDeadCells)
    println(whatHappensToAliveCells)

    (whatHappensToAliveCells :++ whatHappensToDeadCells).map(cells => (cells.xValue, cells.yValue))
  }

  def inputToListOfLiveLocations(input: List[(Int,Int)]): List[Location] = {
    input.map(coordinate => Location(coordinate._1, coordinate._2, Alive))
  }

  def countNeighbours(location: Location, listOfAliveLocations: List[Location]): Int = {
    var neighbours: Int = 0
    if (listOfAliveLocations.contains(Location(location.xValue, location.yValue +1, Alive)))
    {neighbours = neighbours + 1}
    if (listOfAliveLocations.contains(Location(location.xValue, location.yValue -1, Alive)))
    {neighbours = neighbours + 1}

    for (i <- 0 to 2){
      if (listOfAliveLocations.contains(Location(location.xValue - 1, (location.yValue -1 +i), Alive)))
      {neighbours = neighbours + 1
      }
    }

    for (i <- 0 to 2) {
      if (listOfAliveLocations.contains(Location(location.xValue + 1, (location.yValue - 1 + i), Alive))) {
        neighbours = neighbours + 1
      }
    }
    neighbours
  }

  def willBeAlive(numberOfNeighbours: Int, alreadyAlive: DeadOrAlive): DeadOrAlive = {
    if (alreadyAlive == Alive) {
      if (numberOfNeighbours < 2 || numberOfNeighbours > 3) Dead else Alive
    } else {
      if (numberOfNeighbours == 3) Alive else Dead
    }
  }
}
