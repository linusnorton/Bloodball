package bloodball.lib.game

case class Board(width: Int, height: Int, teamA: Team, teamB: Team, ball: Ball) {

  var cells: Grid = List.fill(height)(List.fill(width)(None))
  var currentTeam = teamA

  teamA.players.foreach(place)  
  teamB.players.foreach(place)  
  teamB.players.foreach(_.hasMoved = true)  
  place(ball)

  def place(p: Piece) = {
    val row = cells(p.y).updated(p.x, Some(p))

    cells = cells.updated(p.y, row)
  }   

  def remove(x: Int, y: Int) = {
    val row = cells(y).updated(x, None)

    cells = cells.updated(y, row)
  }   

  def move(p: Piece, x: Int, y: Int) = {
    if (cells(y)(x) != None) throw new RuntimeException("Cannot move to an occupied spot")

    remove(p.x, p.y)
    p.x = x
    p.y = y
    place(p)
  }
}
