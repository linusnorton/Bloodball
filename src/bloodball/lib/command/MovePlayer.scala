package bloodball.lib.command

import bloodball.lib.game._
import scala.util.Try

object MovePlayer extends InGameCommand {

  def apply(board: Board, command: String) = Try {
    val Array(playerIndex, x, y) = command.split(" ").drop(1).map(_.toInt)
    
    board.currentTeam.findPlayer(playerIndex) match {
      case Some(p) => movePlayer(board, p, x, y)
      case None => throw new IndexOutOfBoundsException("Could not find player " + playerIndex)
    }    
  }

  def movePlayer(board: Board, player: Player, x: Int, y: Int) = {
    if (player.hasMoved) throw new RuntimeException("Player " + f"${player.number}%02d" + " has already moved")

    board.move(player, x, y)
    player.hasMoved = true
  }
}
