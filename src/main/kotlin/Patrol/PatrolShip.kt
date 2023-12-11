package Patrol

import enemies

open class PatrolShip (name: String, health: Double, attack: Double, defense: Boolean, enemy: Boolean, destroyed: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false, false, false) {

    var destroyed = destroyed
    val name = name
    var health = health
    var attack = attack
    var armor = armor
    var defense = defense

    private var maxHealth: Double = health
    private var maxAttack: Double = attack

    var level: Int = level
        set(value) {
            field = value
            updateStats()
        }

    init {

        updateStats()
    }

    private fun updateStats() {
        val hpErhöhen = maxHealth * 0.2
        val attackErhöhen = maxAttack * 0.2

        maxHealth = maxHealth + hpErhöhen
        maxAttack = maxAttack + attackErhöhen

        health = maxHealth
        attack = maxAttack

        fun levelAufstieg() {
            val healthAnstieg = health * 0.2
            val attackAnstieg = health * 0.2
        }
    }


        fun zerstört(list: MutableList<PatrolShip>) {
            if (health <= 0) {
                println("<-Your spaceship '$name' got destroyed....")
            }
        }

    fun zerstörtAusListeLöschenPatrol(list: MutableList<PatrolShip>) {
        if (health <= 0) {
            list.remove(this)
        }
    }

    fun normalAttack (patrol: MutableList<Enemy>) {
        val zufallsGenerator = (0 until enemies.size).random()
        val ziel = enemies[zufallsGenerator]

        val level = enemies[zufallsGenerator].level
        val damage = level * 80.0
        var defenseDamge = if (enemies[zufallsGenerator].defense) {
            enemies[zufallsGenerator].health -= damage - damage * 0.82
        } else {
            enemies[zufallsGenerator].health -= damage
        }
        println(" ${name} attacks ${enemies[zufallsGenerator].name} with a damage of [$damage]!")
    }
}
