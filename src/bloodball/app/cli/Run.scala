package bloodball.app.cli

import bloodball.lib.command._

import io.Source.stdin
import scala.util.Failure
import scala.util.Success

object Run extends App {
  val game = StartGame()

  def run(): Unit = {
    Draw(game)
    print("> ")    
    
    for (input <- stdin.getLines) 
      if (input == "x") return else loop(input)
  }

  def loop(input: String) = {
    DispatchCommand(game, input) match {
      case Success(_) => Draw(game)
      case Failure(e) => println(e)
    }
    
    print("> ")    
  }

  run()
}