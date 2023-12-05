import Patrol.PatrolShip
import kotlinx.coroutines.delay

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
        val nameColor = "\u001B[97m${ship.name}\u001B[0m"
        val healthColor = "\u001B[31m${ship.health}\u001B[0m"
        val attackColor = "\u001B[34m${ship.attack}\u001B[0m"
        val armorColor = "\u001B[33m${ship.armor}\u001B[0m"
        val levelColor = "\u001B[32m${ship.level}\u001B[0m"
        val defenseColor = "\u001B[38;5;220m${ship.defense}\u001B[0m" // Ship Name in gelblich-goldener Farbe

        println("Ship: [${nameColor}], HP: [$healthColor], Attack: [$attackColor], Armor: [$armorColor], Level: [$levelColor], Modus: [$defenseColor]")
    }
}



fun bag(liste: MutableList<Items>) {
    println("__________Items in your storage:__________")

    if (liste.isEmpty()) {
        println("|           No item in storage.          |")
    } else {
        for (item in liste) {
            println("Item: [${item}], Power: [${item}]")
        }
    }
    println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
}

fun attackAllShips(patrolShip: MutableList<PatrolShip>, damage: Double){
    println("\n Darth Rader attack Galactic Patrol.. Damage: [$damage]")
    for (ship in patrolShip){
        ship.health -= damage
    }
    println("\n  After attack")
}

fun nextStep (ship: MutableList<PatrolShip>){
    print("---Plan your next Step---\nChoose ship Ship[1] Ship[2] Ship[3] Continue [4]: ")
    var menu1 = readln().toInt() // Nur Zahlen
    println("                                                 ¯¯¯")
    when (menu1) {
        1 -> {
            println("Your choosed ship $menu1: \n " +
                    "Ship: [${ship[menu1-1].name}], HP: [${ship[menu1-1].health}], Atack: [${ship[menu1-1].attack}], Armor: [${ship[menu1-1].armor}], Level: [${ship[menu1-1].level}]")
            var defenseMode = ship[menu1-1].defense
            val defenseModeStatus = if (defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"
            val attackModeStatus = if (!defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"


            print("Actions:\n  Use Item[1]\n  DefensiveMode[2] $defenseModeStatus\n  AttackMode[3]    $attackModeStatus\n  Back[4]\nChoose: ")
            var menu2 = readln().toInt() // Nur Zahlen
            when (menu2){
                1 -> {
                }
                2 -> {
                    Thread.sleep(600)
                    println("Defensive Mode activated.")
                    Thread.sleep(600)
                    println("Attackmode deactivated.")
                    Thread.sleep(2000)

                    nextStep(patrols)
                }
                3 -> {
                    println("Attackmode deactivated.\nDefensive Mode activated")
                    nextStep(patrols)
                }
                4 -> {
                    nextStep(patrols)
                }
            }

        }
        2 -> {
            println("Your choosed ship $menu1: \n " +
                    "Ship: [${ship[menu1-1].name}], HP: [${ship[menu1-1].health}], Atack: [${ship[menu1-1].attack}], Armor: [${ship[menu1-1].armor}], Level: [${ship[menu1-1].level}]")
            var defenseMode = ship[menu1-1].defense
            val defenseModeStatus = if (defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"
            val attackModeStatus = if (!defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"


            print("Actions:\n  Use Item[1]\n  DefensiveMode[2] $defenseModeStatus\n  AttackMode[3]    $attackModeStatus\n  Back[4]\nChoose: ")
            var menu2 = readln().toInt() // Nur Zahlen
            when (menu2){
                1 -> {
                }
                2 -> {
                    Thread.sleep(600)
                    println("Defensive Mode activated.")
                    Thread.sleep(600)
                    println("Attackmode deactivated.")
                    Thread.sleep(2000)

                    nextStep(patrols)
                }
                3 -> {
                    Thread.sleep(600)
                    println("Attackmode activated.")
                    Thread.sleep(600)
                    println("Defensive deactivated.")
                    Thread.sleep(2000)
                }
                4 -> {
                    nextStep(patrols)
                }
            }
        }
        3 -> {
            println("Your choosed ship $menu1: \n " +
                    "Ship: [${ship[menu1-1].name}], HP: [${ship[menu1-1].health}], Atack: [${ship[menu1-1].attack}], Armor: [${ship[menu1-1].armor}], Level: [${ship[menu1-1].level}]")
            var defenseMode = ship[menu1-1].defense
            val defenseModeStatus = if (defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"
            val attackModeStatus = if (!defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"


            print("Actions:\n  Use Item[1]\n  DefensiveMode[2] $defenseModeStatus\n  AttackMode[3]    $attackModeStatus\n  Back[4]\nChoose: ")
            var menu2 = readln().toInt() // Nur Zahlen
            when (menu2){
                1 -> {
                }
                2 -> {
                    Thread.sleep(600)
                    println("Defensive Mode activated.")
                    Thread.sleep(600)
                    println("Attackmode deactivated.")
                    Thread.sleep(2000)

                    nextStep(patrols)
                }
                3 -> {
                    println("Attackmode deactivated.\nDefensive Mode activated")
                    nextStep(patrols)
                }
                4 -> {
                    nextStep(patrols)
                }
            }
        }
        4 -> {"\n"}

    }
}

fun move2(){
    Thread.sleep(1000)
    println("Attacking Enemy...")
    Thread.sleep(1000)
    println("Attacking Enemy......")
    Thread.sleep(1000)
    println("Attacking Enemy.........")



}


/*
    println("Attack [1]")
    println("Use Item [1]")
    println("Repair Ship [1]")

 */