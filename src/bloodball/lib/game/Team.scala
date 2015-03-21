package bloodball.lib.game

case class Team(colour: String, players: Player*) {
  players.foreach(_.team = this)

  def findPlayer(number: Int) = {
    players.find(_.number == number)
  }
}