# Emergency Services API

API de gestion des services d'urgence pour les casernes de pompiers et les résidents.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)

## 📋 Description

API Java permettant la gestion des informations des casernes de pompiers et des résidents, incluant :
- Données des résidents par caserne
- Informations sur les enfants
- Alertes téléphoniques
- Antécédents médicaux
- Gestion des urgences liées aux inondations

## 🛠 Technologies
- Java
- Spring Boot
- Maven
- MySQL

## 📡 API Endpoints

```
GET /firestation?stationNumber=<station_number>
GET /childAlert?address=<address>
GET /phoneAlert?firestation=<firestation_number>
GET /fire?address=<address>
GET /flood/stations?stations=<list_of_station_numbers>
GET /personinfo?firstName=<firstName>&lastName=<lastName>
GET /communityEmail?city=<city>
```

## 📥 Installation

1. Cloner le projet
```bash
git clone https://github.com/votre-utilisateur/EmergencyServices.git
```

2. Accéder au répertoire
```bash
cd EmergencyServices
```

3. Installer les dépendances
```bash
mvn install
```

4. Lancer l'application
```bash
mvn spring-boot:run
```

## 🔍 Fonctionnalités

- Liste des résidents par caserne
- Alertes pour enfants par adresse
- Alertes téléphoniques par caserne
- Informations détaillées des résidents
- Gestion des inondations par caserne
- Recherche d'informations personnelles
- Gestion des emails communautaires

## 📝 License

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## 📧 Contact

[Oujjet)

Projet: [https://github.com/votre-utilisateur/EmergencyServices](https://github.com/votre-utilisateur/EmergencyServices)
