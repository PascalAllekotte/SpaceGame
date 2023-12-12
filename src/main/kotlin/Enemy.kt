package Patrol

import enemies
import patrols


class Enemy(val name: String, var health: Double, var attack: Double, var defense: Boolean, var destroyed: Boolean, var enemy: Boolean, var level: Int, var armor: Double, var isBoss: Boolean) : Ship(name, health, attack, false, true,false) {






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
            if (runden % 2 == 0) {
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
        }
    private var runden : Int = 0
    fun specialAttackeBoss2() {
        runden++
        if (runden % 3 == 0){
            enemies.forEach { it.defense = true }
            println("Boss turns defensive mode.")
            println("Boss spawns a ship!")
            enemies.add(
                Enemy("Undercover", 50.0, 75.0, false, false, false, 2, 0.0, false))

        } else {
            enemies.forEach { it.defense = false }
        }
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
