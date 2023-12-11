import Patrol.PatrolShip

class Items(
    name: String,
    armor: Double,
    health: Double,
    coins: Int
) : PatrolShip(name, health, 0.0, true, false, false, 0, armor) {
    // Hier kommt der zusätzliche Code für die Items-Klasse
    var coins = coins
}