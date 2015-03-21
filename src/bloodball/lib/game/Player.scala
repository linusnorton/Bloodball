package bloodball.lib.game

case class Player(number: Int, xPos: Int, yPos: Int) extends Piece(xPos, yPos) {
  var team: Team = _ //sigh
  var hasMoved = false
} 