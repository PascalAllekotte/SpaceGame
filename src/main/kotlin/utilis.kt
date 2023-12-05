import Patrol.PatrolShip

fun healthPatrol (shipHP: Double, shipHP2: Double, shipHP3: Double): String{
    var patrolHP = (shipHP + shipHP2 + shipHP3)
    return "Galactic Patrol has a total HP of: $patrolHP"

}
fun totalHP(shipHP: Double, shipHP2: Double, shipHP3: Double): Double {

    var patrolHP = shipHP + shipHP2 + shipHP3
    return patrolHP
}


fun armorBubble(patrolHP: Double){
    if (patrolHP < 1000){
        val extraArmor = +0.10
        println("[-10% enemy Damage]")
    }
}

fun shipStats(patrols: MutableList<PatrolShip>) {
    println("__________Stats of your ships:__________")
    for (ship in patrols) {
        println("Ship: [${ship.name}], HP: [${ship.health}], Atack: [${ship.attack}], Armor: [${ship.armor}], Level: [${ship.level}]")
    }
}



fun bag(liste: MutableList<Items>) {
    println("__________Items in your storage:__________")

    if (liste.isEmpty()) {
        println("No item in storage.")
    } else {
        for (item in liste) {
            println("Item: [${item}], Power: [${item}]")
        }
    }
}

fun attackAllShips(patrolShip: MutableList<PatrolShip>, damage: Double){
    println("\n Darth Rader attack Galactic Patrol.. Damage: [$damage]")
    for (ship in patrolShip){
        ship.health -= damage
    }
    println("\n  After attack")
}

fun nextStep (){
    println("Plan your next Step:")
    println("Choose ship [1] [2] [3]: ")



}

/*
    println("Attack [1]")
    println("Use Item [1]")
    println("Repair Ship [1]")
 */