package friendsofmine

/**
 * Created by Max on 14/04/2015.
 */
class JeuTestMuseeService {

    MuseeService museeService

    Musee musee1
    Musee musee2
    Musee musee3
    Musee musee4
    Musee musee5
    Musee musee6
    Musee musee7

    Gestionnaire gestionnaire1
    Gestionnaire gestionnaire2
    Gestionnaire gestionnaire3
    Gestionnaire gestionnaire4
    Gestionnaire gestionnaire5

    Adresse adresse1
    Adresse adresse2
    Adresse adresse3
    Adresse adresse4
    Adresse adresse5
    Adresse adresse6
    Adresse adresse7


    def createJeuTestFoMusee() {
        if (Musee.count() == 0) {
           /* adresse1 = new Adresse(numero: "13", rue: "grande Rue", codePostal: "31000", ville: "Toulouse").save()
            gestionnaire1 = new Gestionnaire(nomGestionnaire: )*/
            adresse1 = new Adresse(numero: "21", rue: "Rue de Metz", codePostal: "31000", ville: "Toulouse").save()
            adresse2 = new Adresse(numero: "35", rue: "Allée Jules Guesde", codePostal: "31400", ville: "Toulouse").save()
            adresse3 = new Adresse(numero:"13", rue:"Rue de la Pleau",codePostal: "31000", ville: "Toulouse").save()
            adresse4 = new Adresse(numero: 2,rue: "RUE DES ARCHIVES",codePostal: "31500",ville: "Toulouse").save()
            adresse5 = new Adresse(numero: 5,rue: "RUE SAINT PANTALEON",codePostal: "31000",ville: "Toulouse").save()
            adresse6 = new Adresse(numero: 69,rue: "RUE PARGAMINIERES",codePostal: "31000",ville: "Toulouse").save()
            adresse7 = new Adresse(numero: 31,rue: "RUE DE LA FONDERIE",codePostal: "31000",ville: "Toulouse").save()

            gestionnaire2 = new Gestionnaire(nomGestionnaire: "Structure commerciale").save()
            gestionnaire3 = new Gestionnaire(nomGestionnaire: "Mairie de Toulouse - DGA Culture").save()
            gestionnaire4 = new Gestionnaire(nomGestionnaire: "Association").save()
            gestionnaire5 = new Gestionnaire(nomGestionnaire: "Autre institution publique").save()

            musee1 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Musée des Augustins", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,19:00", adresseMusee: adresse1), gestionnaire3)
            musee2 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Muséum de Toulouse", telMusee: "05060705", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00", adresseMusee: adresse2), gestionnaire2)
            musee3 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Musée Paul Dupuy", telMusee: "05458605", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00", adresseMusee: adresse3), gestionnaire2)
            musee4 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "ARCHIVES MUNICIPALES TOULOUSE", telMusee: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38", horairesMusee: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", adresseMusee: adresse4), gestionnaire3)
            musee5 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE", telMusee: "05 61 23 30 49", accesMetro: "Capitole (A), Jean Jaurès (B)", accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80", horairesMusee: "Ouvert du mardi au samedi de 13h à 19hfermé les dimanches", adresseMusee: adresse4), gestionnaire4)
            musee6 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "ENSEMBLE CONVENTUEL DES JACOBINS", telMusee: "05 61 22 21 92", accesMetro: "Esquirol, Capitole (A)", accesBus: "ncv, 2, 10, 12, 14, 38, 78, 80", horairesMusee: "Ouvert tous les jours de 9h à 19h.", adresseMusee: adresse5), gestionnaire3)
            musee7 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE - SALLE TOLOSA", telMusee: "05 61 36 81 12", accesMetro: "Carmes (B)", accesBus: "2, 38", horairesMusee: "Ouvert le premier vendredi de chaque mois de 18h à 20h.", adresseMusee: adresse6), gestionnaire5)

        }

    }
}
