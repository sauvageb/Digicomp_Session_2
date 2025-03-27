class Attack {

    constructor(name, damage) {
        this.name = name;
        this.damage = damage;
    }

    isCriticalHit() {
        return Math.random() < 0.1;  // 10% chance
    }

    getDamage() {
        return this.isCriticalHit() ? this.damage * 2 : this.damage;
    }
}
