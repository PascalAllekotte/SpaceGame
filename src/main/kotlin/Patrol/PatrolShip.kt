package Patrol

import enemies

open class PatrolShip (name: String, health: Double, attack: Double, defense: Boolean, enemy: Boolean, destroyed: Boolean, level: Int, armor: Double, bereitsAngegriffen: Boolean) : Ship(name, health, attack, false, false, false) {

    var destroyed = destroyed
    val name = name
    var health = health
    var attack = attack
    var armor = armor
    var defense = defense
    var bereitsAngegriffen = false

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




    open fun normalAttackPatrol(enemies: MutableList<Enemy>, auswahl: Int) {
        if (auswahl in enemies.indices) {
            val target = enemies[auswahl]

            val damage = attack
            val defenseDamage = if (target.defense) {
                target.health -= damage - damage * 0.82
            } else {
                target.health -= damage
            }
            println("$name attacks ${target.name} \u001B[31m[${"%.1f".format(damage)}]\u001B[0m")
            enemies.forEach { it.zerstört(enemies)}
        } else {
            println("Invalid target selection.")
        }
    }
    fun zerstört(list: MutableList<PatrolShip>) {
        if (health <= 0) {
            println("-> Your spaceship " + "\u001B[33m'$name'\u001B[0m" + " got destroyed....")
        }
    }

}
