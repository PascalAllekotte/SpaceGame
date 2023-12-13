import Patrol.Enemy
import Patrol.PatrolShip

val itemList = mutableListOf<Items>(

)
var round = 1
var coins = 0
var gegnerGruppe = 0

var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 700.0, 55.0, false, false, false,1, 0.0, false),
    PatrolShip("Nebular Shooter", 620.0, 80.0, false,  false, false,1, 0.0, false),
    PatrolShip("Cosmic Cargo",    1000.0, 50.0, false,  false, false,1, 00.0, false)
)



var enemies =  mutableListOf(
    Enemy("BlueAlien", 10.0, 57.0, false, false, false, 2, 0.0, false),
    Enemy("GreenAlien", 50.0, 62.0, false, false, false, 2, 0.0, false)
)



val storeItems =  mutableListOf(
    Items("Armor    +250", 250.0, 250.0, 100),
    Items("Armor    +500", 500.0, 500.0, 180),
    Items("PatrolHP +250", 250.0, 250.0, 200),
    Items("Max HP   +250", 250.0, 250.0, 120),
    Items("Repair Ship  ", 250.0, 250.0, 200),
    Items("Repair Crew  ", 250.0, 250.0, 400)

)


fun main() {
        var alive = true


        // Später noch Blinken lassen Spielstart Effekt einbauen
        println("                                Galactic Patrol")
        println("______________________________________________________________________________________")


        while (alive) {
            if (enemies.isEmpty()){
                gegnerGruppe++
                println("                                      ______________LEVEL UP: "+ ("\u001B[32m${patrols[0].level}\u001B[0m") + " _____________")

            }

            spawnEnemys(enemies, gegnerGruppe)

            if (round == 1){
                print("")
            } else {
                println("----------------Next round!--------------")
            }
            var patrolHealth = healthPatrol(patrols, coins)
            shipStats(patrols, round) // Stats der Schiffe
            println(patrolHealth) // Gesamte Gesundheit und Coins anzeigen
            bag(itemList, patrols) // Items im storage anzeigen
            gameRound(patrols) // Schiffe mit items bestücken oder Modus auswählen
            // Printed wenn eins zerstört wurde vom gegner
            zerstörtAusListeLöschenEnemy(enemies) // löscht diese dann aus der liste
            enemies.forEach { it.zerstört(enemies)}
//AB hier macht der Gegner seinen move
           move3()
            spezialAngriffBoss(enemies, patrols)

            laserAngriffdesGegners()
            normalerAngriffdesGegners() // KEIN FEHLER
            // patrols.forEach { it.zerstört(patrols)}
            // attackAllShips(patrols, 200.0) // Gegner attackiert alle Schiffe Boss
            //patrols.forEach { it.zerstört(patrols)}
            zerstörtAusListeLöschenPatrol(patrols) // klappt
            special2(enemies) // klappt
            dropItem(enemies, patrols, itemList)
            println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
            print("Press Enter for next Round")
            readln().toIntOrNull()
            //attack2()

            // gegnerAngriff1()



           // attackAllShips(patrols, 500.0)
           // shipStats(patrols, round)

            if (alleUnterOder0(patrols)) {
                alive = false
            }


            round++
            coins+=20
            println("\n")
                          // fehler isempty durch health <= 0 austasuchen
            zerstörtAusListeLöschenPatrol(patrols)
            zerstörtAusListeLöschenEnemy(enemies)
            bereitsAngegriffenZurücksetzten()
            levelUP(enemies, patrols) // noch anzeigen lassen




        }
        println("Game Over")

    }

fun zerstörtAusListeLöschenEnemy(list: MutableList<Enemy>) {

    list.removeIf { enemy -> enemy.health <= 0 }
}
fun zerstörtAusListeLöschenPatrol(list: MutableList<PatrolShip>) {
    list.removeIf { enemy -> enemy.health <= 0 }
}


//patrols[0].level += 1
// rot    println("\u001B[31mThis text is red.\u001B[0m")
// blau   println("\u001B[34mThis text is blue.\u001B[0m")
// grün   println("\u001B[32mThis text is green.\u001B[0m")



