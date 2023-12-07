package Patrol

class PatrolShip (name: String, health: Double, attack: Double, defense: Boolean, enemy: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false, false){

    val name = name
    var health = health
    var attack = attack
    var level = level
    var armor = armor
    var defense = defense

    fun zerstört(){
        if(health <= 0)(
                println("Your spaceship '$name' got destroyed....")
                )
    }


}
