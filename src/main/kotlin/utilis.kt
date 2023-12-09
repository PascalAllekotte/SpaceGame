import Patrol.Enemy
import Patrol.PatrolShip



fun healthPatrol(ships: List<PatrolShip>, coins: Int): String {
    val patrolHP = ships.sumOf { it.health }
    val healthColor = "\u001B[31m${"%.1f".format(patrolHP)}\u001B[0m"
    val coinColor = "\u001B[38;5;208m$coins\u001B[0m"
    return "Galactic Patrol has a total HP of: $healthColor | Coins: $coinColor"
}



/*fun healthPatrol (shipHP: Double, shipHP2: Double, shipHP3: Double, coins: Int): String{
    var patrolHP = (shipHP + shipHP2 + shipHP3)
    var healthColor = "\u001B[31m$patrolHP\u001B[0m"
    var coinColor = "\u001B[38;5;208m$coins\u001B[0m"
    return "Galactic Patrol has a total HP of: $healthColor | Coins: $coinColor"

}
 */

// ----- Lebenspunkte summieren Patrol
fun totalHP(ships: MutableList<PatrolShip>): Double {
    return ships.sumOf { it.health }
}
// ----- Lebenspunkte summieren Enemies
fun totalHPenemies(ships: MutableList<Enemy>): Double {
    return ships.sumOf { it.health }
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
        val healthColor = "\u001B[31m${"%.1f".format(ship.health)}\u001B[0m"
        val attackColor = "\u001B[34m${"%.1f".format(ship.attack)}\u001B[0m"
        val armorColor = "\u001B[33m${"%.1f".format(ship.armor)}\u001B[0m"
        val levelColor = "\u001B[32m${ship.level}\u001B[0m"
        // val defenseColor = "\u001B[38;5;220m${ship.defense}\u001B[0m" // Ship Name in gelblich-goldener Farbe
        val defenseModeStatus = if (!ship.defense) "\u001B[32mAttack\u001B[0m" else "\u001B[31mDefense\u001B[0m"


        println("Ship: [${nameColor}], HP: [$healthColor], Attack: [$attackColor], Armor: [$armorColor], Level: [$levelColor], Modus: [$defenseModeStatus]")
    }
}

