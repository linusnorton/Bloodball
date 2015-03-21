package bloodball.lib.command

import bloodball.lib.game.Board

import scala.util.Try

object EndTurn extends InGameCommand {

  def apply(board: Board, command: String) = Try {
    board.currentTeam = if (board.currentTeam == board.teamA) board.teamB else board.teamA
    board.currentTeam.players.foreach(_.hasMoved = false)
  }
}