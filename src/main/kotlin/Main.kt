import Patrol.PatrolShip

val itemList = mutableListOf<Items>(

)
var round = 1
var coins = null ?: "No Coins"
var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 1000.0, 55.0, true, false, 1, 0.0),
    PatrolShip("Nebular Shooter", 920.0, 70.0, true,  false, 1, 0.0),
    PatrolShip("Cosmic Cargo",    1250.0, 40.0, true,  false, 1, 00.0)
)




    fun main() {
        var patrolHealth = healthPatrol(patrols[0].health, patrols[1].health, patrols[2].health, coins)
        var alive = true

        // Später noch Blinken lassen Spielstart Effekt einbauen
        println("                                Galactic Patrol")
        println("______________________________________________________________________________________")


        while (alive) {


            shipStats(patrols, round) // Stats of your ships
            println(patrolHealth) // total Health
            bag(itemList) // Items in storage
            nextStep(patrols)
            move2()




//AB hier macht der Gegner seinen move
            attackAllShips(patrols, 500.0)
            shipStats(patrols, round)
            var healthpoints = totalHP(patrols[0].health, patrols[1].health, patrols[2].health)
            if (healthpoints <= 0) {
                alive = false
            }
           readln().toString()
            println("---------------Next round!-------------")
            round++
            println("\n")
        }
        println("Game Over")
    }



// rot    println("\u001B[31mThis text is red.\u001B[0m")
// blau   println("\u001B[34mThis text is blue.\u001B[0m")
// grün   println("\u001B[32mThis text is green.\u001B[0m")