import Person from "./Person.js";

let persons = [
    new Person('Sarah', 4),
    new Person('Eva', 32),
    new Person('Victor', 40),
    new Person('Arthur', 29),
    new Person('Maeva', 55),
    new Person('Alix', 25)
];
console.log(persons);

// 1 Afficher le tableau dans l’ordre décroissant en fonction de l’âge
const result1 = persons.sort((a,b) => b.age - a.age);
console.log(result1);

// 2 Afficher un nouveau tableau ne contenant pas les personnes entre 18 et 26 ans
const result2 = persons.filter(p => p.age < 18 || p.age > 26);
console.log(result2);

// 3 Affichez un nouveau tableau contenant uniquement les âges des personnes
const result3 = persons.map(p => p.age);
console.log(result3);

const result3Bis = Array.from(persons, p => p.age);
console.log(result3Bis);

// 4 Créez un nouveau tableau contenant les noms des personnes de plus de 30 ans
const result4 = persons.filter(p => p.age > 30).map(p => p.name);
console.log(result4);

const result4Bis = Array.from(persons.filter(p => p.age > 30), p => p.name);
console.log(result4Bis);

// 5 Calculez la somme des âges de toutes les personnes du tableau initial
const sum = persons.reduce((acc, p) => acc + p.age, 0);
console.log(sum);
