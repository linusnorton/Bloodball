package bloodball.lib.command

import bloodball.lib.game.Board
import bloodball.lib.command._

import scala.util.Success
import scala.util.Failure

object DispatchCommand {
  
  // why didn't creating a type here work
  def commands = Map[String, InGameCommand](
    "move" -> MovePlayer,
    "end" -> EndTurn
  )

  def apply(board: Board, command: String) = commands.get(command.split(" ").head) match {
    case Some(c: InGameCommand) => c(board, command)
    case None => Failure(new RuntimeException("Command: " + command + " not recognised"))
  }

}