//____________________________Gegner________________________________________
fun enemyStats(patrols: MutableList<Enemy>, round: Int) {
    println("|__________Stats of the Enemy Ships:____________________________________________________")
    for (ship in enemies) {
        val nameColor = "\u001B[97m${ship.name}\u001B[0m"
        val healthColor = "\u001B[31m${"%.1f".format(ship.health)}\u001B[0m"
        val attackColor = "\u001B[34m${"%.1f".format(ship.attack)}\u001B[0m"
        val armorColor = "\u001B[33m${"%.1f".format(ship.armor)}\u001B[0m"
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
//-------------Angriff des gegners Auf alle Patrols
fun attackAllShips(patrolShip: MutableList<PatrolShip>, damage: Double){
    println(" ${enemies[0].name} attack Galactic Patrol.. Damage: [$damage]")
    for (ship in patrolShip){
        var defenseDamge = if (ship.defense){
            ship.health -= damage - damage * 0.86
        } else {
            ship.health -= damage
        }
    }
    //println("\n  After attack")
}

//-------------angriff der gesamten patrols
fun attackAllEnemies(patrolShips: MutableList<PatrolShip>, enemies: MutableList<Enemy>, auswahl: Int) {
    if (patrolShips.any { !it.defense }) {
        val totalAttackPoints = patrolShips.filter { !it.defense }.sumOf { it.attack }


            val defenseMultiplier = if (enemies[auswahl].defense) 0.50 else 1.0
            val damage = totalAttackPoints * defenseMultiplier
            enemies[auswahl].health -= damage
            println("=>${enemies[auswahl].name} is under attack! Damage: [$damage]")
        }
    }

    //println("\n  After attack")


fun gameRound (ship: MutableList<PatrolShip>){

    //var menu1 = readln().toInt() // Nur Zahlen
    menu1(ship)
}

fun menu1(ship: MutableList<PatrolShip>) {
    print("---Plan your next Step---\nChoose ship Ship[1] Ship[2] Ship[3] Continue[4]: ")
    var shipNumber = readln().toInt()
    println("                                                 ¯¯¯")

   when (shipNumber) {
    1, 2, 3 ->   {
        val name = "\u001B[97m${ship[shipNumber - 1].name}\u001B[0m"
        val health = "\u001B[31m${"%.1f".format(ship[shipNumber - 1].health)}\u001B[0m"
        val attack = "\u001B[34m${"%.1f".format(ship[shipNumber - 1].attack)}\u001B[0m"
        val armor = "\u001B[33m${"%.1f".format(ship[shipNumber - 1].armor)}\u001B[0m"
        val level= "\u001B[32m${ship[shipNumber - 1].level}\u001B[0m"

        println(

               "Your choosed ship $shipNumber: \n " +
                       "Ship: [$name], HP: [$health], Attack: [$attack], Armor: [$armor], Level: [$level]"
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
                   itemsMenu(itemList)
               }

               2 -> {
                   if (!defenseMode) {
                       Thread.sleep(400)
                       println("Defensive Mode activated.")
                       Thread.sleep(400)
                       println("Attackmode deactivated.")
                       Thread.sleep(600)
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
                       Thread.sleep(1000)
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
                gameRound(patrols)
               }


           }
        if (menu2 != 4) {
            gameRound(ship)
        }

       }

       4 ->   {

        afterGameRound()

       }
    }

}



fun move2(){
    Thread.sleep(1000)
    println("\nAttacking Enemy...")
    Thread.sleep(1000)
    println("Attacking Enemy......")
    Thread.sleep(1000)
    println("Attacking Enemy.........")
}

fun gegnerAngriff1() {
    for (enemy in enemies) {
        enemy.normalAttack(patrols)
        break
    }
}

fun attack2() {
    for (enemy in enemies) {
        enemy.normalAttack(patrols)
    }
}
//_______________Spielverlauf nach GameRound_____________________________________________________________________
fun afterGameRound (){
    println("Decide now\n  Attack/Defense [1]\n  Back to Ships  [2]")
    print("Choose: ")
    var actionInput = readln().toInt()
    println("       ¯¯¯")

    when (actionInput){
        1 -> {
            angriffZiele()
        }
        2 -> {
            gameRound(patrols)
        }
    }

}
//______________Items im Gameround Menü_____________________________________

    fun itemsMenu (liste: MutableList<Items>){
        if (liste.isEmpty() && coins <= 0){
            println("No Coins/Items in Storage")
        } else if (coins >= 0 && liste.isEmpty()){
            println("\n No items in storage!\n=>Show store?")
            println("   Yes [1]\n   No  [2]")
            println("Choose: ")
            var auswahl = readln().toInt()
            when (auswahl) {
                1 -> {
                    println(
                        "          Item Store" +
                                "\n        ¯¯¯¯¯¯¯¯¯¯¯¯¯"
                    )
                   storeListe()

                }

                2 -> {
                    return

                }
            }
        } else {
            println("$liste")
        }

    }


fun storeListe() {
    // ChatGPT hat geholfen, um die 2 Blöcke zu bauen
    val halfSize = storeItems.size / 2
    val firstBlock = storeItems.subList(0, halfSize)
    val secondBlock = storeItems.subList(halfSize, storeItems.size)

    for ((index, item) in firstBlock.withIndex()) {
        println("[${index + 1}] ${item.name}".padEnd(25) + "[${index + halfSize + 1}] ${secondBlock[index].name}")
    }
    println("\n")
}


//------------------Angriffe

fun angriffZiele(){

    if (überprüfeAufvollDefensive(patrols)){
        println("   All ships in 'Defensive' mode.\n      Continue without attacking.")

    } else {
        println("You can attack following ships:")
        enemyStats(enemies, round)
        angriffsZielWählen()
        }
    }
fun angriffsZielWählen(){
    listEnemyNames(enemies)
    print("Decide: ")
    var auswahl = readln().toInt()
    when (auswahl){
        1,2 -> {
            println("Attack with:\n     [1] All ship/s\n${attackModeShips(patrols)}")
            print("Choose: ")
            var auswahl2 = readln().toInt()
            if (auswahl2 == 1){
                move2()
                attackAllEnemies(patrols, enemies, auswahl-1)



            // nur für den effect nach bestätigung noch nicht codiert

            }

        }

    }

}
fun attackModeShips(patrols: MutableList<PatrolShip>): String{
    val attackModeShips = patrols.filter { !it.defense }
    return attackModeShips.mapIndexed { index, ship -> "     [${index + 2}] ${ship.name}" }.joinToString("\n")
}


fun listEnemyNames(enemys: MutableList<Enemy>) {
    var nummerierung = 1
    for (enemy in enemys) {
        println("   [$nummerierung]${enemy.name}")
        nummerierung++
    }
    println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")

}

//--------Defensive-----= Kein Angriff
fun überprüfeAufvollDefensive(patrols: MutableList<PatrolShip>): Boolean{
    return patrols.all { it.defense }
}

//-------Patrolship Zerstört true or false
fun überprüfeObZerstörtPatrol(patrols: MutableList<PatrolShip>, auswahl: Int): Boolean{
    if (auswahl in patrols.indices){
        return patrols[auswahl].destroyed
    } else {
        return false
    }
}

//-------Enemy Zerstört true or false
fun überprüfeObZerstört(patrols: MutableList<PatrolShip>, auswahl: Int): Boolean{
    if (auswahl in patrols.indices){
        return patrols[auswahl].destroyed
    } else {
        return false
    }
}

fun spawnEnemys (enemies: MutableList<Enemy>){
    if (totalHPenemies(enemies) <= 0){
        enemies.add(
            Enemy("SilverAlien", 240.0, 55.0, false, false, false, 2, 0.0)
        )
        enemies.add(
            Enemy("BadAlien", 230.0, 55.0, false, false, false, 2, 0.0)
        )
        enemies.add(
            Enemy("Baddy", 240.0, 55.0, false, false, false, 2, 0.0)
        )

    }

}

/*fun spawnEnemys (enemies: MutableList<Enemy>){
    if (enemies.isEmpty()){
        enemies.add(
            Enemy("SilverAlien", 240.0, 55.0, false, false, false, 2, 0.0)
        )
        enemies.add(
            Enemy("BadAlien", 230.0, 55.0, false, false, false, 2, 0.0)
        )
        enemies.add(
            Enemy("Baddy", 240.0, 55.0, false, false, false, 2, 0.0)
        )

    }

}
*/


//--------AtackierModus= Schiffe anzeigen



/*

    Defensemodus Atacke rezuzieren
      var defenseDamge = if (ship.defense){
            ship.health -= damage - damage * 0.86

 auf eine nachkommastelle runden "%.1f".format


 */
