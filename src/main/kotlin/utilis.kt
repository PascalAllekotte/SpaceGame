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


//wenn alle unter 0 sind dann tot ansonsten nicht
fun alleUnterOder0 (ship: MutableList<PatrolShip>) : Boolean{
    return ship.all { it.health <= 0}
    }


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


fun gameRound (ship: MutableList<PatrolShip>){

    //var menu1 = readln().toInt() // Nur Zahlen
    menu1(ship)
}

fun menu1(ship: MutableList<PatrolShip>) {
    var richtigeEingabe = false
    while (!richtigeEingabe) {

        print("---Plan your next Step---\nChoose ship Ship[1] Ship[2] Ship[3] Continue[4]: ") // bug wenn ein patrol schiff zerstört ist muss hier auch noch gelöscht werden
        try {
            var shipNumber = readln().toInt()
            println("                                                ¯¯¯")


            when (shipNumber) {
                1, 2, 3 -> {
                    val name = "\u001B[97m${ship[shipNumber - 1].name}\u001B[0m"
                    val health = "\u001B[31m${"%.1f".format(ship[shipNumber - 1].health)}\u001B[0m"
                    val attack = "\u001B[34m${"%.1f".format(ship[shipNumber - 1].attack)}\u001B[0m"
                    val armor = "\u001B[33m${"%.1f".format(ship[shipNumber - 1].armor)}\u001B[0m"
                    val level = "\u001B[32m${ship[shipNumber - 1].level}\u001B[0m"

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
                    try {

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
                                    gameRound(patrols)

                                } else {
                                    Thread.sleep(600)
                                    println("Defense mode is already activated.")
                                    Thread.sleep(600)
                                    gameRound(patrols)

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
                                    gameRound(patrols)

                                } else {
                                    Thread.sleep(600)
                                    println("Attack mode is already activated.")
                                    Thread.sleep(600)
                                    gameRound(patrols)

                                }
                                Thread.sleep(600)

                            }

                            4 -> {
                                Thread.sleep(600)
                                gameRound(patrols)
                            }


                        }
                        richtigeEingabe = true
                    } catch (e: NumberFormatException) {
                        println("Wrong input!")
                    }
                }

                4 -> {

                    afterGameRound()
                    richtigeEingabe = true

                }
                else -> {
                    println("Wrong input!")
                }
            }
        } catch (e: NumberFormatException) {
            println("Wrong input!")
        }
    }
}



fun move2(){
    if (!überprüfeAufvollDefensive(patrols))
    Thread.sleep(500)
    println("\nAttacking Enemy...")
    Thread.sleep(400)
    println("=> =>")
        Thread.sleep(200)
        println("=>     =>")
        Thread.sleep(100)
        println("   => =>")
        Thread.sleep(200)
        println("  =>         =>")

    println("Attacking Enemy.......")
    Thread.sleep(700)

}
fun move3(){
    if (!enemies.isEmpty()){
    println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
    println("\n______Enemy shoots back______________!")

        Thread.sleep(400)
        println("<= <=")
        Thread.sleep(200)
        println("<=     <=")
        //gegnerAngriff1()
        Thread.sleep(100)
        println("   <= <=")
        Thread.sleep(200)
    //attackAllShips(patrols, 200.0)
    println("  <=         <=\n \n \n")
    Thread.sleep(700)}
    patrols.forEach { it.zerstört(patrols)}

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
            gameRound(patrols)
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
    gameRound(patrols)
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
        in 1..enemies.size -> { // wählt 1 - index der enemies liste
            println("Attack with:\n     [1] All ship/s\n${attackModeShips(patrols)}")
            print("Choose: ")
            var auswahl2 = readln().toInt()
            if (auswahl2 == 1) {
                move2()
                attackAllEnemies(patrols, enemies, auswahl - 1)

            } else {
                val schiffe = attackModeShipsListe(patrols)
                val attackShips = attackModeShips(patrols)

                if (auswahl2 in 2..attackShips.count() + 1) {
                    move2()
                    //println("Youre attacking with ${schiffe[auswahl2 - 2].name} ")
                    var schiffWasAngreift = schiffe[auswahl2 - 2].name
                        normalerAngriffPatrol(schiffWasAngreift)
                    zerstörtAusListeLöschenEnemy(enemies) //tets
                    // nur für den effect nach bestätigung noch nicht codiert
                    enemies.forEach { it.zerstört(enemies)}
                if (!enemies.isEmpty()) {
                    angriffZiele()//test
                }
                } else {
                    println("Wrong input.")
                }
            }
        }
        else -> {
            println("Wrong input.")
        }
    }
}

