import Patrol.Enemy
import Patrol.PatrolShip

val itemList = mutableListOf<Items>(

)
var round = 1
var coins = 0

var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 1000.0, 55.0, false, false, false,1, 0.0),
    PatrolShip("Nebular Shooter", 920.0, 80.0, false,  false, false,1, 0.0),
    PatrolShip("Cosmic Cargo",    1250.0, 50.0, false,  false, false,1, 00.0)
)



val enemies =  mutableListOf(
    Enemy("BlueAlien", 200.0, 55.0, false, false, false, 2, 0.0),
    Enemy("GreenAlien", 200.0, 55.0, false, false, false, 2, 0.0)
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
            spawnEnemys(enemies)              // fehler isempty durch health <= 0 austasuchen

            patrols.forEach { it.zerstörtAusListeLöschenPatrol(patrols)}
            zerstörtAusListeLöschenEnemy(enemies)
            if (round == 1){
                print("")
            } else {
                println("----------------Next round!--------------")
            }
            var patrolHealth = healthPatrol(patrols, coins)
            shipStats(patrols, round) // Stats der Schiffe
            println(patrolHealth) // Gesamte Gesundheit und Coins anzeigen
            bag(itemList) // Items im storage anzeigen
            gameRound(patrols) // Schiffe mit items bestücken oder Modus auswählen
            println("\n----Move noch in Bearbeitung---\n")
//AB hier macht der Gegner seinen move
            gegnerAngriff1() // KEIN FEHLER
            patrols.forEach { it.zerstört(patrols)}
            enemies.forEach { it.zerstört(enemies)}
            attackAllShips(patrols, 370.0) // Gegner attackiert alle Schiffe
            //patrols.forEach { it.zerstört(patrols)}


            print("Press Enter for next Round")
            readln().toIntOrNull()
            //attack2()

            // gegnerAngriff1()



           // attackAllShips(patrols, 500.0)
           // shipStats(patrols, round)
            var healthpoints = totalHP(patrols)
            if (healthpoints <= 0) {
                alive = false
            }


            round++
            coins+=20
            println("\n")
        }
        println("Game Over")

    }

fun zerstörtAusListeLöschenEnemy(list: MutableList<Enemy>) {
    list.removeIf { enemy -> enemy.health <= 0 }
}



//patrols[0].level += 1
// rot    println("\u001B[31mThis text is red.\u001B[0m")
// blau   println("\u001B[34mThis text is blue.\u001B[0m")
// grün   println("\u001B[32mThis text is green.\u001B[0m")