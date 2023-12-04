import Patrol.PatrolShip

fun healthPatrol (shipHP: Double, shipHP2: Double, shipHP3: Double): String{
    var patrolHP = (shipHP + shipHP2 + shipHP3)
    return "Galactic Patrol has a total HP of: $patrolHP"

}

fun armorBubble(patrolHP: Double){
    if (patrolHP < 1000){
        val extraArmor = +0.10
        println("[-10% enemy Damage]")
    }
}

fun shipStats(patrols: MutableList<PatrolShip>) {
    for (ship in patrols) {
        println("Ship: [${ship.name}], HP: [${ship.health}], Atack: [${ship.attack}], Armor: [${ship.armor}], Level: [${ship.level}]")
    }
}