fun normalerAngriffPatrol(schiffName: String) {
    val patrolsListe = patrols.filter { !it.destroyed }.shuffled()
    for (patrol in patrolsListe) {
        if (!patrol.destroyed && patrol.name == schiffName) {
            patrol.normalAttackPatrol(enemies, 0)
            patrol.bereitsAngegriffen = true
            break
        }
    }
}



fun bereitsAngegriffenZurücksetzten() {
    patrols.forEach { it.bereitsAngegriffen = false }
}

fun attackModeShipsListe(patrols: MutableList<PatrolShip>): List<PatrolShip> {
    val attackShips = mutableListOf<PatrolShip>()

    for (ship in patrols) {
        if (!ship.defense) {
            attackShips.add(ship)
        }
    }

    return attackShips
}

fun attackModeShips(patrols: MutableList<PatrolShip>): String{
    val attackModeShips = patrols.filter { !it.defense && !it.bereitsAngegriffen}
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

fun spawnEnemys (enemies: MutableList<Enemy>, gegnerGruppe: Int){
    if (enemies.isEmpty() && gegnerGruppe == 1){
        enemies.add(
            Enemy("SilverAlien", 50.0, 75.0, false, false, false, 2, 0.0, false)
        )
        enemies.add(
            Enemy("BadAlien", 30.0, 55.0, false, false, false, 2, 0.0, false)
        )
        enemies.add(
            Enemy("Baddy", 40.0, 85.0, false, false, false, 2, 0.0, false)
        )

    } else if (gegnerGruppe == 2 && enemies.isEmpty()){
        enemies.add(
            Enemy("SILVER BOSS", 2050.0, 115.0, false, false, false, 3, 0.0, true)
        )
    }



}

fun levelUP (enemies: MutableList<Enemy>, patrols: MutableList<PatrolShip>){
    if (enemies.isEmpty()){
        for (patrol in patrols){
            patrol.level += 1
        }
    }

}




//---------------------Attacken vom Gegner-----
fun normalerAngriffdesGegners() {
    val enemiesListe = enemies.filter { !it.destroyed }.shuffled()
    for (enemy in enemiesListe) {
        if (!enemy.destroyed){
            enemy.normalAttack(patrols)}

    }
}


fun laserAngriffdesGegners() {
    val enemiesListe = enemies.filter { !it.destroyed }.shuffled()
    for (enemy in enemiesListe) {
        if (!enemy.destroyed){
            enemy.laserAttack(patrols)}
        break
    }
}

//-------------Angriff des gegners Auf alle Patrols
fun attackAllShips(patrolShip: MutableList<PatrolShip>, damage: Double){
var lebtNoch = false
    if (enemies.isNotEmpty() && !enemies[0].destroyed){
    for (ship in patrolShip) {
        if (!enemies[0].destroyed) {
            lebtNoch = true
            var defenseDamge = if (ship.defense) {
                ship.health -= damage - damage * 0.86
            } else {
                ship.health -= damage
            }
        }
    }
    }
    if (lebtNoch){
        println(" ${enemies[0].name} attack Galactic Patrol.. Damage: [$damage]")
    }
    //println("\n  After attack")
}
fun spezialAngriffBoss(enemies: MutableList<Enemy>, patrols: MutableList<PatrolShip>) {

        for (enemy in enemies) {
            enemy.specialAttackBoss(patrols, false )
        }
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
    if (enemies[auswahl].health <= 0){
        enemies[auswahl].destroyed = true
    }
}


//println("\n  After attack")
