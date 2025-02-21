## Versionning :
- https://semver.org/lang/fr/

## Spring : 
- https://roadmap.sh/spring-boot
- https://www.rameshfadatare.com/cheat-sheet/spring-and-spring-boot-annotations-cheat-sheet/
- https://www.jrebel.com/sites/rebel/files/pdfs/cheatsheet-jrebel-spring-annotations.pdf
- https://spring.io/guides
- https://www.baeldung.com/rest-http-put-vs-post





# https://github.com/sauvageb/Digicomp_Session_2

# Intellij IDEA Community Edition (Java 17 + Maven)

# XAMPP (Base de donnees MySQL + PhpMyAdmin)

# Git et Git Bash

# Postman ou Bruno

# draw.io (Diagrammes UML)

# Les grands principes :
-- YAGNI (You Ain't Gonna Need It)
-- KISS  (Keep It Simple, Stupid)
-- DRY   (Don't Repeat Yourself)

-- SOLID :
--- Single responsibility Principle (SRP)
-----> Une classe doit avoir une responsabilite unique

--- Open/Close Principle (OCP)
-----> ouvert a l'extension, fermé a la modification

--- Liskov Substituion Principle (LSP)
-----> Substituion des sous-classes à leurs classes parents


--- Interface Segregation Principle (ISP)
-----> Plusieurs petites interfaces, plutôt qu'une grande

--- Dependancy Inversion Principle (DIP)
-----> Inversion des dépendances
-----> Dépendre d'abstractions plutôt que d'implémentations concrétes

(GRASP) : General responsibility assignment software patterns
- Créateur
- Contrôleur
- Forte cohesion
- Faible couplage

-- SOC : Seperation of Concerns
-----> Séparer les responsabilitees : 
-----> Par exemple, MVC : Model View Controller

-- COC : Convention over Configuration
-----> Favoriser des choix par défaut

-- TDD : Test Driven Development
-----> Pratique de développement où l'on écrit les tests avant le code 

-- BDD : Behaviour Driven Development
-----> Extension du TDD, avec une orientation métier
// GIVEN
// WHEN
// THEN

-- DDD : Domain Driven Design
-----> Conception logicielle qui se concentre sur le métier

# Dépendances utilisées
- Lombok    -> Generer du code automatique (Boiler code)
- @Data
- @Builder
- @RequiredArgsConstructor -> utilisable du mot-clé final
- @AllArgsConstructor
- @NoArgsConstructor
- @Log
- ModelMapper - MapStruct -> Conversion (D'une entitee vers un Dto par exemple...)


# Détails Spring Boot :
-- RestTemplate : Client HTTP pour faire des appels réseau
-- Test unitaires/intégration : Tests techniques automatisées
-- @Scheduled : permet de programmer le déclenchement de code java (batch, appels réseau ou autre)

# Qualité de code :
- SonarQube : Solution pour vérifier et contrôler la qualité de code
- ArchUnit  -> Tester l'architecture technique

