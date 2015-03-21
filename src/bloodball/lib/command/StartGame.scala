package bloodball.lib.command

import bloodball.lib.game._

object StartGame {

  def apply() = {
    Board(
      50, 
      30, 
      Team(
        Console.BLUE,
        Player(1, 4, 4), 
        Player(2, 4, 1)
      ), 
      Team(
        Console.RED,
        Player(1, 4, 20), 
        Player(2, 4, 21)
      ),
      Ball(10, 10)
    )
  }
  
}