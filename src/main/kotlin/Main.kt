import Patrol.Enemy
import Patrol.PatrolShip

val itemList = mutableListOf<Items>(

)
var round = 1
var coins = 0

var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 1000.0, 55.0, false, false, 1, 0.0),
    PatrolShip("Nebular Shooter", 920.0, 70.0, false,  false, 1, 0.0),
    PatrolShip("Cosmic Cargo",    1250.0, 40.0, false,  false, 1, 00.0)
)



val enemys =  mutableListOf(
    Enemy("BlueAlien", 200.0, 55.0, false, false, 2, 0.0),
    Enemy("GreenAlien", 200.0, 55.0, false, false, 2, 0.0)

)



fun main() {
        var alive = true

        // Später noch Blinken lassen Spielstart Effekt einbauen
        println("                                Galactic Patrol")
        println("______________________________________________________________________________________")


        while (alive) {
            var patrolHealth = healthPatrol(patrols[0].health, patrols[1].health, patrols[2].health, coins)
            shipStats(patrols, round) // Stats der Schiffe
            println(patrolHealth) // Gesamte Gesundheit und Coins anzeigen
            bag(itemList) // Items im storage anzeigen
            gameRound(patrols) // Schiffe mit items bestücken oder Modus auswählen
            println("\n----Move noch in Bearbeitung---\n")
//AB hier macht der Gegner seinen move
            gegnerAngriff1()
            attackAllShips(patrols, 500.0) // Gegner attackiert alle Schiffe


            print("Press Enter for next Round")
            readln().toIntOrNull()
            //attack2()

            // gegnerAngriff1()



//AB hier macht der Gegner seinen move
           // attackAllShips(patrols, 500.0)
           // shipStats(patrols, round)
            var healthpoints = totalHP(patrols[0].health, patrols[1].health, patrols[2].health)
            if (healthpoints <= 0) {
                alive = false
            }

            println("----------------Next round!--------------")
            round++
            coins+=20
            println("\n")
        }
        println("Game Over")
    }



//patrols[0].level += 1
// rot    println("\u001B[31mThis text is red.\u001B[0m")
// blau   println("\u001B[34mThis text is blue.\u001B[0m")
// grün   println("\u001B[32mThis text is green.\u001B[0m")