class Pokemon {

    constructor(name, pokedexNumber, height, weight, type, healthPoints, attack1, attack2) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.healthPoints = healthPoints;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.maxHealthPoints = healthPoints;
    }

    displayInfo() {
        console.log(`${this.name} a ${this.healthPoints} pts de vie.`);
    }

    attack(otherPokemon) {
        let attackToUse = this.healthPoints <= this.maxHealthPoints * 0.2 ? this.attack2 : this.attack1;
        let damage = attackToUse.getDamage();
        console.log(`${this.name} attaque ${otherPokemon.name} ! (${attackToUse.name} -${damage} pts) ${attackToUse.isCriticalHit() ? 'x2' : ''}`);

        otherPokemon.takeDamage(damage);
    }

    takeDamage(damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) this.healthPoints = 0;
        console.log(`${this.name} a désormais ${this.healthPoints}/ ${this.maxHealthPoints} pts de vie .`);
    }

    isKO() {
        return this.healthPoints <= 0;
    }
}