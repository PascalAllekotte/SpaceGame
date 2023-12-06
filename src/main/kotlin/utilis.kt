import Patrol.Enemy
import Patrol.PatrolShip

fun healthPatrol (shipHP: Double, shipHP2: Double, shipHP3: Double, coins: Any): String{
    var patrolHP = (shipHP + shipHP2 + shipHP3)
    var healthColor = "\u001B[31m$patrolHP\u001B[0m"
    var coinColor = "\u001B[38;5;208m$coins\u001B[0m"
    return "Galactic Patrol has a total HP of: $healthColor | Coins: $coinColor"

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

fun shipStats(patrols: MutableList<PatrolShip>, round: Int) {
    println("__________Stats of your ships:__________    Round: $round    __________")
    for (ship in patrols) {
        val nameColor = "\u001B[97m${ship.name}\u001B[0m"
        val healthColor = "\u001B[31m${ship.health}\u001B[0m"
        val attackColor = "\u001B[34m${ship.attack}\u001B[0m"
        val armorColor = "\u001B[33m${ship.armor}\u001B[0m"
        val levelColor = "\u001B[32m${ship.level}\u001B[0m"
        // val defenseColor = "\u001B[38;5;220m${ship.defense}\u001B[0m" // Ship Name in gelblich-goldener Farbe
        val defenseModeStatus = if (!ship.defense) "\u001B[32mAttack\u001B[0m" else "\u001B[31mDefense\u001B[0m"


        println("Ship: [${nameColor}], HP: [$healthColor], Attack: [$attackColor], Armor: [$armorColor], Level: [$levelColor], Modus: [$defenseModeStatus]")
    }
}

//____________________________Gegner________________________________________
fun enemyStats(patrols: MutableList<Enemy>, round: Int) {
    println("|__________Stats of the Enemy Ships:____________________________________________________")
    for (ship in enemys) {
        val nameColor = "\u001B[97m${ship.name}\u001B[0m"
        val healthColor = "\u001B[31m${ship.health}\u001B[0m"
        val attackColor = "\u001B[34m${ship.attack}\u001B[0m"
        val armorColor = "\u001B[33m${ship.armor}\u001B[0m"
        val levelColor = "\u001B[32m${ship.level}\u001B[0m"
        // val defenseColor = "\u001B[38;5;220m${ship.defense}\u001B[0m" // Ship Name in gelblich-goldener Farbe
        val defenseModeStatus = if (!ship.defense) "\u001B[32mAttack\u001B[0m" else "\u001B[31mDefense\u001B[0m"


        println("|Ship: [${nameColor}], HP: [$healthColor], Attack: [$attackColor], Armor: [$armorColor], Level: [$levelColor], Modus: [$defenseModeStatus] |")
    }
    println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")

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
        var defenseDamge = if (ship.defense){
            ship.health -= damage - damage * 0.86
        } else {
            ship.health -= damage
        }
    }
    //println("\n  After attack")
}

fun gameRound (ship: MutableList<PatrolShip>){

    //var menu1 = readln().toInt() // Nur Zahlen
    menu1(ship)
}

fun menu1(ship: MutableList<PatrolShip>) {
    print("---Plan your next Step---\nChoose ship Ship[1] Ship[2] Ship[3] Continue [4]: ")
    var shipNumber = readln().toInt()
    println("                                                 ¯¯¯")

   when (shipNumber) {
    1, 2, 3 ->   {
        val name = "\u001B[97m${ship[shipNumber - 1].name}\u001B[0m"
        val health = "\u001B[31m${ship[shipNumber - 1].health}\u001B[0m"
        val attack = "\u001B[34m${ship[shipNumber - 1].attack}\u001B[0m"
        val armor = "\u001B[33m${ship[shipNumber - 1].armor}\u001B[0m"
        val level= "\u001B[32m${ship[shipNumber - 1].level}\u001B[0m"

        println(

               "Your choosed ship $shipNumber: \n " +
                       "Ship: [$name], HP: [$health], Atack: [$attack], Armor: [$armor], Level: [$level]"
           )
           var defenseMode = ship[shipNumber - 1].defense
           val defenseModeStatus =
               if (defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"
           val attackModeStatus =
               if (!defenseMode) "\u001B[32mActivated\u001B[0m" else "\u001B[31mDeactivated\u001B[0m"


           print("Actions:\n  Use Items    [1]\n  DefensiveMode[2] $defenseModeStatus\n  AttackMode   [3]    $attackModeStatus\n  Back[4]\nChoose: ")
           var menu2 = readln().toInt() // Nur Zahlen
           when (menu2) {
               1 -> {
               }

               2 -> {
                   if (!defenseMode) {
                       Thread.sleep(600)
                       println("Defensive Mode activated.")
                       Thread.sleep(600)
                       println("Attackmode deactivated.")
                       Thread.sleep(2000)
                       ship[shipNumber - 1].defense = true

                   } else {
                       Thread.sleep(600)
                       println("Defense mode is already activated.")
                       Thread.sleep(600)

                   }
                   Thread.sleep(600)

               }

               3 -> {
                   if (defenseMode) {
                       Thread.sleep(600)
                       println("Attackmode activated.")
                       Thread.sleep(600)
                       println("Defensive deactivated.")
                       Thread.sleep(2000)
                       ship[shipNumber - 1].defense = false

                   } else {
                       Thread.sleep(600)
                       println("Attack mode is already activated.")
                       Thread.sleep(600)

                   }
                   Thread.sleep(600)

               }

               4 -> {
                   Thread.sleep(600)

               }


           }
        if (menu2 != 4) {
            gameRound(ship)
        }

       }

       4 ->   {

           enemyStats(enemys, round)
       }
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

fun gegnerAngriff1() {
    for (enemy in enemys) {
        enemy.normalAttack(patrols)
    }
}

fun attack2() {
    for (enemy in enemys) {
        enemy.attack2(patrols)
    }
}



/*
    println("Attack [1]")
    println("Use Item [1]")
    println("Repair Ship [1]")

    Defensemodus Atacke rezuzieren
      var defenseDamge = if (ship.defense){
            ship.health -= damage - damage * 0.86



 */