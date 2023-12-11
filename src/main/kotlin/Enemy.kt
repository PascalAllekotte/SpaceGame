package Patrol

import enemies
import patrols


class Enemy(name: String, health: Double, attack: Double, defense: Boolean, destroyed: Boolean, enemy: Boolean, level: Int, armor: Double, boss: Boolean) : Ship(name, health, attack, false, true,false) {

    val name = name
    var health = health
    var attack = attack
    var armor = armor
    var defense = defense
    var destroyed = false
    var level = level
    var boss = Boolean

    private var maxHealth: Double = health
    private var maxAttack: Double = attack


    fun specialAttackBoss(patrols: MutableList<PatrolShip>, boss: Boolean) {
        if (boss) {
            println("$name uses special attack against Galactic Patrol! Halves Attack for 1 round!!!")

            patrols.forEach { it.attack /= 2 }
            patrols.forEach { it.defense = true }
        }
    }



        fun normalAttack(patrol: MutableList<PatrolShip>) {

            val zufallsGenerator = (0 until patrols.size).random()
            val ziel = patrols[zufallsGenerator]


            val damage = attack
            var defenseDamge = if (patrols[zufallsGenerator].defense) {
                patrols[zufallsGenerator].health -= damage - damage * 0.82
            } else {
                patrols[zufallsGenerator].health -= damage
            }
            println(" ${name} attacks ${patrols[zufallsGenerator].name} with a damage of " + "\u001B[31m[$damage]\u001B[0m")

        }

        fun laserAttack(patrol: MutableList<PatrolShip>) {

            val zufallsGenerator = (0 until patrols.size).random()
            val ziel = patrols[zufallsGenerator]


            val damage = attack * 2
            var defenseDamge = if (patrols[zufallsGenerator].defense) {
                patrols[zufallsGenerator].health -= damage - damage * 0.82
            } else {
                patrols[zufallsGenerator].health -= damage
            }
            println(" ${name} attacks ${patrols[zufallsGenerator].name} with a laserbeam " + "\u001B[31m[$damage]\u001B[0m")

        }


        // Mitteilung wenn gegnerisches Raumschiff zerstört wurde.

        fun zerstört(list: MutableList<Enemy>) {
            if (health <= 0) {
                println("->Enemy spaceship '$name' got destroyed....")
                destroyed = true

            }
        }



    }





// println(" Enemy ship attacking all Galactic Patrol ships with a damage of $damage ")
