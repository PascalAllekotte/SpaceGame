package Patrol

import patrols


class Enemy (name: String, health: Double, attack: Double, defense: Boolean, enemy: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false, true){

    fun normalAttack (patrol: MutableList<PatrolShip>) {
        val zufallsGenerator = (0 until patrols.size).random()
        val ziel = patrols[zufallsGenerator]

        val level = patrols[zufallsGenerator].level
        val damage = level * 50.0
        var defenseDamge = if (patrols[zufallsGenerator].defense) {
            patrols[zufallsGenerator].health -= damage - damage * 0.86
        } else {
            patrols[zufallsGenerator].health -= damage
        }




        println(" führt einen Spezialangriff aus und fügt ${patrols[zufallsGenerator].name} $damage Schaden zu!")

    }



}