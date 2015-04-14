package friendsofmine

/**
 * Created by Max on 14/04/2015.
 */
class JeuTestMuseeService {

    MuseeService museeService

    Musee musee1
    Musee musee2
    Musee musee3

    Gestionnaire gestionnaire1
    Gestionnaire gestionnaire2
    Gestionnaire gestionnaire3

    Adresse adresse1
    Adresse adresse2
    Adresse adresse3

    def createJeuTestFoMusee() {
        if (Musee.count() == 0) {
            adresse1 = new Adresse(numero: "21", rue: "Rue de Metz", codePostal: "31000", ville: "Toulouse").save()
            adresse2 = new Adresse(numero: "35", rue: "Allée Jules Guesde", codePostal: "31400", ville: "Toulouse").save()
            adresse3 = new Adresse(numero:"13", rue:"Rue de la Pleau",codePostal: "31000", ville: "Toulouse").save()
            gestionnaire1 = new Gestionnaire(nom: "gustave").save()
            gestionnaire2 = new Gestionnaire(nom: "roger").save()
            musee1 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Musée des Augustins", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,19:00", adresseMusee: adresse1), gestionnaire1)
            musee2 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Muséum de Toulouse", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00", adresseMusee: adresse2), gestionnaire2)
            musee3 = museeService.insertOrUpdateMuseeForGestionnaire(new Musee(nomMusee: "Musee Paul Dupuy", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00", adresseMusee: adresse3), gestionnaire2)

        }

    }

}
