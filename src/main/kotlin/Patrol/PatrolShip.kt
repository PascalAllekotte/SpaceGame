package Patrol

import enemys

class PatrolShip (name: String, health: Double, attack: Double, defense: Boolean, enemy: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false, false) {

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
                list.removeIf { it.name == name }

            }
        }



    fun normalAttack (patrol: MutableList<Enemy>) {
        val zufallsGenerator = (0 until enemys.size).random()
        val ziel = enemys[zufallsGenerator]

        val level = enemys[zufallsGenerator].level
        val damage = level * 80.0
        var defenseDamge = if (enemys[zufallsGenerator].defense) {
            enemys[zufallsGenerator].health -= damage - damage * 0.82
        } else {
            enemys[zufallsGenerator].health -= damage
        }
        println(" ${name} attacks ${enemys[zufallsGenerator].name} with a damage of [$damage]!")
    }
}
