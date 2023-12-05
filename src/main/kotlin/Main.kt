import Patrol.PatrolShip
import kotlinx.coroutines.*

val itemList = mutableListOf<Items>(

)
var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 1000.0, 50.0, false, 1, 250.0),
    PatrolShip("Nebular Shooter", 1000.0, 50.0, false, 1, 250.0),
    PatrolShip("Cosmic Cargo", 1000.0, 50.0, false, 1, 250.0)
)




    fun main() {
        var patrolHealth = healthPatrol(patrols[0].health, patrols[1].health, patrols[2].health)
        var alive = true

        println("                                Galactic Patrol")
        println("______________________________________________________________________________________")


        while (alive) {


            shipStats(patrols) // Stats of your ships
            println(patrolHealth) // total Health
            bag(itemList) // Items in storage
            nextStep(patrols)
//AB hier macht der Gegner seinen move
            attackAllShips(patrols, 500.0)
            shipStats(patrols)
            var healthpoints = totalHP(patrols[0].health, patrols[1].health, patrols[2].health)
            if (healthpoints <= 0) {
                alive = false
            }
            readln().toDouble()

            println("\n")
        }
        println("Game Over")
    }

