package bloodball.app.cli

import bloodball.lib.game._
import scala.annotation.tailrec


object Draw {

  implicit def Player2String(p: Player): String = {
    // surely this function could be better
    val bold = if (!p.hasMoved) Console.BOLD else ""

    bold + p.team.colour + f"${p.number}%02d" + Console.RESET 
  }  
  
  def apply(board: Board) = {  

    @tailrec def rows(out: String, x: Int, y: Int): String = (x, y) match {
      case (x, y) if y == board.height => out
      case (x, y) if x < board.width => rows(out + getChar(x, y), x + 1, y) 
      case (x, y) if x == board.width && y < board.height => rows(out + "\n", 0, y + 1)
    }

    def getChar(x: Int, y: Int): String = board.cells(y)(x) match {
      case Some(p: Player) => p
      case Some(b: Ball) => Console.WHITE + "()" + Console.RESET
      case Some(p: Piece) => "??"
      case None => "--"
    }

    // maybe this recursion could be a reduce instead?
    println(rows("", 0, 0))
  }

  
}