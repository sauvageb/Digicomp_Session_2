import Attack from "./attack.js";
import Pokemon from "./pokemon.js";

const staticAttack = new Attack('Statique', 10);
const thunderbolt = new Attack('Paratonerre', 25);
const adaptability = new Attack('Adaptabilité', 15);
const anticipation = new Attack('Anticipation', 30);

const pikachu = new Pokemon('Pikachu', 25, 40, 6, 'Electrique', 82, staticAttack, thunderbolt);
const eevee = new Pokemon('Evoli', 133, 30, 6.5, 'Normal', 70, adaptability, anticipation);

pikachu.displayInfo();
eevee.displayInfo();

let currentAttacker = Math.random() < 0.5 ? pikachu : eevee;
let currentDefender = currentAttacker === pikachu ? eevee : pikachu;

console.log(`Le tirage au sort a décidé que ${currentAttacker.name} attaquera en premier. \n`);

while (!pikachu.isKO() && !eevee.isKO()) {
    currentAttacker.attack(currentDefender);

    if (currentDefender.isKO()) {
        console.log(`\n#### ${currentDefender.name} est KO ! ####\n`);
        break;
    }

    // Switch attacker and defender
    [currentAttacker, currentDefender] = [currentDefender, currentAttacker];
}

if (pikachu.isKO()) {
    console.log(`${eevee.name} gagne avec ${eevee.healthPoints} points restants !`);
} else if (eevee.isKO()) {
    console.log(`${pikachu.name} gagne avec ${pikachu.healthPoints} points restants !`);
}