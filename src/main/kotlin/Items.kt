import Patrol.PatrolShip


open class Items(
    name: String,
    armor: Double,
    health: Double,
    val coinsPrice: Int
) : PatrolShip(name, health, 0.0, true, false, false, 0, armor, false) {

    fun buyItem() {
        if (coins >= coinsPrice) {
            coins -= coinsPrice
            itemList.add(this)
            println("You bought $name!")
        } else {
            println("Not enough coins to buy $name.")
        }
    }

    fun useItem(item: Items, ship: PatrolShip) {
        ship.health += item.health
        ship.attack += item.attack
        ship.armor += item.armor
        println("<-${ship.name} used [${item.name}]")
    }
}
