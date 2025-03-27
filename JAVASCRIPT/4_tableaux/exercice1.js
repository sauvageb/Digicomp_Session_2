console.log("Exercice 1");

const data = ["william", "jones", "aaron", "seppe", "frank", "gilliam"];

// 1 - Transformer les valeurs du tableau en majuscules
// map
const result = data.map(name => name.toUpperCase());
console.log(result);

// forEach + log
data.forEach(x => console.log(x.toUpperCase()));

// 2 - A partir du tableau, creer un tableau contenant les noms de plus de 5 lettres
const  resultData = data.filter(v => v.length > 5);
console.log(resultData);