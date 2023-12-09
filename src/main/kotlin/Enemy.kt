package Patrol

import patrols


class Enemy(name: String, health: Double, attack: Double, defense: Boolean, destroyed: Boolean, enemy: Boolean, level: Int, armor: Double) : Ship(name, health, attack, false, true,false) {

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
        val hpErhöhen = maxHealth * 0.3
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


    fun normalAttack(patrol: MutableList<PatrolShip>) {
        val zufallsGenerator = (0 until patrols.size).random()
        val ziel = patrols[zufallsGenerator]

        val level = patrols[zufallsGenerator].level
        val damage = level * 80.0
        var defenseDamge = if (patrols[zufallsGenerator].defense) {
            patrols[zufallsGenerator].health -= damage - damage * 0.82
        } else {
            patrols[zufallsGenerator].health -= damage
        }
        println(" ${name} attacks ${patrols[zufallsGenerator].name} with a damage of [$damage]!")
    }

    fun attack2(patrol: MutableList<PatrolShip>) {
        val level = patrols[0].level  // Annahme: Alle Schiffe haben das gleiche Level
        val damage = level * 80.0

        for (ship in patrols) {
            val actualDamage = if (ship.defense) {
                (damage - damage * 0.82).coerceAtLeast(0.0)
            } else {
                damage
            }

            ship.health -= actualDamage
        }

        println("Das feindliche Schiff greift alle Galactic Patrol-Schiffe mit einem Schaden von $damage an.")
    }



    // Mitteilung wenn gegnerisches Raumschiff zerstört wurde.

    fun zerstört(list: MutableList<Enemy>) {
        if (health <= 0) {
            println("->Enemy spaceship '$name' got destroyed....")


        }
    }
}



// println(" Enemy ship attacking all Galactic Patrol ships with a damage of $damage ")
