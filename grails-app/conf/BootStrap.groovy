import friendsofmine.Adresse
import friendsofmine.Gestionnaire
import friendsofmine.JeuTestService
import friendsofmine.Musee
import friendsofmine.Utilisateur

class BootStrap {

    //JeuTestService jeuTestService

    def init = { servletContext ->
/*
        jeuTestService.createJeuTestForUtilisateurs()
        jeuTestService.createJeuTestFoActivite()
        jeuTestService.createJeuTestForInscription()
*/
        Adresse adresse1 = new Adresse(numero: "03", rue: "Grande Rue", codePostal: "31400", ville: "Toulouse")
        adresse1.save()
        Adresse adresse2 = new Adresse(numero: "10", rue: "Petite Rue", codePostal: "31400", ville: "Toulouse")
        adresse2.save()

        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Zlatan")
        unGestionnaire.save()

        Musee unMusee1 = new Musee(nomMusee: "Musée 1",telMusee:"05050505",accesMetro:"Jean Jaures",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00",gestionnaire: unGestionnaire, adresseMusee: adresse1)
        unMusee1.save()
        Musee unMusee2 = new Musee(nomMusee: "Musée 2",telMusee:"060606006",accesMetro:"Jaures Jean",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00",gestionnaire: unGestionnaire, adresseMusee: adresse2)
        unMusee2.save()

    }
    def destroy = {
    }
}
