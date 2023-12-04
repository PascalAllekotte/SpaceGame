import Patrol.PatrolShip

fun main() {
    var patrols = mutableListOf(
    PatrolShip("Galactic Reaper", 1000.0, 50.0, false, 1, 250.0),
    PatrolShip("Nebular Shooter", 1000.0, 50.0, false, 1, 250.0),
    PatrolShip("Cosmic Cargo", 1000.0, 50.0, false, 1, 250.0)
    )
    var patrolHealth = healthPatrol(patrols[0].health, patrols[1].health, patrols[2].health)


    shipStats(patrols)
    println(patrolHealth)
}

