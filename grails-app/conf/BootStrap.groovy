import friendsofmine.Adresse
import friendsofmine.Gestionnaire
import friendsofmine.JeuTestMuseeService
import friendsofmine.JeuTestService
import friendsofmine.Musee
import friendsofmine.Utilisateur

class BootStrap {

    //JeuTestService jeuTestService
    JeuTestMuseeService jeuTestMuseeService

    def init = { servletContext ->
/*
        jeuTestService.createJeuTestForUtilisateurs()
        jeuTestService.createJeuTestFoActivite()
        jeuTestService.createJeuTestForInscription()
        */
        jeuTestMuseeService.createJeuTestFoMusee()
       /* jeuTestMuseeService.createJeuTestForAdresse()
        jeuTestMuseeService.createJeuTestFoMusee()*/

/*
        Adresse adresse1 = new Adresse(numero: "21", rue: "Rue de Metz", codePostal: "31000", ville: "Toulouse").save()
        Adresse adresse2 = new Adresse(numero: "35", rue: "Allée Jules Guesde", codePostal: "31400", ville: "Toulouse").save()
        Adresse adresse3 = new Adresse(numero:"13", rue:"Rue de la Pleau",codePostal: "31000", ville: "Toulouse").save()
        Gestionnaire gestionnaire1 = new Gestionnaire(nom: "gustave").save()
        Gestionnaire   gestionnaire2 = new Gestionnaire(nom: "roger").save()
        Musee  musee1 = new Musee(nomMusee: "Musée des Augustins", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,19:00",gestionnaire: gestionnaire1, adresseMusee: adresse1)

        Musee  musee2 = new Musee(nomMusee: "Muséum de Toulouse", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00",gestionnaire: gestionnaire2, adresseMusee: adresse2)

        Musee musee3 = new Musee(nomMusee: "Musée Paul Dupuy", telMusee: "05050505", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,17:00",gestionnaire: gestionnaire2, adresseMusee: adresse3)
*/
/*
        Adresse adresse1 = new Adresse(numero: "03", rue: "Grande Rue", codePostal: "31400", ville: "Toulouse")
        adresse1.save()
        Adresse adresse2 = new Adresse(numero: "10", rue: "Petite Rue", codePostal: "31400", ville: "Toulouse")
        adresse2.save()

        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Zlatan")
        unGestionnaire.save()

        Musee unMusee1 = new Musee(nomMusee: "Musée 1",telMusee:"05050505",accesMetro:"Jean Jaures",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00",gestionnaire: unGestionnaire, adresseMusee: adresse1)
        unMusee1.save()
        Musee unMusee2 = new Musee(nomMusee: "Musée 2",telMusee:"060606006",accesMetro:"Jaures Jean",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00",gestionnaire: unGestionnaire, adresseMusee: adresse2)
        unMusee2.save()*/




    }
    def destroy = {
    }
}
