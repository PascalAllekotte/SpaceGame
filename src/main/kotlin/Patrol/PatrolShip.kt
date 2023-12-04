package Patrol

class PatrolShip (name: String, health: Double, attack: Double, enemy: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false){

    val name = name
    var health = health
    var attack = attack
    var level = level
    var armor = armor


}
