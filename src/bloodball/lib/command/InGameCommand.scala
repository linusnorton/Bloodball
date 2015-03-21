package bloodball.lib.command

import bloodball.lib.game.Board

import scala.util.Try

trait InGameCommand {

  def apply(board: Board, command: String): Try[Unit]

}