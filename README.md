Environnement :
- Maven 4.0
- JDK 11
Lancer l'application : 
  
  `mvn spring-boot:run`

Database : 
- Modifier le fichier application.properties selon la DB et les identifiantes
- Modifier update en create pour créer les tables

Routes de l'API:
- http://localhost:8080/auth/signup : Enregistrer un nouvel utilisateur 
- http://localhost:8080/auth/login : Se connecter à l'aide du username et du password
- http://localhost:8080/api/users : Retourne la liste des utilisateurs (méthode GET)
- http://localhost:8080/api/users{id} : Retourne un utilisateur (méthode GET)
- http://localhost:8080/api/users/save : Enregistre un utilisateur (méthode POST)
- http://localhost:8080/api/users/update : Enregistre un utilisateur (méthode PUT)
- http://localhost:8080/api/users/delete/{id} : Enregistre un utilisateur (méthode DELETE)

  
